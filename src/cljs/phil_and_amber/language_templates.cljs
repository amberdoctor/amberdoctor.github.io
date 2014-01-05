(ns phil-and-amber.language-templates
  (:require [dommy.core :refer [replace-contents! attr]])
  (:require-macros [dommy.macros :refer [node sel1]]))

(defn str-to-id
  "Converts between string and keyword for ID because
  dommy is inconsistent."
  [str-var]
  (keyword (str "#" str-var)))



(defn clojure-template
  [contacts target]
  (let [new-node
        (str `(let [contacts ~(str contacts)]))]

    (replace-contents! (sel1 :#contents) (node [:div new-node]))))

(defn python-template
  [contacts target] )

;<div id='name'> Phil Doctor </div>
;<div id='email'> philip.s.doctor@gmail.com </div>
;<div id='github'> https://github.com/philipsdoctor </div>

(defn html-contact
  [{c-name :name email :email github :github}]
  [:span
   [:div {:id "name"} c-name]
   [:div {:id "email"} email]
   [:div {:id "github"} github]])

(defn html-template
  [contacts target]
  (let [html-temp (node (map html-contact contacts))]


    (let [x (.createElement js/document "div")
          y (.appendChild x (.cloneNode html-temp true))
          z (.-innerHTML y)]
      (.log js/console (str y)))

    (replace-contents! (sel1 :#contents)
                       (node [:span
                              [:div {:id "code"} "hi2"]
                              [:div {:id "output"} html-temp]])))

  )



(defn js-template
  [contacts target] )

(defn java-template
  [contacts target] )

