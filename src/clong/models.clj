(ns clong.models
  (:use korma.db
        korma.core))
 
(defdb clongdb
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "clongdb"
   :user "clong"
   :password "clong"})

;;To get the data, define entities using the defnentity macro. 
(defentity teams)
(defentity games)

(comment "sample statements:
         (insert teams (values {:id 1, :general_mgr "Josh Finken", :team_name "The Giants" :wins 0 :losses 0}) )
        ")
