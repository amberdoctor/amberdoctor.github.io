(ns phil-and-amber.page-templates
  (:require [dommy.core :refer [replace-contents!]]
            [phil-and-amber.routing :as routing])
  (:require-macros [dommy.macros :refer [node sel1]]))

(defn title-template []
  [:div {:id "title"}
   [:div {:id "phil"} "Phil"]
   [:div {:id "and"} "&"]
   [:div {:id "amber"} "Amber"]])

(defn menu-template [languages target]
  [:div {:id "menu"}
   (map (fn [display-name]
          [:div.language
           {:id display-name}
           display-name]) languages)])

(let [target-content-id "contents"]
  (defn app-template []
    (node [:span
           (title-template)
           (menu-template (keys routing/lang-routing) target-content-id)
           [:div {:id target-content-id} "welcome"]
           [:div {:id "footer"}]])))
