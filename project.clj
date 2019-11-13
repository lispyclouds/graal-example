;   This file is part of graal-example.
;
;   graal-example is free software: you can redistribute it and/or modify
;   it under the terms of the GNU Lesser General Public License as published by
;   the Free Software Foundation, either version 3 of the License, or
;   (at your option) any later version.
;
;   graal-example is distributed in the hope that it will be useful,
;   but WITHOUT ANY WARRANTY; without even the implied warranty of
;   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
;   GNU Lesser General Public License for more details.
;
;   You should have received a copy of the GNU Lesser General Public License
;   along with graal-example. If not, see <http://www.gnu.org/licenses/>.

(defproject graal-example "0.1.0"
  :author "Rahul De <rahul@mailbox.org>"
  :description "A sample project starter compiling with GraalVM native image."
  :url "http://example.com/FIXME"
  :license {:name "LGPL 3.0"
            :url  "https://www.gnu.org/licenses/lgpl-3.0.en.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [cheshire "5.9.0"]
                 [org.martinklepsch/clj-http-lite "0.4.1"]]
  :plugins [[io.taylorwood/lein-native-image "0.3.1"]]
  :native-image {:name "graal-example"
                 :opts ["--initialize-at-build-time"
                        "--report-unsupported-elements-at-runtime"
                        "--enable-url-protocols=http"]}
  :global-vars {*warn-on-reflection* true}
  :main graal-example.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot          :all
                       :native-image {:jvm-opts ["-Dclojure.compiler.direct-linking=true"]}}})
