(ns pages.website-error-404
  (:require
   [reagent.core :as r]))

(defn page-404
  {:export true
   :next/page "404"}
  []
  (r/as-element
   [:h1 "404!"]))