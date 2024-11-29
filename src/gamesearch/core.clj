(ns gamesearch.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.file :refer [wrap-file]]       
            [gamesearch.routes :as routes]
            [gamesearch.storage :as storage]
            ))

(def port 8080)


(defn -main [& args] ; 
   (jetty/run-jetty routes/app {:port port :join? true}))