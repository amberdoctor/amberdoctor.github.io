(ns phil-and-amber.language-templates
  (:require [dommy.core :refer [replace-contents! attr set-html!]])
  (:require-macros [dommy.macros :refer [node sel1]]
                   [phil-and-amber.macros :refer [raw-html-template raw-python-template]]))

(defn str-to-id
  "Converts between string and keyword for ID because
  dommy is inconsistent."
  [str-var]
  (keyword (str "#" str-var)))

(defn template-pattern [[k v]]
  "This is the pattern identifier"
  {(str "\\{\\{ " (name k) " \\}\\}") {(str "{{ " (name k) " }}") v}})

(defn contact-re
  "Build a large regex and map to run against string replace"
  [contact]
  (let [remap (reduce conj (map template-pattern contact))
        new-pattern (re-pattern (clojure.string/join "|" (keys remap)))
        new-match (into {} (vals remap))]
    [new-pattern new-match]))

(defn clojure-template
  [contacts target]
  (let [new-node
        (str `(let [contacts ~(str contacts)]))]

    (replace-contents! (sel1 :#contents) (node [:div new-node]))))

(defn python-template
  [contacts target] )

(defn html-template
  [contacts target]
  (let [[pattern replacemap] (contact-re (first contacts))
        x (clojure.string/replace (raw-html-template) pattern #(get replacemap %))]

    (replace-contents! (sel1 :#contents)
                       (node [:span
                              [:div {:id "code"} [:pre x ]]]))))



(defn js-template
  [contacts target] )

(defn java-template
  [contacts target] )

