(ns example.main
  (:require [cljs.nodejs :as nodejs]
            ["http" :as http]
            ["request" :as request]
            ["highland" :as highland]))

(nodejs/enable-util-print!)

;;(require '["request" :as request]
;;         '["highland" :as highland])
(defn ^:export main []
  (-> (request "https://httpbin.org/ip")
      (.pipe (highland))
      (.each (fn [output]
                (print (.toString output "utf8"))))))

