(ns clong.core
  (:use ring.adapter.jetty
        ring.middleware.resource
        net.cgrand.moustache)
  (:require [ring.util.response :as rg]))
 
;;; A simple handler to show send some response to the client.
(defn index
  [req]
  (rg/response "Welcome to Clong - A site written in Clojure to manage our office ping-pong games.  Yeah know, important stuff..."))
 
;; Routes definition
(def routes
  (app
    [""] index))
 
;;; start function for starting jetty
(defn start
  ([] (start 8080)) ; port - default to 8080
  ([port] (run-jetty #'routes {:port port :join? false})))

