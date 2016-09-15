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
        public String nombreEmp;
        
        nodo sig;

        public nodo(String cedula, String nombreEmp) {
            this.cedula = cedula;
            this.nombreEmp = nombreEmp;
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

    public void insertarFinal(String cedula, String nombreEmp) {
        nodo nuevo;
        nuevo = new nodo(cedula,nombreEmp);
        nuevo.sig = null;
        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }
    
    public boolean validarSiExiste(String cedula){
        nodo reco = raiz;
        boolean existe = false;
        while (reco != null) {
            if (reco.cedula == cedula) {
                existe = true;
            }
            reco = reco.sig;
        }
        return existe;
    }
    
    public String nombreEmp(String cedula){
        nodo reco = raiz;
        String nombreEmp = null;
        while (reco != null) {
            if (reco.cedula.equals(cedula)) {
               nombreEmp = reco.nombreEmp;
            }
        }
        return nombreEmp;
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
