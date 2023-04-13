(ns polylith.example.frontend.app.core
  (:require [polylith.example.frontend.bar.interface :as bar]
            [reagent.core :as r]
            [reagent.dom :as rdom]))

(defn app
  []
  (r/with-let [remote-response (r/atom "Loading")
               _ (bar/remote #(reset! remote-response %))]
    [:div 
     [:div (str "Local: " (bar/local))]
     [:div (str "Remote: " @remote-response)]]))

(defn ^:dev/after-load start!
  []
  (rdom/render [app] (js/document.getElementById "root")))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn init!
  []
  (start!))
