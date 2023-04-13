(ns polylith.example.backend.rest-api.handler
  (:require [polylith.example.backend.foo.interface :as foo]))

(defn- handle
  ([status body]
   {:status (or status 404)
    :body   body})
  ([status]
   (handle status nil)))

(defn options [_]
  (handle 200))

(defn foo [_]
  (Thread/sleep (+ 1000 (rand-int 500)))
  (handle 200 {:bar (foo/foo)}))

(defn other [_]
  (handle 404 {:errors {:other ["Route not found."]}}))
