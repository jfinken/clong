(ns clong.templates
  (:use [net.cgrand.enlive-html]))
 
(deftemplate home-page "index.html" []
  [:title] (content "Clong"))

