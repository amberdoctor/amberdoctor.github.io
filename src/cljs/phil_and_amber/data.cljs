(ns phil-and-amber.data
  (:require [phil-and-amber.language-templates :refer
             [clojure-template
              python-template
              html-template
              js-template
              java-template]]))

(def languages [{:display "Clojure"
                 :template clojure-template}
                {:display "Python"
                 :template python-template}
                {:display "HTML"
                 :template html-template}
                {:display "JavaScript"
                 :template js-template}
                {:display "Java"
                 :template java-template}])

(def contacts [{:name "Philip Doctor"
                :email "philip.s.doctor@gmail.com"
                :github "https://github.com/philipsdoctor"}
               {:name "Amber Doctor"
                :email "amberdoctor@gmail.com"
                :github "https://github.com/amberdoctor"}])
