(ns shadow.next-js
  (:require [goog.object :as gobj]))


;; Page.getLayout = function getLayout(page: ReactElement) {
;;   return (
;;     <Layout>
;;       <NestedLayout>{page}</NestedLayout>
;;     </Layout>
;;   )
;; }

(defn page-get-layout [page-fn query-fn]
  (gobj/set page-fn "getLayout" (fn [req]
                                  (query-fn req))))