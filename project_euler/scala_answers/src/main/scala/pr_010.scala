
package project_euler

object Main
{
    /**
     * PROBLEMA 006
     *
     * The sum of the squares of the first ten natural numbers is,
     *
     * 1^2 + 2^2 + ... + 10^2 = 385
     *
     * The square of the sum of the first ten natural numbers is,
     *
     * (1 + 2 + ... + 10)^2 = 552 = 3025
     *
     * Hence the difference between the sum of the squares of the
     * first ten natural numbers and the square of the sum is
     * 3025 − 385 = 2640.
     * Find the difference between the sum of the squares of the
     * first one hundred natural numbers and the square of the sum.
     */
    def problema_006(x: Int) : Int =
    {
        Math.pow((1 to x toList).sum, 2).toInt - (1 to x toList).map(i => i*i).sum
    }

    /**
     * PROBLEMA 007
     *
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
     * see that the 6th prime is 13.
     *
     *  What is the 10.001st prime number?
     */
    def problema_007(x: Int) : Int =
    {
        def esPrimo(n: Long) : Boolean =
            (2 until (math.sqrt(n).toInt + 1)) forall (i => n%i != 0)

        // val l = 1 to x filter(i => esPrimo(i))
        // l length
        //

        /////// ESTO FUNCIONA, PERO NO ME GUSTA, MUY POCO FUNCIONAL
        /////// BASTANTE EFICIENCTE, TEST -> 150 ms (aprox)
        // var numero = 0;
        // var count = 0;
        // while (count != 10002) {
        //     numero += 1
        //     if (esPrimo(numero)) count += 1
        // }
        // numero

        ////// INTENTAMOS HACERLO FUNCIONAL
        ////// AQUI CON STREAM MIO
        lazy val ps: Stream[Int] = 1 #:: Stream.from(2).filter(i => esPrimo(i))

        ////// AQUI CON STREAM COPIADO - Es mas eficiente este, sobre un 50%,
        ////// no tiene que ir a la referencia de la funcion. Pero tampoco
        /////// lo tengo muy claro, asi que dejo el mio
        // lazy val ps: Stream[Int] = 2 #:: Stream.from(3).filter(i =>
        // ps.takeWhile(j => j * j <= i).forall(i % _ > 0))

        ps(x)

        ////// AQUI CON ITERADOR (MAS EFICIENTE EL USO DE LA MEMORIA)
        // val l = 1 to x filter(i => esPrimo(i))
        // No me sale!!!!!
    }

    def main(args: Array[String])
    {
        // println(problema_006(100))
        println(problema_007(100))
    }
}

