(ns pages.website-error-500
  (:require
   [reagent.core :as r]))

(defn page-404
  {:export true
   :next/page "500"}
  []
  (r/as-element
   [:h1 "500"]))