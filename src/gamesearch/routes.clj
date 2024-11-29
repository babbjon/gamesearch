(ns gamesearch.routes
   (:require [compojure.core :as compojure]
             [compojure.route :as compojure-route]
             [gamesearch.handlers :as handlers]
             [gamesearch.views :as views]
             [gamesearch.storage :as storage]
   )
)


(compojure/defroutes app
    (compojure/GET "/" params  handlers/search-page)
    (compojure/GET  storage/SEARCH_PATH  params handlers/search-page)
    (compojure/GET  storage/SEARCH_RESULTS_ROUTE  params handlers/searchresults-page)
    (compojure/GET  storage/CHECKOUT_ROUTE   params handlers/checkout-page)
    (compojure/GET  storage/CHECKOUT_PATH   params handlers/checkout-view-page)
  
    (compojure-route/not-found  (str (views/menu-bar) "Page not found"))
)


