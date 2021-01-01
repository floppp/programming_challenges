(ns codewars.four-kyu.strip-comments
  (:require [clojure.string :as str])
  (:gen-class))

(defn strip-comments-
  "Striping all text that follows any of a set of comment markers passed in.
  Any whitespace at the end of the line should also be stripped out."
  ;; ESTA VERSIÓN, MÁS CONCISA Y ELEGANTE, TIENE PROBLEMAS PARA TRATAR
  ;; CIERTOS CARACTERIES ESPECIALES COMO SIMPLES CARACTERES SIN ESCAPAR.
  ;; DE AHÍ LA EXISTENCIA DE LA OTRA VERSIÓN.
  [text comment-symbols]
  ;; Creamos lista de funciones
  (let [fs (mapv (fn[p] #(first (str/split % (re-pattern p))))
                 comment-symbols)]
    ;; Aplicamos secuencialmente la lista de funciones a cada línea y finalmente
    ;; unimos para cumplir con los requisitos del problema.
    (str/join "\n"
              (map (fn[l] (str/trimr (reduce #(%2 %1) l fs)))
                   (str/split-lines text)))))

(defn strip-comments
  "Striping all text that follows any of a set of comment markers passed in.
  Any whitespace at the end of the line should also be stripped out."
  [text comment-symbols]
  ;; Creamos lista de funciones
  (let [fs (mapv (fn[p] #(subs % 0 (if (nil? (str/index-of % p))
                                     (count %)
                                     (str/index-of % p))))
                 comment-symbols)]
    ;; Aplicamos secuencialmente la lista de funciones a cada línea y finalmente
    ;; unimos para cumplir con los requisitos del problema.
    (str/join "\n"
              (map (fn[l] (str/trimr (reduce #(%2 %1) l fs)))
                   (str/split-lines text)))))


(strip-comments "a #b\nc\nd $e f g"
                '("#" "$"))
(strip-comments "apples, pears # and bananas\ngrapes\nbananas !apples"
                '("#" "!"))
