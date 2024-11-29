(ns gamesearch.views
  (:require [gamesearch.markup :as markup]
            [gamesearch.controllers :as controllers]
            [gamesearch.storage :as storage]
            [gamesearch.apidata :as api]
  )
)


(def IMAGE_HEIGHT 320)


(defn make-button [label id]
   (str (str "<button type=\"button\" id=\"" 
        id 
        "\" >" 
        label 
        "</button>")
 ))

(defn make-disabled-button [label id]
   (str (str "<button type=\"button\" id=\"" 
        id 
        "\" disabled>" 
        label 
        "</button>")
 ))

(defn make-button-with-destination [route label id]
    (str (make-button label id)
        (controllers/switch-to-page-style route id)
    )

)


(defn make-rent-button-panel [guid]
  (let [
         rent-button (if (storage/is-game-available-to-rent guid) 
                         (make-button "Rent" (str "rent-button-" guid))
                         (make-disabled-button "In Cart" (str "rent-button-" guid)))
       ]
    (str "<div id=\"" storage/RENT_PANEL "-" guid "\"  >   "
               rent-button
         "</div><style> #" storage/RENT_PANEL "-" guid " { padding: 5px;} </style>"
          (controllers/switch-to-page-style (str "/checkout/" guid)  (str "rent-button-" guid))
         )
))




(defn make-game-panel [guid name deck image_url class]
    (str "<div class=\"" class \""> <h1 class=\"title\" >" name "</h1>"
             "<h5> " deck "</h5> <img src=\"" image_url \"" height=\" " IMAGE_HEIGHT "\" >"
        (make-rent-button-panel guid) "</div>"
             )
)



(defn make-game-panel-page [guid name deck image_url]
  (str "<html><body>" 
    (make-game-panel guid name deck image_url)
    "</body></html>"
))



(defn menu-bar []
  (let [
          menuclass  "menu-bar"
        ]              
    (str (markup/class-style {:class menuclass :width "300px" :height "50px" :color "lightblue"} ) 
         "<div class=\"" menuclass "\" >"
        (make-button-with-destination storage/SEARCH_PATH "Search" "search-button")
        (make-button-with-destination storage/CHECKOUT_PATH "Checkout" "checkout-button")
        "</div>"
   )         
))

(defn search-page []
  (let [
          buttonid "search-page-search-button"
       ]
      (str  (markup/blueclass-style)  
              "<div class=\"blueclass\" { padding: 35px;}><h1>Easy Game Rental</h1>"
               "<h4>Please enter games you wish to search for</h4><input type=\"text\""
               " id=\""  storage/SEARCH_BOX "\"  >"
               (make-button  "Search" buttonid )
               (controllers/search-params-switch-to-page-style storage/SEARCH_RESULTS_PATH buttonid)
                "</div></body></html> "))

)


(defn process-game-data [guid name deck image class]
  (let [
         _ (storage/add-to-item-cache guid name deck image)
       ]
       (make-game-panel guid name deck image class)

))

(defn search-results-page [lst]
  (let [
         ; page (api/get-search-result-data lst) ; API broken for search; use mock data
         data (storage/get-search-metroid-prime)
         gameclass "games-class"
         games (map #(process-game-data (:guid %) (:name %) (:deck %) (:medium_url (:image %)) gameclass ) data)
         gamesclass "all-games-class"
       ]

         (str "<div class=\"" gamesclass "\">" (apply str games)  
              "</div>" (markup/class-style {:class gamesclass :width "300px"  :color "aliceblue"})  
               (markup/class-style {:class gameclass :background-color "aliceblue" :border "2px solid purple"})
              )))


(defn checkout-view [lst]
   (str "<html><body>" (menu-bar)
        "<div><h4>Here are the games you are ready to rent. <button>Rent</button></h4></div>"
        (apply str (map #(make-game-panel (:guid %) (:name %) (:deck %) (:image %) "checkoutgame") lst))
     "</html></body>" )  
)
