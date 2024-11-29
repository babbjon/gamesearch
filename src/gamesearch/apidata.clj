(ns gamesearch.apidata
  "All functions for sending queries to the API.
   Some functions for manipulating the JSON."

    (:require [clojure.data.json :as json]
              [clj-http.client :as http]
            
    ))



(def API_KEY "97ae89eef5c67a9d5357f4d1c1de48484a3b0411")
(def URL_API_BASE "http://www.giantbomb.com/api/")
(def USER_AGENT "MyCustomUserAgentJJB/1.0")





(defn get-game-data [id]
(let [ response (http/get  (str URL_API_BASE "game/" id )
                          { :debug true
           	                :query-params
                            {
                            	:api_key API_KEY
                             :format "json"                                                         
                            }
                            :headers {"User-Agent" USER_AGENT}
                           })
      ]
      response
))



(defn get-search-result-data [lst]
  (let [

          paramstring (str "\"" (clojure.string/join lst " ")  "\"") 
         
           response (http/get  (str URL_API_BASE "search/" { :debug true
           	                :query-params
                            {:api_key API_KEY
                             :format "json"
                             :query  paramstring    
                             :field_list "guid,name,deck,image"
                             :resources "game"                           
                           }
                            :headers {"User-Agent" USER_AGENT}
                           }))
       ]
       response
))
