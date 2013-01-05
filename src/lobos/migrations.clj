(ns lobos.migrations
  ;; exclude some clojure built-in symbols so we can use the lobos' symbols
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  ;; use only defmigration macro from lobos
  (:use (lobos [migration :only [defmigration]]
          core
          schema)))
 
;;; Defines the database for lobos migrations
(def clongdb
  {:classname "org.postgresql.Driver"
   :subprotocol "postgresql"
   :subname "clongdb"
   :user "clong"
   :password "clong"})

(defmigration add-teams-table
  ;; code be executed when migrating the schema "up" using "migrate"
  (up [] (create clongdb
           (table :teams (integer :id :primary-key )
             (varchar :general_mgr 255 :not-null )
             (varchar :team_name 255 :not-null )
             (integer :wins)
             (integer :lossess))))
  ;; Code to be executed when migrating schema "down" using "rollback"
  (down [] (drop (table :teams ))))
