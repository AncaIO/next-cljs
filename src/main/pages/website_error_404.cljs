(ns pages.website-error-404
  (:require
   [reagent.core :as r]
   ["next/link" :default Link]))

(defn page-404
  {:export true
   :next/page "404"}
  [props]
  (r/as-element
   [:h1 "404!"]))