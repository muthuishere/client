(ns wh.login.github-callback.db
  (:require [cljs.spec.alpha :as s]))

(s/def ::error? (s/nilable map?))
(s/def ::callback-status #{:sent :fail :success})
(s/def ::sub-db (s/keys :opt-un [::error ::callback-status]))
(def default-db {:error nil})

(defn already-connected? [error]
  (= "github-connected-to-another-account"
     (:message error)))