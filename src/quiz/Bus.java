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
public class Bus {

    public class nodo {

        public int codigo;
        public String placa;

        nodo sig;

        public nodo(int codigo, String placa) {
            this.codigo = codigo;

            this.placa = placa;
        }

    }//Fin clase nodo

    public nodo raiz, fondo;

    public Bus() {
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

    public boolean validarSiExiste(String placa) {
        nodo aux;
        boolean enc = false;
        if (!vacia()) {
            aux = raiz;
            while (aux != null) {
                if (aux.placa.equals(placa)) {
                    System.out.println("Encontrado!");
                    enc=true;
                    return enc;
                }
                aux = aux.sig;
            }
        }
        return enc;
    }

    public void insertarFinal(int codigo, String placa) {
        nodo nuevo;
        nuevo = new nodo(codigo, placa);
        nuevo.sig = null;
        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.sig = nuevo;
            fondo = nuevo;
        }
    }

    public void eliminarFinal() {
        nodo aux, ant;
        if (!vacia()) {
            if (raiz == fondo) {
                raiz = null;
                fondo = null;
            } else {
                aux = raiz;
                ant = raiz;
                while (aux.sig != null) {
                    ant = aux;
                    aux = aux.sig;
                }
                ant.sig = null;
                fondo = ant;
            }
        }
    }

    public int codigoBus(String placa) {
        nodo reco = raiz;
        int codigo = 0;
        while (reco != null) {
            if (reco.placa.equals(placa)) {
                codigo = reco.codigo;
            }
        }
        return codigo;
    }

    public void imprimir() {
        nodo reco = raiz;
        System.out.println("Listado de todos los elementos de la cola.");
        while (reco != null) {
            System.out.print(reco.placa + "-");
            reco = reco.sig;
        }
        System.out.println();
    }

}
