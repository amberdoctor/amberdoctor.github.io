(defproject phil-and-amber "0.1.0-SNAPSHOT"
  :description "Simple Phil and Amber website"
  :url "http://github.com/...."
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1934"]
                 [prismatic/dommy "0.1.1"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [dst "0.1.2"]]

  :plugins [[lein-cljsbuild "0.3.2"]]

  :cljsbuild {:builds
              [{:source-paths ["src/cljs"]

                :compiler {:output-to "js/philandamber.js"
                           :optimizations :whitespace
                           :pretty-print true}}]})
