(ns codewars.six-kyu.unique-in-order
  (:require [clojure.string :as str])
  (:gen-class))


(defn unique-in-order
  "Return a sequence with no consecutive characters being equals, using
  tail-recursive call."
  [char-seq]
  (loop [s    char-seq
         acc  []
         last ""]
    (if (empty? s)
      acc
      (recur (rest s)
             (if (= (first s) last)
               acc
               (conj acc (first s)))
             (first s)))))

(defn unique-in-order-hof
  "Return a sequence with no consecutive characters being equals, using
  higuer order funcitons."
  [char-seq]
  (if (= char-seq "")
    []
    (into [] (concat (map #(first %)
                          (filter #(not= (first %) (second %))
                                  (map vector (drop-last 1 char-seq) (rest char-seq))))
                     [(last char-seq)]))))

;; A PARTIR DE AQUÍ, SOLUCIONES ENCONTRADAS EN CODEWARS QUE ME PARECEN INTERESANTES
(defn unique-in-order-dedupe
  "La función `dedupe` justo hace lo que pide el enunciado. Su código es bastante
  complicado, al menos para mí ahora mismo. Revisar en futuro."
  [char-seq]
  (dedupe char-seq))

(defn unique-in-order-reduce
  "Solución que tenía yo en mente, TAL CUAL, cuando empecé con el código
  de `unique-in-order-hof`, pero que se fue complicando al no saber cómo
  hacerlo, llegando al final a no usar `reduce`."
  [char-seq]
  (reduce #(if (= (peek %1) %2) ;; `peek` para vectores devuelve el último valor,
             %1                 ;; mucho más eficiente que `last`.
             (conj %1 %2))
          []
          char-seq))

(defn unique-in-order-partition-by
  "Muy elegante, es igual que uno de los ejemplos de la documentación de clojure en:
  https://clojuredocs.org/clojure.core/identity.
  aunque no es muy evidente: lo que hace es, al pasarse `identity` como función para
  partir, separa por los distintos grupos de identidades que encuentra. Luego
  simplemente cogemos el primer elemento de cada uno y ya está."
  [char-seq]
  (map first (partition-by identity char-seq)))

;;
;; TESTS RÁPIDOS/PARA DEBUG
;;
(def s "aabbaaaccczzdddk")
(unique-in-order-partition-by s)
(unique-in-order s)
(unique-in-order-hof s)
(unique-in-order-hof "aAbbcddb")
