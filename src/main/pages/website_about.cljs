(ns pages.website-about
  (:require
   [reagent.core :as r]
   ["next/link" :default Link]))

(defn page-about
  {:export true
   :next/page "about"}
  [props]
  (r/as-element
   [:div
    [:h1 "About us"]

    [:> Link {:href "/" :passhref true} [:a "back to index"]]]))
