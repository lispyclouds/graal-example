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


(ns graal-example.core
  (:require [clj-http.lite.client :as client]
            [cheshire.core :as json])
  (:gen-class))

;; API Docs: http://dev.markitondemand.com/MODApis/Api/v2/doc

(def url "http://dev.markitondemand.com/MODApis/Api/v2/Quote/json?symbol=%s")

(defn get-stock-value-of
  [symbol]
  (let [response (-> (format url symbol)
                     (client/get)
                     (:body)
                     (json/parse-string true))]
    {:name (response :Name) :price (response :LastPrice)}))

(defn find-higest-stock
  [stocks]
  (json/generate-string
   (->> stocks
        (map get-stock-value-of)
        (sort-by :price #(> %1 %2))
        (first))
   {:pretty true}))

(defn -main
  [& args]
  (println (find-higest-stock ["AMZN" "FB" "GOOGL" "MSFT"])))

(comment
  (find-higest-stock ["FB" "GOOGL" "MSFT"]))
