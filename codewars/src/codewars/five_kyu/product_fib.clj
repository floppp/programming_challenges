(ns codewars.five-kyu.product-fib
  (:gen-class))

(defn product-fib
  "Finding two fibonacci numbers which multiplies give us prod.
  Result must be [Fn Fn+1 true|false]"
  [prod]
  (loop [a 1
         b 1]
    (cond
      (= (*' a b) prod) [a b true]
      (> (*' a b) prod) [a b false]
      :else (recur b (+' a b)))))

(product-fib 4895)
