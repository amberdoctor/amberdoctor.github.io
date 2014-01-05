(defproject phil-and-amber "0.1.0-SNAPSHOT"
  :description "Simple Phil and Amber website"
  :url "http://github.com/...."
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [prismatic/dommy "0.1.1"]
                 [hiccups "0.3.0"]]

  :plugins [[lein-cljsbuild "0.3.2"]]

  :cljsbuild {:builds
              [{:source-paths ["src/cljs"]

                :compiler {:output-to "resources/public/js/philandamber.js"
                           :optimizations :whitespace
                           :pretty-print true}}]})
