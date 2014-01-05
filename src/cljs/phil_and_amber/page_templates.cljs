(ns phil-and-amber.page-templates
  (:require [dommy.core :refer [replace-contents!]]
            [phil-and-amber.data :as data])
  (:require-macros [dommy.macros :refer [node sel1]]))

(defn title-template []
  [:div {:id "title"}
   [:div {:id "phil"} "Phil"]
   [:div {:id "and"} "&"]
   [:div {:id "amber"} "Amber"]])

(defn menu-template [languages target]
  [:div {:id "menu"}
   (map (fn [{display :display template :template}]
          [:div.language
           {:onclick (partial template data/contacts target)}
           display]) languages)])

(let [target-content-id "contents"]
  (defn app-template []
    (node [:span
           (title-template)
           (menu-template data/languages target-content-id)
           [:div {:id target-content-id} "hi"]
           [:div {:id "footer"}]])))
