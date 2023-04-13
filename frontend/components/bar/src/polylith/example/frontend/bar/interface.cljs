(ns polylith.example.frontend.bar.interface
  (:require [polylith.example.frontend.bar.core :as core]))

(defn local []
  (core/local))

(defn remote [on-response-ready]
  (core/remote on-response-ready))
