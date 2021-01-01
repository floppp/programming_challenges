(ns codewars.three-kyu.faberge
  (:gen-class))

(defn height
  "n => the number of eggs
   m => the number of trys m

  You should calculate maximum scyscrapper height (in floors), in
  which it is guaranteed to find an exactly maximal floor from which
  that an egg won't crack it."
  [n m]
  [1 2])


"
    + You can throw an egg from a specific floor every try
    + Every egg has the same, certain durability - if they're thrown from a certain floor or below, they won't crack. Otherwise they crack.
    + You have n eggs and m tries
    + What is the maxmimum height, such that you can always determine which floor the target floor is when the target floor can be any floor between 1 to this maximum height?"


"
Examples
--------
height 0 14 = 0
height 2 0  = 0
height 2 14 = 105
height 7 20 = 137979
Data range

n <= 20000
m <= 20000
"

