(ns phil-and-amber.app
  (:require [dommy.core :refer [replace-contents! listen! attr]]
            [phil-and-amber.page-templates :refer [app-template]]
            [phil-and-amber.routing :refer [lang-routing]]
            [cljs.core.async :as async :refer [<! >! chan put!]])
  (:require-macros [dommy.macros :refer [node sel1 sel]]
                   [cljs.core.async.macros :refer [go]]))

(defn app-loop
  [chan]
  (go
   (loop []
     (let [dispatch (->> (<! chan)
                         (.-target)
                         (.-id)
                         (get lang-routing))]
       (dispatch))
     (recur))))

(defn render-app [container]
  (let [nav-chan (chan)]
    (replace-contents! container (app-template))
    (app-loop nav-chan)
    (doseq [item (sel :.language)]
      (listen! item :click #(put! nav-chan %)))))
