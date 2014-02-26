(ns phil-and-amber.language-templates
  (:require [dommy.core :refer [replace-contents! attr set-html!]]
            [clojure.set :as cljset]
            [clojure.string :as cljstring]
            [clojure.walk :refer [keywordize-keys]])
  (:require-macros [dommy.macros :refer [node sel1]]
                   [phil-and-amber.macros :refer [raw-html-template
                                                  raw-python-template
                                                  raw-java-template
                                                  raw-js-template
                                                  raw-text-template
                                                  raw-clojure-template
                                                  lang-template]]))

; because apparently my version of cljs is out of date....
(defn enable-console-print!
  "Set *print-fn* to console.log"
  []
  (set! *print-fn*
    (fn [& args]
      (.apply js/console.log js/console (into-array args)))))
(enable-console-print!)

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

(defn add-data-to-template
  [template [pattern replacemap]]
  (cljstring/replace template pattern #(get replacemap %)))

(defn ns-and-flatten-keys
  "{ \"foo\" {:bar :baz}
  \"alpha\" {:beta :gamma}}

  will become

  {\"foo_bar\" :baz
  \"alpha_beta\" :gamma}"
  [contacts]
  (reduce merge
          (map (fn [[k v]]
                 (cljset/rename-keys v (reduce merge (map (fn [a-key] {a-key (str k "_" (name a-key))}) (keys v)))))
               contacts)))

(defn update-lang-div!
  [contacts template]
  (let [contacts-for-template (clojure.walk/keywordize-keys (ns-and-flatten-keys contacts))
        lang-template (template contacts-for-template)]
    (replace-contents! (sel1 :#contents)
                       (node [:span
                              [:div {:id "code"} [:pre lang-template]]]))))

; I would macro like below, but I can't (resolve ... ) dynamic symbols in cljs yet... :(
;(defmacro lang-template [language]
;  `(defn ~(symbol (str language "-template"))
;     [contacts# target#]
;     (update-lang-div! contacts# target# ((symbol (str "raw-" ~language "-template"))))))


(defn python-template
  [contacts]
  (update-lang-div! contacts (raw-python-template)))

(defn html-template
  [contacts]
  (update-lang-div! contacts (raw-html-template)))

(defn js-template
  [contacts]
  (update-lang-div! contacts (raw-js-template)))

(defn java-template
  [contacts]
  (update-lang-div! contacts (raw-java-template)))

(defn clojure-template
  [contacts]
  (update-lang-div! contacts (raw-clojure-template)))

(defn text-template
  [contacts]
  (update-lang-div! contacts (raw-text-template)))
