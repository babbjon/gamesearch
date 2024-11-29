(ns gamesearch.storage
  (:require [gamesearch.apidata :as apidata]
            [clojure.data.json :as json]
  )
)

; Constants
(def RENT_LIMIT 8)
(def SEARCH_PATH "/search")
(def SEARCH_RESULTS_PATH "/searchresults/")
(def SEARCH_RESULTS_ROUTE (str SEARCH_RESULTS_PATH ":lst"))

(def CART_PATH "/cart")
(def CHECKOUT_PATH "/checkout")
(def GAME_PATH_BASE "/game/")
(def GAME_ROUTE (str GAME_PATH_BASE ":id"))
(def CHECKOUT_ROUTE (str CHECKOUT_PATH "/:guid"))

(def TEST_GAME_ID "3030-4725")
(def STATUS_CODES {1 "OK" 100 "Invalid API Key" 101 "Object Not Found" 102 "Error in URL Format" 104 "Filter Error" })


; Storage - in lieu of a database
;(def rented-list (atom []))
(def cart-list(atom []))
(def search-parameters (atom []))
(def item-cache (atom {}))


; IDs for divs and other page elements
(def SEARCH_BOX "search_box_id")
(def RENT_PANEL "rent-panel-id")


(defn checkout [guid]
  (swap! cart-list conj guid)
)

(defn add-to-item-cache [guid name deck image]
   (swap! item-cache assoc (keyword guid) {:guid guid :name name :deck deck :image image} ) 
)

;; mock data for testing while 403 errors are happening
;;  since the data has internal quotation marks, it's simpler
;;  to read it from a file than to try to fix the file
(defn read-into-json [filename]
     (json/read-str (slurp filename) :key-fn keyword))

(defn get-search-metroid-prime []
   (let [
           data (read-into-json "search_metroid_prime_reduced.txt")
        ]
    (:results data)
))


(defn is-game-available-to-rent [game-id]
  (not-any? #(= game-id %)  @cart-list)
)


