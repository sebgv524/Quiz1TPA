/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author sala304
 */
public class Servicios {

    class nodo {

        public String cedula;
        public String placa;
        public int dia;

        nodo sig;

        public nodo(String cedula, String placa, int dia) {
            this.cedula = cedula;
            this.placa = placa;
            this.dia = dia;
        }

    }//Fin clase nodo

    private nodo raiz, fondo;

    public Servicios() {
        raiz = null;
        fondo = null;
    }

    public boolean validarSiExistePorPlaca(String placa) {
        nodo reco = raiz;
        boolean existe = false;
        while (reco != null) {
            if (reco.placa.equals(placa)) {
                existe = true;
            }
        }
        return existe;
    }
    
    public boolean validarSiExistePorCedula(String cedula) {
        nodo reco = raiz;
        boolean existe = false;
        while (reco != null) {
            if (reco.cedula.equals(cedula)) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarFinal(String cedula, String placa, int dia) {
        nodo nuevo;
        nuevo = new nodo(cedula, placa, dia);
        nuevo.sig = null;
        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    public void imprimirPorPlaca(String placa) {
        nodo reco = raiz;
        System.out.println("Listado de servicios realizado por el bus: " + placa);
        while (reco != null) {
            if (reco.placa.equals(placa)) {
                System.out.print("Cedula: " + reco.cedula + "-");
                System.out.print("Dia: " + reco.dia + "-");
                reco = reco.sig;
            }
        }
        System.out.println();
    }
    
    public void imprimirPorCedula(String cedula) {
        nodo reco = raiz;
        System.out.println("Listado de servicios realizado por el empleado: " + cedula);
        while (reco != null) {
            if (reco.cedula.equals(cedula)) {
                System.out.print("Placa: " + reco.placa + "-");
                System.out.print("Dia: " + reco.dia + "-");
                reco = reco.sig;
            }
        }
        System.out.println();
    }
}
