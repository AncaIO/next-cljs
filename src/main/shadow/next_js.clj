(ns shadow.next-js
  (:require
   [clojure.java.io :as io]
   [cljs.compiler :as cljs-comp]
   [clojure.string :as str]))

(defn all-vars [state]
  (print state)
  (for [[ns ns-info] (get-in state [:compiler-env :cljs.analyzer/namespaces])
        ns-def (-> ns-info :defs vals)]
    ns-def))

(defn create-pages
  {:shadow.build/stage :flush}
  [state]
  (doseq [ns-def (all-vars state)
          :when (get-in ns-def [:meta :next/page])]

    (let [{:next/keys [page rendering-type route-type style]}
          (:meta ns-def)

          page-ns
          (-> ns-def :name namespace cljs-comp/munge)

          page-var
          (-> ns-def :name name cljs-comp/munge)

          ;; Y U NO DATA THIS!
          content
          (str
           (when style
             (str  "import \"" style "\""))
           "\nexport {" page-var " as default} from \"@/cljs/" page-ns ".js\""
           (when (= "dynamic" route-type)
             (str "\nexport const getStaticPaths = () => " page-ns ".get_static_paths()"))
           (when (= "static" rendering-type)
             (str "\nexport const getStaticProps = (ctx) => " page-ns ".get_static_props(ctx)"))
           (when (= "server" rendering-type)
             (str "\nexport const getServerSideProps = (ctx) => " page-ns ".get_serverside_props(ctx)")))

          out-dir
          (io/file "site" "pages")

          out-file
          (io/file out-dir (str page ".js"))]

      (io/make-parents out-file)
      (spit out-file content)))
  state)