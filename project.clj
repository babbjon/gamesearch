(defproject gamesearch "0.1.0-SNAPSHOT"
  :description "Search a video game API and display results for rental"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [compojure "1.7.1"]
                 [ring  "1.6.3"]
                 [org.clojure/data.json "2.4.0"]
                 [clj-http "3.12.3"]
              ]
  :main ^:skip-aot gamesearch.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}}
)
             

                       
