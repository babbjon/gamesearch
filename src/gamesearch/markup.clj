(ns gamesearch.markup
  ;(:require [gamesearch.apidata :as apidata]
  ;          [hiccup.core :as hiccup]
  ;          [clojure.data.json :as json]
  ;)
)

 ;; styles

 (defn menu-style []
    (str "{ background-color: lightblue; width: 300px; height: 50px; }")
 )

(defn build-a-style [attribute-value attribute-name]
   (if attribute-value (str attribute-name ": " attribute-value ";") "")
)

 (defn class-style [attributes] ;class-in width-in height-in color-in]
   (let [
           class (if (:class attributes) (:class attributes) "")
           color (build-a-style (:color attributes) "background-color") ;  (if (:color attributes) (str "background-color: " (:color attributes) ";" )  "")
           width (build-a-style (:width attributes) "width")  ; (if (:width attributes) (str "width: " (:width attributes) ";") "")
           height(build-a-style (:height attributes) "height") ;  (or (:height attributes) "")
           border (build-a-style(:border attributes) "border") ; ) (or (:border attributes) "")
         ;  color (if (nil? color-in) "" (str "background-color: " color-in ";"))
         ;  width (if (nil? width-in) "" (str "width: " width-in ";"))
         ;  height (if (nil? height-in) "" (str "height: " height-in ";"))
         ;  border
           ;border: 5px solid red;
        ]
    (str "<style>." class "{" color width height border "}</style>"  )
 ))


 (defn blueclass-style []
   (str "<style>.blueclass{ color: blue;} </style>")
 )

 (defn allgames-style[]
   (str "{ background-color: aliceblue; width 500px; }")

 )


