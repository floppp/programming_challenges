(ns codewars.five-kyu.merge-sorted
  (:gen-class))

(defn mergesorted
  "Mergin two sorted vectors, returning the mix sorted too."
  [a b]
  (loop [[ax & axs] a
         [bx & bxs] b
         acc        []]
    (cond
      (nil? ax) (concat acc b)
      (nil? bx) (concat acc a)
      :else (let [[nxt ms  ps] (if (< ax bx) [ax axs b] [bx a bxs])]
              (recur ms ps (into [] (concat acc [nxt])))))))

(mergesorted [1 2] [3])
(mergesorted [1 2] [3 4])
(mergesorted [1] [2 3 4])
(mergesorted [] [1 2 3 4])
(mergesorted [1 2 3 4] [])
(mergesorted [] [])
