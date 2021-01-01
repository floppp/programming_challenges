(ns codewars.five-kyu.merge-sorted-test
  (:require [codewars.five-kyu.merge-sorted :as sut]
            [clojure.test :refer [deftest is]]))

(deftest test-mergesorted
  (is (= (sut/mergesorted [1 2] [3]) (range 1 4)))
  (is (= (sut/mergesorted [1 2] [3 4]) (range 1 5)))
  (is (= (sut/mergesorted [1] [2 3 4]) (range 1 5)))
  (is (= (sut/mergesorted [] [1 2 3 4]) (range 1 5)))
  (is (= (sut/mergesorted [1 2 3 4] []) (range 1 5)))
  (is (= (sut/mergesorted [] []) [])))
