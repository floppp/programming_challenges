
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

// test("#### TEST PROBLEMA 005 ####")
// {
//     assert(Main.problema_005(20) === 232792560)
// }