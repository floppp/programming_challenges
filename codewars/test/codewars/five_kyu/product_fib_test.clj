(ns codewars.five-kyu.product-fib-test
  (:require [codewars.five-kyu.product-fib :as pf]
            [clojure.test :refer [deftest testing is]]))

(deftest test-fst
  (testing "Fibonacci test 1"
    (is (= (pf/product-fib 4895) [55 89 true]))))
(deftest test-scd
  (testing "Fibonacci test 2"
    (is (= (pf/product-fib 5895) [89, 144, false]))))
