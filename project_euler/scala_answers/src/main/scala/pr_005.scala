package project_euler

class pr_005 //extends App
{
    // def main(args: Array[String])
    // {
    //     problema_01(List(1, 2, 3, 4))
    // }

    /** PROBLEMA 01
     *
     *  If we list all the natural numbers below 10 that are
     *  multiples of 3 or 5, * we get 3, 5, 6 and 9. The sum
     *  of these multiples is 23.
     *  Find the sum of all the multiples of 3 or 5 below 1000.
     *
     */
    def problema_001(xs : List[Int]): Int =
    {
        // Forma 1
        // xs.filter(x => x % 3 == 0 || x % 5 == 0).sum

        // Forma 2
        val ys = for ( i <- xs if i % 3 == 0 || i % 5 == 0 ) yield i
        ys.sum
    }

    /** PROBLEMA 02
     *
     * Each new term in the Fibonacci sequence is generated by adding the
     * previous two terms. By starting with 1 and 2, the first 10 terms will
     * be:
     *
     * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
     *
     * By considering the terms in the Fibonacci sequence whose values do not
     * exceed four million, find the sum of the even-valued terms.
     *
     */
    def problema_002(lim: Int) : Int =
    {
        // Dentro de funcion hay que definirla explicitamente como lazy
        lazy val fib:Stream[Int] = 0 #:: fib.scanLeft(1)(_ + _)
        val s = (fib take 40 toList).filter(x => x < lim).filter(x => x%2 == 0).sum
        s
    }

    /** PROBLEMA 003
     *
     * The prime factors of 13195 are 5, 7, 13 and 29.
     * What is the largest prime factor of the number 600851475143 ?
     *
     */
    def problema_003(x: Long) : Int =
    {
        def esPrimo(n: Long) : Boolean =
            (2 until (math.sqrt(n).toInt + 1)) forall (i => n%i != 0)

        // val list_divisores = (1 until math.sqrt(x).toInt).filter(j => x%j == 0)
        // val list_primos = list_divisores.filter(i => esPrimo(i))

        // list_primos.last


        // TODO DE UNA. SI NO LO ENTIENDES FERNANDITO, LERDO, MIRATE LAS TRES
        // LINEAS DE ARRIBA
        (1 until math.sqrt(x).toInt).filter(j => x%j == 0).filter(i => esPrimo(i)).last

        /* Mucho mas rapido primero divisores y luego primos, casi 10 veces
        mas rapido. Esta forma la dejo por curiosidad

        val list_primos = (1 until math.sqrt(x).toInt).filter(j => esPrimo(j))
        val list_divisores = list_primos.filter(j => x%j == 0)
        list_divisores.last */

        /* Copiada de internet */
        /* Practicamente igual que la mejor mia (la que dejo como definitiva),
           un poco mas rapida eso si */
        /* Para que funcione, devolver Long en vez de Int */
        /* def factors(n: Long): List[Long] =
            (2 to math.sqrt(n).toInt).find(n % _ == 0) .map(i => i.toLong :: factors(n / i)).getOrElse(List(n))

        factors(x).last */
    }

    /** PROBLEMA 004
     *
     * A palindromic number reads the same both ways. The largest palindrome
     * made from the produco of two 2-digit numbers is 9009 = 91 x 99.
     * Find the largest palindrome made from the producto or two 3-digit
     * numbers.
     *
     * Answer: 906609
     */
    def problema_004() : Int =
    {
        def esCapicua(q: Int) : Boolean =
        {
            val q_str = q.toString.map(_.asDigit)
            (q_str reverse) == (q_str)
        }
        val ys = for (i <- (999 to 900 by -1); j <- (999 to i by -1) if (esCapicua(i * j))) yield i * j
        ys max
    }

    /**
     *  PROBLEMA 5
     *  2520 is the smallest number that can be divided by each of the numbers
     *  from 1 to 10 without any remainder. What is the smallest positive
     *  number that is evenly divisible by all of the numbers from 1 to 20?
     *
     *  Args:
     *     x_lim -> cota superior en la que buscar el valor del problema
     */
    // def problema_005(x_lim: Int) : Unit =
    // {
    //     // Defino funcion esPrimo porque asi empezaremos por el numero producto
    //     // de todos los primos que haya hasta el valor maximo a probar, puesto
    //     // que ese sera el minimo comun multiplo de dichos primos
    //     def esPrimo(x: Int) : Boolean =
    //         (3 to (math.sqrt(x).toInt + 1) by 2) forall(i => x%i !=0)

    //     // prs : lista de primos desde 1 hasta x_lim
    //     // mcD : minimo comun Multiplicador de los primos
    //     // xs_lim_no_prs : numeros no primos en la lista base
    //     var prs = 1 :: 2 :: 3 :: (5 to x_lim by 2 toList).filter(j => esPrimo(j))
    //     // var mcD = prs.reduceLeft(_*_)
    //     var mcD = prs.product
    //     // var xs_lim_no_prs = 1 to x_lim filter(i => !prs.contains(i)) toList

    //     def multiplicacion(n: Int, ps: List[Int]) : Int =
    //     {
    //         println(ps + " " + n)

    //         if ((ps length) == 0)
    //             n
    //         else
    //         {
    //             var aux_h = ps head
    //             var aux_t = ps tail;
    //             if (n % aux_h == 0)
    //                 multiplicacion(n, aux_t)
    //             else
    //             {

    //                 multiplicacion(n*aux_h, aux_t)
    //             }
    //         }
    //     }

    //     // var resultado = multiplicacion(1, xs_lim_no_prs)
    //     var resultado = multiplicacion(mcD, 1 to x_lim toList)

    //     println(prs)
    //     println(mcD)
    //     // println(xs_lim_no_prs)
    //     println(resultado)

    //     // Sol : 232792560
    //              18044195
    //     //       104992512
    //     //       9699690
    //     //       2099850240
    // }

    /**
     *  PROBLEMA 5
     *  2520 is the smallest number that can be divided by each of the numbers
     *  from 1 to 10 without any remainder. What is the smallest positive
     *  number that is evenly divisible by all of the numbers from 1 to 20?
     *
     *  Args:
     *     x_lim -> cota superior en la que buscar el valor del problema
     */
    def problema_005(x: Int) : Int =
    {
        def MCD(a: Int, b: Int):Int = if (b == 0) a.abs else MCD(b, a % b)
        def mcm(a: Int, b: Int) = {
            val c = (a * b).abs / MCD(a, b)
            if (c > a) c else a  // Esto impide que lo que hallemos sea
            // realmente el mcm, pero para poder resolver el problema
            // es necesario.
        }

        (1 to x toList).reduceLeft(mcm)
    }

    def main(args: Array[String])
    {
        // println("La suma es %d".format(problema_01((0 to 999).toList)))
        // println(problema_003(600851475143L))
        // println(problema_004())
        println(problema_005(20))
    }
}
