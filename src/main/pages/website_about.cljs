(ns pages.website-about
  (:require
   [reagent.core :as r]
   [shadow.next-js :as sn]
   ["next/link" :default Link]))

(defn page-about
  {:export true
   :next/page "about"}
  [props]
  (r/as-element
   [:div
    [:h1 "About us"]
    [:> Link {:href "/" :passhref true} [:a "back to index"]]]))

(defn define-page-layout
  [page]
  (r/as-element [:div {:style {:background-color "cornflowerblue"}} page])) ;;???

(sn/page-get-layout page-about define-page-layout)