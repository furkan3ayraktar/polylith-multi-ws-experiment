(ns polylith.example.backend.foo.core
  (:require [polylith.example.backend.shared.interface :as shared]))

(defn foo []
  (str "backend/foo invokes backend/shared: " (shared/shared-fn)))
