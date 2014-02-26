(ns phil-and-amber.macros
  (:require [dst.core :refer [generate-template log-error]]))

                                        ;TODO: refactor

(defmacro raw-html-template []
  `(generate-template {:template ~(slurp "./resources/langs/html") :error-handler #(prn (str "Template vars not equal " %1 " vs " %2))}))

(defmacro raw-python-template []
  `(generate-template {:template ~(slurp "./resources/langs/python") :error-handler #(prn (str "Template vars not equal " %1 " vs " %2))}))

(defmacro raw-js-template []
  `(generate-template {:template ~(slurp "./resources/langs/js") :error-handler #(prn (str "Template vars not equal " %1 " vs " %2))}))

(defmacro raw-java-template []
  `(generate-template {:template ~(slurp "./resources/langs/java") :error-handler #(prn (str "Template vars not equal " %1 " vs " %2))}))

(defmacro raw-clojure-template []
  `(generate-template {:template ~(slurp "./resources/langs/clojure") :error-handler #(prn (str "Template vars not equal " %1 " vs " %2))}))

(defmacro raw-text-template []
  `(generate-template {:template ~(slurp "./resources/langs/text") :error-handler #(prn (str "Template vars not equal " %1 " vs " %2))}))

(defmacro lang-template [language]
  `(defn ~(symbol (str language "-template"))
     [contacts# target#]
     (phil-and-amber.language-templates/update-lang-div! contacts# target# (symbol (str "raw-" ~language "-template")))))
