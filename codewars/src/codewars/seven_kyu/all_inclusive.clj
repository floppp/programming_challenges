(ns codewars.seven-kyu.all-inclusive
  (:gen-class))

(defn contain-all-rots-thread-last
  "Function to check if all `strng` rorations are inside `arr`."
  [strng arr]
  (->> strng
       count
       range
       (map #(concat (drop % strng) (take % strng)))
       (every? (set (map #(seq %) arr)))))

(defn contain-all-rots
  "Function to check if all `strng` rorations are inside `arr`."
  [strng arr]
  (every? (set (map #(seq %) arr))
          (map #(concat (drop % strng) (take % strng))
               (range (count strng)))))

(contain-all-rots "abc" ["abc" "bca" "cab" "asdf"])

;; OTRAS SOLUCIONES
;; De todas las que hay, la única que me gusta es la siguiente. Está dividida
;; en varias funciones, y al final, hace lo mismo que he hecho yo de otra forma.
(defn rotate-s
  [s]
  (str (subs s 1) (subs s 0 1)))

(defn gen-rotations
  [s]
  (take (count s) (iterate rotate-s s)))

(defn contain-all-rots-other-user
  [strng arr]
  (every? (set arr) (gen-rotations strng)))
