
import java.util.Scanner;
/*
 Entrada
 La entrada comienza con una línea que contiene el número de casos de prueba que aparecen a continuación.
 Cada caso de prueba, que se compone de dos líneas, se corresponde con una administración de lotería. La primera 
 línea tiene un único entero con el número de décimos distintos que tiene la administración (como mucho 10.000), mientras que la segunda línea
 contiene la lista con los números de cada décimo (números entre 0 y 99.999).

 Salida
 Por cada caso de prueba aparecerá una línea independiente con el número de décimos(*número de décimos pares*) que la peña podría comprar 
 de esa administración.

 Entrada de ejemplo
 1
 10
 1 2 3 4 5 6 7 8 9 10
 Salida de ejemplo
 5
 */

public class PenyaAtletica219 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numDatos = sc.nextInt();
        sc.nextLine();

        int c = 0, cNum = 0;
        int adm;

        String[] nums;
        int[] arr;
       
            while (c < numDatos) {

                adm = sc.nextInt();
                sc.nextLine();

                nums = sc.nextLine().split(" ");
                arr = new int[nums.length];
                int i = 0;
                for (String n : nums) {
                    arr[i] = Integer.parseInt(n);

                    if (arr[i] % 2 == 0) {
                        cNum++;
                    }
                    i++;
                }
                System.out.println(cNum);
                cNum = 0;
                c++;
            }       
    }
}
