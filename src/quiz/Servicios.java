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
        public int cont;
        
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

    public boolean validarSiExiste(String cedula, String placa,int dia){
        boolean existe = false;
        Empleados emp = new Empleados();
        Bus bs = new Bus();
       
        return existe;
    }
    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarFinal(String cedula, String placa,int dia) {
        nodo nuevo;
        nuevo = new nodo(cedula, placa,dia);
        nuevo.sig = null;
        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }
    
    public void imprimir() {
        nodo reco = raiz;
        System.out.println("Listado de todos los elementos de la cola.");
        while (reco != null) {
            System.out.print(reco.cedula + "-");
            reco = reco.sig;
        }
        System.out.println();
    }
}
