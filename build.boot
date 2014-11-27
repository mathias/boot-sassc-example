(set-env!
  :dependencies '[[org.clojure/clojure       "1.6.0"       :scope "provided"]
                  [boot/core                 "2.0.0-pre27" :scope "provided"]
                  [boot-sassc                "0.0.1"       :scope "test"]
                  [tailrecursion/boot-useful "0.1.3"      :scope "test"]]
    :src-paths #{"sass/"})

(require '[tailrecursion.boot-useful :refer :all])
(require '[boot-sassc.core :refer :all])

(def +version+ "0.0.1")

(useful! +version+)

(task-options!
  pom  [:project     'boot-sassc-example
        :version     +version+
        :description "Example project with Sass compilation"
        :url         "https://github.com/mathias/boot-sassc-example"
        :scm         {:url "https://github.com/mathias/boot-sassc-example"}
        :license     {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}])

(deftask compile-foundation
  "Generate CSS from the Foundation (Sass) Template"
  []
  (comp (watch) (sass :sass-file "sass/app.scss"
                      :output-to "main.css"
                      :line-numbers true
                      :source-maps true)))

(deftask simple-scss
  "Compile CSS from a simple SCSS file"
  []
  (comp (watch) (sass :sass-file "sass/main.scss")))
