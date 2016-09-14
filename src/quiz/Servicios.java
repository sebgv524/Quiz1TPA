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
        public String codigo;
        public int dia;
        
        nodo sig;

        public nodo(String cedula, String codigo, int dia) {
            this.cedula = cedula;           
            this.codigo = cedula;           
            this.dia = dia;           
        }

    }//Fin clase nodo

    private nodo raiz, fondo;

    public Servicios() {
        raiz = null;
        fondo = null;
    }

    public boolean validarSiExiste(String cedula, String codigo){
        boolean existe = false;
        Empleados emp = new Empleados();
        Bus bs = new Bus();
//        if(){
//            
//        }
        return existe;
    }
    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarFinal(String cedula, String codigo) {
        nodo nuevo;
        nuevo = new nodo(cedula, codigo);
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
