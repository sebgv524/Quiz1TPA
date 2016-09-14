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
public class Empleados {
    
     class nodo {
        public String cedula;
        
        nodo sig;

        public nodo(String cedula) {
            this.cedula = cedula;
            
        }

    }//Fin clase nodo

    private nodo raiz, fondo;

    public Empleados() {
        raiz = null;
        fondo = null;
    }

    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarFinal(String cedula) {
        nodo nuevo;
        nuevo = new nodo(cedula);
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
