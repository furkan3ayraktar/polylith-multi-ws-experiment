(ns dev.backend.server
  (:require [polylith.example.backend.rest-api.main :as main]))

(defn start! [port]
  (main/start! port))

(defn stop! []
  (main/stop!))

(comment
  (start! 6003)
  (stop!)
  
  )
