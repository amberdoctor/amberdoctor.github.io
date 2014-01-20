(ns phil-and-amber.routing
  (:require [phil-and-amber.language-templates :refer
             [clojure-template
              python-template
              html-template
              js-template
              java-template
              text-template]]
            [phil-and-amber.data :as data]))

(def lang-routing (array-map
                   "Clojure" (partial clojure-template data/contacts)
                   "Python" (partial python-template data/contacts)
                   "HTML" (partial html-template data/contacts)
                   "JavaScript" (partial js-template data/contacts)
                   "Java" (partial java-template data/contacts)
                   "Text" (partial text-template data/contacts)))
