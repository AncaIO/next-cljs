(ns pages.docs-slug
  (:require
   [reagent.core :as r]
   ["next/link" :default Link]))

(defn page-docs-slug
  {:next/rendering-type "static" ;; nil, "static" or "server"
   :next/route-type "dynamic" ;; skip or "dynamic"
   :next/page "docs/[slug]"}
  [props]
  (let [cljs-props (js->clj props :keywordize-keys true)]
    (r/as-element
     [:h1 "Single doc page " (get-in cljs-props [:params :slug])])))

(defn get-static-paths
  "Use for statically generating Next.js pages. Requires `:next/type static`"
  {:export true
  ;;  :async true
   }
  []
  (let [paths (clj->js {:paths [{:params {:slug "321" :id 1}}] :fallback false})]
    paths))

(defn get-static-props
  "Use for statically generating Next.js pages. Requires `:next/type static`"
  {:export true
  ;;  :async true
   }
  [ctx]
  ;; run async function
  (let [props (clj->js {:props {:params (.-params ctx)}})]
    props))

;; (defn get-serverside-props
;;   "Use for server-side rendering Next.js pages. Requires `:next/type server`"
;;   {:export true
;;    :async true}
;;   [ctx]
;;   ;; run async function
;;   (let [props (clj->js {:props {:params (.-params ctx)}})]
;;     props))