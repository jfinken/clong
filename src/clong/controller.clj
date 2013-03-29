(ns clong.controller
  (:use clong.templates
         clong.models
         ring.util.response))
 
(defn index
  "Index page handler"
  [req]
  (response (home-page)))

