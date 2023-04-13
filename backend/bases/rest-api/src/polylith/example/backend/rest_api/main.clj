(ns polylith.example.backend.rest-api.main
  (:require [polylith.example.backend.rest-api.api :as api]
            [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(def ^:private server-ref (atom nil))

(defn start!
  [port]
  (if-let [_server @server-ref]
    (println "Server already running? (stop!) it first.")
    (do
      (println "Starting server on port: " port)
      (api/init)
      (reset! server-ref
              (run-jetty api/app
                         {:port port
                          :join? false})))))

(defn stop! []
  (if-let [server @server-ref]
    (do (api/destroy)
        (.stop server)
        (reset! server-ref nil))
    (println "No server")))

(defn -main [& _args]
  (start! (Integer/valueOf
           (or (System/getenv "port")
               "6003")
           10)))
