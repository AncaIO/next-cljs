(ns pages._app)

(defn MyApp
  {:export true
   :next/style "@/styles/globals.css"
   :next/page "_app"}
  [args]
  (let [component (.-Component args)
        props (.-pageProps args)
        with-layout (or (.-getLayout component) (fn [page] page))]
    (with-layout (component props))))