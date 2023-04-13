(ns polylith.example.frontend.bar.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [polylith.example.backend.shared.interface :as shared]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]))

(defn local []
  (str "frontend/bar invokes backend/shared: " (shared/shared-fn)))

(defn remote [on-response-ready]
  (go (let [response (<! (http/get "http://localhost:6003/api/foo" {:with-credentials? false}))]
        (on-response-ready (-> response :body :bar)))))
