(ns phil-and-amber.app
  (:require [dommy.core :refer [replace-contents! listen! attr]]
            [phil-and-amber.page-templates :refer [app-template]])
  (:require-macros [dommy.macros :refer [node sel1 sel]]))

(defn lang-dispatch
  [element event]
  (attr element "data-lang-name"))

(defn render-app [container]
  (replace-contents! container (app-template))
  (doseq [item (sel :.language)]
    (listen! item :click (partial lang-dispatch item))))