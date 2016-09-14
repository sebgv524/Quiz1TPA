
package quiz;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sala304
 */
public class Quiz {

    
    public static void main(String[] args) throws IOException {
        Scanner teclado  = new Scanner(System.in);
        Random rnd = new Random();
        String cc;
        Empleados emp = new Empleados();
        for (int i = 1; i <= 10; i++) {
            emp.insertarFinal("E"+i);   
        }
        emp.imprimir();
        Bus bu = new Bus();
        for (int i = 0; i < 10; i++) {
            bu.insertarFinal(String.valueOf(i+1), String.valueOf(rnd.nextInt(999-000)));
        }
        bu.imprimir();
    }
    
}
