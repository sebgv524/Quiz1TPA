/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author sebgv
 */
public class Consola {

    Scanner teclado = new Scanner(System.in);

    public void menuPrincipal() throws IOException {
        String op;
        String op2 = "si";
        String cedula;
        String nombreEmp;
        String placa;
        int dia;
        int i=0;
        Empleados emp = new Empleados();
        Bus bus = new Bus();
        Servicios serv = new Servicios();
        
        System.out.print("********************************************** \n"
                + "*    Bienvenido                           *\n"
                + "*******************************************\n"
                + "*   1. Registrar empleado                 *"
                + "*   2. Registrar bus                      *"
                + "*   3. Registrar servicio                 *"
                + "*   4. Servicios realizados por bus       *"
                + "*   5. Servicios tomados por empleado     *"
                + "*   6. Listado especial                   *"
                + "*   7. Historico                          *"
                + "*   8. Salir                              *"
                + "*******************************************\n");
        op = teclado.next();

        switch (op) {
            case "1":   
                while ("si".equals(op2)) {
                    System.out.println("Ingrese la cedula del empleado: ");
                    cedula = teclado.next();
                    System.out.println("Ingrese el nombre del empleado: ");
                    nombreEmp = teclado.next();
                    if (emp.validarSiExiste(cedula)) {
                        emp.insertarFinal(cedula, nombreEmp);
                    } else {
                        System.out.println("El empleado con cedula: " + cedula + " ya existe.");
                    }
                    System.out.println("¿Desea registrar otro empleado?");
                    op2 = teclado.next();
                }
                if("no".equals(op2)) {
                    menuPrincipal();
                }
                                
                break;
            case "2":
                while ("si".equals(op2)) {
                    System.out.println("Ingrese la placa del bus: ");
                    placa = teclado.next();
                    if (bus.validarSiExiste(placa)) {
                        bus.insertarFinal(i++, placa);
                    } else {
                        System.out.println("El bus con placa: " + placa + " ya existe.");
                    }
                    System.out.println("¿Desea registrar otro bus?");
                    op2 = teclado.next();
                }
                if ("no".equals(op2)) {
                    menuPrincipal();
                }
                break;
            case "3":
                while("si".equals(op2)){
                    System.out.println("Ingrese la placa del bus que realizara el servicio: ");
                    placa = teclado.next();
                    if (bus.validarSiExiste(placa)) {
                        System.out.println("Ingrese la cedula del empleado que usara el servicio: ");
                        cedula = teclado.next();    
                        if (emp.validarSiExiste(cedula)) {
                            URLs url = new URLs();
                            if (url.sePuede(cedula)) {
                                System.out.println("Ingrese el dia del servicio: ");
                                dia = teclado.nextInt();
                                serv.insertarFinal(cedula, placa, dia);
                            }
                        }
                    }
                    
                }
                break;
            case "4":
                System.out.println("Ingrese la placa del bus a consultar: ");
                placa = teclado.next();
                if (bus.validarSiExiste(placa) && serv.validarSiExistePorPlaca(placa)) {
                    serv.imprimirPorPlaca(placa);
                }
                else{
                    System.out.println("El bus con la placa " + placa + " no existe.");
                }
                break;
            case "5":
                System.out.println("Ingrese la cedula del empleado a consultar: ");
                cedula = teclado.next();
                if (emp.validarSiExiste(cedula) && serv.validarSiExistePorCedula(cedula)) {
                    serv.imprimirPorCedula(cedula);
                }
                else{
                    System.out.println("El empleado con la cedula: "+ cedula + " no existe.");
                }
                break;
            case "6":

                break;
            case "7":

                break;
            case "8":

                break;
            default:
                System.out.println("No se reconoce la opcion insertada. Intente de nuevo.");
                menuPrincipal();
        }
    }
}
