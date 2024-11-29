(ns gamesearch.controllers
   (:require [gamesearch.storage :as storage]))

(def PARAMNAME "mainparams")


(defn get-search-parameters []
    "This is javascript - it must be put inside SCRIPT tags."
  (str  "let elementID =\"" storage/SEARCH_BOX \"";"
        " const inputValue = document.getElementById(elementID).value; "       
     ;  // parse by space into array
        " const elementArray = inputValue.split(" "); "
     ;  // cleanse the elements (rudimentary To DO)
     ;   //  return str.match(/^[a-zA-Z0-9]+$/) !== null;
     ;   // filter out any strings that don't fit   
     ;  // consider a maximum number of parameters
        " const " PARAMNAME " = elementArray.join(\"|\"); "  
  )
)

(defn switch-to-page [route]
   (str "window.location = " route ";")
)

(defn switch-to-page-style [route id]
    (str "<script>"
         " document.getElementById(\"" id "\").onclick = function(){"
         " location.href = \"" route "\"; }; </script>")
)

  ; special javascript to read the search parameters and go
(defn search-params-switch-to-page-style [route id]
   (let [
  
        ]
      (str "<script>"
         " document.getElementById(\"" id "\").onclick = function(){"
         (get-search-parameters)
         " location.href = \"" route  PARAMNAME  "\"; }; </script>")
))