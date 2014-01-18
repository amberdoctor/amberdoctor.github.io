(ns phil-and-amber.macros)

(defmacro raw-html-template []
  (slurp "./resources/langs/html"))

(defmacro raw-python-template []
  (slurp "./resources/langs/python"))

(defmacro raw-js-template []
  (slurp "./resources/langs/python"))

(defmacro raw-java-template []
  (slurp "./resources/langs/python"))

(defmacro lang-template [language]
  `(defn ~(symbol (str language "-template"))
     [contacts# target#]
     (phil-and-amber.language-templates/update-lang-div! contacts# target# (symbol (str "raw-" ~language "-template")))))
