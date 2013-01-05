(defproject clong "1.0.0-SNAPSHOT"
  :description "clong: a site that tracks our office ping-pong games.
                Important stuff..."
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring "1.1.6" 
                   ;;; Exclude the clojure, clj-stacktrace from ring dependency
                   :exclusions [org.clojure/clojure
                               clj-stacktrace]]
                 [net.cgrand/moustache "1.1.0"]
                 [lobos "1.0.0-SNAPSHOT"]
                 [korma "0.3.0-beta7"]
                 [enlive "1.0.1"]
                 [postgresql "9.1-901.jdbc4"]
                 [clj-yaml "0.4.0"]  
                ])
