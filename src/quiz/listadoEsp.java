/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author sebgv
 */
public class listadoEsp {

    class nodo {

        public String cedula;
        public String nombreEmp;
        public String placa;
        public int codBUs;
        public int dia;
        nodo sig;

        public nodo(String cedula, String nombreEmp, String placa, int codBUs, int dia) {
            this.cedula = cedula;
            this.nombreEmp = nombreEmp;
            this.placa = placa;
            this.codBUs = codBUs;
            this.dia = dia;
        }
    }

    private nodo raiz, fondo;
    private Servicios.nodoServ serv;
    private Empleados emp;
    private Bus bus;

    public listadoEsp() {
        this.raiz = null;
        this.fondo = null;
    }

    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar() {
        nodo nuevo;
        String nombreEmp;
        int codBus;
        Servicios.nodoServ reco = null;
        while (reco != null) {
            nombreEmp = emp.nombreEmp(serv.cedula);
            codBus = bus.codigoBus(serv.placa);
            nuevo = new nodo(serv.cedula, nombreEmp, serv.placa, codBus, serv.dia);
            nuevo.sig = null;
            if (vacia()) {
                raiz = nuevo;
                fondo = nuevo;
            } else {
                fondo.sig = nuevo;
                fondo = nuevo;
            }
        }
    }
    
    public void imprimir(){
        nodo reco = raiz;
        System.out.println("Listado especial: ");
        while (reco != null) {
            System.out.println("Cedula: " + reco.cedula);
                System.out.println("Nombre empleado: " + reco.nombreEmp + "-" );
                System.out.print("Placa: " + reco.placa + "-");
                System.out.println("Codigo bus: " + reco.codBUs + "-");
                System.out.print("Dia: " + reco.dia + "-");
                reco = reco.sig;         
        }
        System.out.println();
    }
}
