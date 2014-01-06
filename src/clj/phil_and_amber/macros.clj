(ns phil-and-amber.macros)

(defmacro raw-html-template []
  (slurp "./resources/langs/sample.html"))

(defmacro raw-python-template []
  (slurp "./resources/langs/sample.html"))
