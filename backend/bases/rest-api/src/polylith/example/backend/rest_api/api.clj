(ns polylith.example.backend.rest-api.api
  (:require [polylith.example.backend.rest-api.handler :as h]
            [polylith.example.backend.rest-api.middleware :as m]
            [compojure.core :refer [routes defroutes GET ANY OPTIONS]]
            [ring.logger.timbre :as logger]
            [ring.middleware.json :as js]
            [ring.middleware.keyword-params :as kp]
            [ring.middleware.multipart-params :as mp]
            [ring.middleware.nested-params :as np]
            [ring.middleware.params :as pr]))

(defroutes public-routes
  (OPTIONS "/**"       [] h/options)
  (GET     "/api/foo"  [] h/foo))

(defroutes other-routes
  (ANY     "/**"       [] h/other))

(def ^:private app-routes
  (routes
    public-routes
    other-routes))

(def app
  (-> app-routes
      logger/wrap-with-logger
      kp/wrap-keyword-params
      pr/wrap-params
      mp/wrap-multipart-params
      js/wrap-json-params
      np/wrap-nested-params
      m/wrap-exceptions
      js/wrap-json-response
      m/wrap-cors))

(defn init []
  (println "Initialized server."))

(defn destroy []
  (println "Destroyed server."))
