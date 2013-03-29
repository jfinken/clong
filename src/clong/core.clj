(ns clong.core
  (:use ring.adapter.jetty
        ring.middleware.resource
        net.cgrand.moustache
        clong.controller)
  (:require [ring.util.response :as rg]))
 
;; Routes definition
(def routes
  (app
    [""] (delegate index)))
 
;;; start function for starting jetty
(defn start
  ([] (start 8080)) ; port - default to 8080
  ([port] (run-jetty #'routes {:port port :join? false})))

(defn -main
  []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (start port)))

