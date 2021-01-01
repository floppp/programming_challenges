(ns codewars.six-kyu.unique-in-order-test
  (:require [codewars.six-kyu.unique-in-order :as uio :refer :all]
            [clojure.test :refer [deftest is testing]]))

(deftest test-unique-in-order
  (testing "empty"
    (is (= (uio/unique-in-order "aabbaaccczzddda") [\a \b \a \c \z \d \a]))
    (is (= (uio/unique-in-order "aAbbcddb") [\a \A \b \c \d \b]))
    (is (= (uio/unique-in-order "") []))))

(deftest test-unique-in-order-hof
  (testing "empty"
    (is (= (uio/unique-in-order-hof "aabbaaccczzddda") [\a \b \a \c \z \d \a]))
    (is (= (uio/unique-in-order-hof "aAbbcddb") [\a \A \b \c \d \b]))
    (is (= (uio/unique-in-order-hof "") []))))

(deftest test-unique-in-order-codewars-sample
  (testing "do-nothing-vector"
    (is (= (uio/unique-in-order [1 2 3]), [1 2 3])))

  (testing "do-nothing-string"
    (is (= (uio/unique-in-order "ABC"), [\A \B \C])))

  (testing "do-nothing-list"
    (is (= (uio/unique-in-order '(1 2 3)), [1 2 3])))

  (is (= (uio/unique-in-order [0 0 0 0 1 1 1 2 2 0 0 1 1 1]) [0 1 2 0 1]))
  (is (= (uio/unique-in-order "AAAABBBCCDAABBB") [\A \B \C \D \A \B])))

(deftest test-unique-in-order-hof-codewars-sample
  (testing "do-nothing-vector"
    (is (= (uio/unique-in-order-hof [1 2 3]), [1 2 3])))

  (testing "do-nothing-string"
    (is (= (uio/unique-in-order-hof "ABC"), [\A \B \C])))

  (testing "do-nothing-list"
    (is (= (uio/unique-in-order-hof '(1 2 3)), [1 2 3])))

  (is (= (uio/unique-in-order-hof [0 0 0 0 1 1 1 2 2 0 0 1 1 1]) [0 1 2 0 1]))
  (is (= (uio/unique-in-order-hof "AAAABBBCCDAABBB") [\A \B \C \D \A \B])))

;; TEST PARA CÓDIGO NO MÍO
(deftest test-unique-in-order-dedupe
  (testing "empty"
    (is (= (uio/unique-in-order-dedupe "aabbaaccczzddda") [\a \b \a \c \z \d \a]))
    (is (= (uio/unique-in-order-dedupe "aAbbcddb") [\a \A \b \c \d \b]))
    (is (= (uio/unique-in-order-dedupe "") []))
    (is (= (uio/unique-in-order-dedupe [1 2 3]), [1 2 3]))
    (is (= (uio/unique-in-order "ABC"), [\A \B \C]))
    (is (= (uio/unique-in-order '(1 2 3)), [1 2 3]))
    (is (= (uio/unique-in-order [0 0 0 0 1 1 1 2 2 0 0 1 1 1]) [0 1 2 0 1]))
    (is (= (uio/unique-in-order "AAAABBBCCDAABBB") [\A \B \C \D \A \B]))))
