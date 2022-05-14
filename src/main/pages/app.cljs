(ns pages.app
  (:require [goog.object :as gobj]))

#_(defn get-methods
    [obj]
    (-> obj
        (js/Object.getOwnPropertyNames)
        (.filter #(fn? (gobj/get obj %)))))

(defn MyApp
  {:export true
   :next/style "@/styles/globals.css"
   :next/page "_app"}
  [args]
  (let [component (.-Component args)
        props (.-pageProps args)
        with-layout (or
                     (gobj/get component "getLayout")
                     (fn [page]
                       page))]
    (with-layout (component props))))
