(ns shadow.next-js
  (:require
   [clojure.java.io :as io]
   [cljs.compiler :as cljs-comp]
   [clojure.string :as str]))

(defn all-vars [state]
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
             (str  "import \"" style "\"\n"))
           "import {" page-var "} from \"shadow-cljs/" page-ns "\"\n"
           "export default " page-var "\n"
           (when (= "dynamic" route-type)
             (str
              "import {get_static_paths} from \"shadow-cljs/" page-ns "\"\n"
              "\nexport const getStaticPaths = () => get_static_paths()\n"))
           (when (= "static" rendering-type)
             (str
              "import {get_static_props} from \"shadow-cljs/" page-ns "\"\n"
              "\nexport const getStaticProps = (ctx) => get_static_props(ctx) \n"))
           (when (= "server" rendering-type)
             (str
              "import {get_serverside_props} from \"shadow-cljs/" page-ns "\"\n"
              "\nexport const getServerSideProps = (ctx) => get_serverside_props(ctx)\n")))

          out-dir
          (io/file "site" "pages")

          out-file
          (io/file out-dir (str page ".js"))]

      (io/make-parents out-file)
      (spit out-file content)))
  state)