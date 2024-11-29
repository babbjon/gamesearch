(ns gamesearch.handlers
  (:require [gamesearch.apidata :as apidata]
            [clojure.data.json :as json]
            [gamesearch.views :as views]
            [gamesearch.storage :as storage]
  )
)

(defn not-found [request] ; 
  {:status   404
   :headers  {"content-type" "text/plain; charset=utf-8"}
   :body     (str "Resource not found: " (:uri request))})


(defn search-page [request] 
        (str "<html><body>"  
             (views/menu-bar)
             (views/search-page)
             "</html></body>"))


(defn searchresults-page [request]
   (let [
           paramlist "metroid|prime" ;dummy to make route work
        ]
    (str "<html><body>" 
         (views/menu-bar)
         (views/search-results-page paramlist) "</html></body>" )))





(defn checkout-view-page [request]
   (let [
          checkout-list (map #( (keyword %) @storage/item-cache ) @storage/cart-list)
        ]
           (views/checkout-view checkout-list)
        ))

(defn checkout-page [request]
   (let [
           guid (:guid (:params request))
           _ (storage/checkout guid)
           checkout-list (map #( (keyword %) @storage/item-cache ) @storage/cart-list)
        ]
    (str "<html><body>" (views/menu-bar)
        "<div><h4>Here are the games you are ready to rent. <button>Rent</button></h4></div>"
        (apply str (map #(views/make-game-panel (:guid %) (:name %) (:deck %) (:image %) "checkoutgame") checkout-list))
     "</html></body>" )
))

