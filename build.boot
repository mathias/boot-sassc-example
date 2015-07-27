(set-env!
  :dependencies '[[org.clojure/clojure "1.6.0"  :scope "provided"]
                  [boot/core           "2.1.2"  :scope "provided"]
                  [mathias/boot-sassc  "0.1.4"]
                  [adzerk/bootlaces    "0.1.11" :scope "test"]]
    :resource-paths #{"sass/"})

(require '[adzerk.bootlaces :refer :all])
(require '[mathias.boot-sassc :refer :all])

(def +version+ "0.1.0")

(bootlaces! +version+)

(task-options!
 pom  {:project     'boot-sassc-example
       :version     +version+
       :description "Example project with Sass compilation"
       :url         "https://github.com/mathias/boot-sassc-example"
       :scm         {:url "https://github.com/mathias/boot-sassc-example"}
       :license     {:name "Eclipse Public License"
                     :url  "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask compile-foundation
  "Generate CSS from the Foundation (Sass) Template"
  []
  (sass :sass-file "sass/app.scss"
        :output-to "main.css"
        :line-numbers true
        :source-maps true))

(deftask simple-scss
  "Compile CSS from a simple SCSS file"
  []
  (comp (watch) (sass :sass-file "sass/main.scss")))
