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

        // test("##### TEST PROBLEMA 003 ####")
    // {
    //     assert(Main.problema_003(600851475143L) === 6857)
    // }