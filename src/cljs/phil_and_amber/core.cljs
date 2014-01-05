(ns phil-and-amber.core
  (:require [dommy.core :refer [replace-contents!]]
            [phil-and-amber.app :refer [render-app]])
  (:require-macros [dommy.macros :refer [node sel1]]))

; basic wiring to wait to run app until page is ready

(defn init-when-page-ready []
  (when (and js/document
             (.-getElementById js/document))
    (render-app (sel1 :#body))))

(set! (.-onload js/window) init-when-page-ready)

