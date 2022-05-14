(ns pages.website-index
  (:require
   [reagent.core :as r]
   [shadow.next-js :as sn]
   ["next/link" :default Link]))

(defn page-index
  {:export true
   :next/page "index"}
  [props]
  (r/as-element
   [:div
    [:h1 "Hi people!!!"]

    [:p "Welcome to your new next.js site."]
    [:p "Now go build something great with ClojureScript."]

    [:> Link {:href "/about"} [:a "goto page-2"]]
    [:> Link {:href "/docs/321" :passhref true} [:a "Docs 321"]]]))


(defn define-page-layout
  [page]
  (r/as-element [:div {:style {:background-color "hotpink"}} page])) ;;???

(sn/page-get-layout page-index define-page-layout)