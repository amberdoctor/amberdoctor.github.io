(ns phil-and-amber.data
  (:require [phil-and-amber.language-templates :refer
             [clojure-template
              python-template
              html-template
              js-template
              java-template
              text-template]]))

(def languages [{:display "Clojure"
                 :template clojure-template}
                {:display "Python"
                 :template python-template}
                {:display "HTML"
                 :template html-template}
                {:display "JavaScript"
                 :template js-template}
                {:display "Java"
                 :template java-template}
                {:display "Text"
                 :template text-template}])

(def contacts {"phil" {:name "Philip Doctor"
                       :email "philip.s.doctor@gmail.com"
                       :github "https://github.com/philipsdoctor"
                       :linkedin "http://www.linkedin.com/in/philipsdoctor"}
               "amber" {:name "Amber Doctor"
                        :email "amberdoctor@gmail.com"
                        :github "https://github.com/amberdoctor"
                        :linkedin "http://www.linkedin.com/in/amberdoctor"}})
