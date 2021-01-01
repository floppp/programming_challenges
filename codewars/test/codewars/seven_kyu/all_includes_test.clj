(ns codewars.seven-kyu.all-includes-test
  (:require  [codewars.seven-kyu.all-inclusive :as ainc :refer :all]
             [clojure.test :refer [testing deftest is]]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest a-test1
  (testing "contain-all-rots"
    (test-assert (ainc/contain-all-rots "bsjq" ["bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs"]) true)
    (test-assert (ainc/contain-all-rots "" []) true)
    (test-assert (ainc/contain-all-rots "" ["bsjq", "qbsj"]) true)
    (test-assert (ainc/contain-all-rots "XjYABhR" ["TzYxlgfnhf", "yqVAuoLjMLy", "BhRXjYA", "YABhRXj", "hRXjYAB", "jYABhRX", "XjYABhR", "ABhRXjY"]) false)
    (test-assert (ainc/contain-all-rots-thread-last "bsjq" ["bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs"]) true)
    (test-assert (ainc/contain-all-rots-thread-last "" []) true)
    (test-assert (ainc/contain-all-rots-thread-last "" ["bsjq", "qbsj"]) true)
    (test-assert (ainc/contain-all-rots-thread-last "XjYABhR" ["TzYxlgfnhf", "yqVAuoLjMLy", "BhRXjYA", "YABhRXj", "hRXjYAB", "jYABhRX", "XjYABhR", "ABhRXjY"]) false)

    ))
