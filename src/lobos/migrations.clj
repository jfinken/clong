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
  ;; code to be executed when migrating the schema "up" using "migrate"
  (up [] (create clongdb
           (table :teams (integer :id :primary-key )
             (varchar :general_mgr 255 :not-null )
             (varchar :team_name 255 :not-null )
             (integer :wins)
             (integer :losses))))
  ;; Code to be executed when migrating schema "down" using "rollback"
  (down [] (drop (table :teams ))))

(defmigration add-games-table
  ;; code to be executed when migrating the schema 'up' using 'migrate'
  (up [] (create clongdb
           (table :games (integer :id :primary-key)
             (integer :home_team_id)
             (integer :away_team_id)
             (timestamp :start_time (default (now)))
             (timestamp :end_time)
             (integer :winning_score)
             (integer :losing_score)
             (integer :winning_team_id))))
  (down [] (drop (table :games))))


