(ns codewars.four-kyu.strip-comments-test
  (:require [codewars.four-kyu.strip-comments :as sc]
            [clojure.test :refer [deftest are]]))

(deftest strip-comments-tests
  (are [text symbols expected] (= expected (sc/strip-comments text symbols))
    "apples, pears # and bananas\ngrapes\nbananas !apples"
    '("#" "!")
    "apples, pears\ngrapes\nbananas"

    "a #b\nc\nd $e f g"
    '("#" "$")
    "a\nc\nd"
))
