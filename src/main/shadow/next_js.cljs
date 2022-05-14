(ns shadow.next-js
  (:require [goog.object :as gobj]))


;; Page.getLayout = function getLayout(page: ReactElement) {
;;   return (
;;     <Layout>
;;       <NestedLayout>{page}</NestedLayout>
;;     </Layout>
;;   )
;; }

(defn page-get-layout
  {:export true}
  [page-fn query-fn]
  (goog.object/set
   page-fn "getLayout" (fn [layout]
                         (query-fn layout))))