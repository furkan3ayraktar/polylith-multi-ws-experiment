(ns dev.frontend.client
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]))

(comment
  (go (let [response (<! (http/get "http://localhost:6003/api/foo" {:with-credentials? false}))]
        (println "response ->" response)))
  )
