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
    String cedula;
        String nombreEmp;
        String placa;
        int dia;
        int i = 0;
        Empleados emp = new Empleados();
        Bus bus = new Bus();
        Servicios serv = new Servicios();
        listadoEsp listEsp = new listadoEsp();

    public void menuPrincipal() throws IOException {
        String op;
        String op2 = "si";
        

        System.out.print("********************************************** \n"
                + "*    Bienvenido                           *\n"
                + "*******************************************\n"
                + "*   1. Registrar empleado                 *\n"
                + "*   2. Registrar bus                      *\n"
                + "*   3. Registrar servicio                 *\n"
                + "*   4. Servicios realizados por bus       *\n"
                + "*   5. Servicios tomados por empleado     *\n"
                + "*   6. Listado especial                   *\n"
                + "*   7. Historico                          *\n"
                + "*   8. Salir                              *\n"
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
                        System.out.println("El empleado con cedula: " + cedula + " ya existe.");
                    } else {
                        emp.insertarFinal(cedula.toUpperCase(), nombreEmp);
                    }
                    System.out.println("¿Desea registrar otro empleado?");
                    op2 = teclado.next();
                }
                if ("no".equals(op2)) {
                    emp.imprimir();
                    System.out.println("");
                    menuPrincipal();
                }

                break;
            case "2":
                do {
                    System.out.println("Ingrese la placa del bus: ");
                    placa = teclado.next();
                    if (bus.validarSiExiste(placa)) {
                        System.out.println("El bus con placa: " + placa + " ya existe.");
                    } else {
                        bus.insertarFinal(i++, placa);
                    }
                    System.out.println("¿Desea registrar otro bus?");
                    op2 = teclado.next();
                } while ("si".equals(op2));
                if ("no".equals(op2)) {
                    bus.imprimir();
                    System.out.println("");
                    menuPrincipal();        
                }
                break;
            case "3":
                
                do {
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
                        else{
                            System.out.println("La cedula ingresada no existe");
                        }
                    }
                    else{
                        System.out.println("La placa ingresada no existe");
                    }
                    System.out.println("¿Desea registrar otro servicio7?");
                    op2 = teclado.next(); 
                } while ("si".equals(op2));  
                break;
            case "4":
                System.out.println("Ingrese la placa del bus a consultar: ");
                placa = teclado.next();
                if (bus.validarSiExiste(placa) && serv.validarSiExistePorPlaca(placa)) {
                    serv.imprimirPorPlaca(placa);
                } else {
                    System.out.println("El bus con la placa " + placa + " no existe.");
                }
                break;
            case "5":
                System.out.println("Ingrese la cedula del empleado a consultar: ");
                cedula = teclado.next();
                if (emp.validarSiExiste(cedula) && serv.validarSiExistePorCedula(cedula)) {
                    serv.imprimirPorCedula(cedula);
                } else {
                    System.out.println("El empleado con la cedula: " + cedula + " no existe.");
                }
                break;
            case "6":
                listEsp.insertar();
                listEsp.imprimir();
                break;
            case "7":
                String ced;
                System.out.println("Ingrese la cedula del empleado a consultar: ");
                ced = teclado.next();
                Historico h = new Historico(ced.toUpperCase());
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("No se reconoce la opcion insertada. Intente de nuevo.");
                menuPrincipal();
        }
    }
}
