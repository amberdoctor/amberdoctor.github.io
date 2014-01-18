(ns phil-and-amber.macros)

(defmacro raw-html-template []
  (slurp "./resources/langs/html"))

(defmacro raw-python-template []
  (slurp "./resources/langs/python"))

(defmacro raw-js-template []
  (slurp "./resources/langs/js"))

(defmacro raw-java-template []
  (slurp "./resources/langs/java"))

(defmacro raw-clojure-template []
  (slurp "./resources/langs/clojure"))

(defmacro raw-text-template []
  (slurp "./resources/langs/text"))

(defmacro lang-template [language]
  `(defn ~(symbol (str language "-template"))
     [contacts# target#]
     (phil-and-amber.language-templates/update-lang-div! contacts# target# (symbol (str "raw-" ~language "-template")))))
