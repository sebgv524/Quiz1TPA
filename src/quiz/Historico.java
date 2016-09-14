/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Jorge L Granda
 */
public class Historico {

    String empleado;

    /**
     * Al crearse el nuevo objeto se llama a los dos principales metodos de la clase.
     * @param empleado
     * @throws IOException 
     */
    public Historico(String empleado) throws IOException {
        this.empleado = empleado;
        serviciosTomados(empleado);
        cantViajes();
    }

    /**
     * Calcula el máximo tomando la longitud de la primera linea 
     * sin contar el numero del viaje.
     * @return un entero con el numero máximo de empleados en un viaje
     * @throws IOException 
     */
    private int maximo() throws IOException {
        URL pcgull = new URL("http://www.giraldojorge.com/jorge/quiz/quiztpa/quiz216/historico.txt");
        URLConnection pcg = pcgull.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(pcg.getInputStream()));

        String inputLine = in.readLine();
        String[] v;
        int max = inputLine.split(";").length;
        while ((inputLine = in.readLine()) != null) {
            v = inputLine.split(";");
            if (v[1].length() > max) {
                max = v[1].length();
            }
        }
        return max;
    }
    
    /**
     * Llama al método máximo para comparar y contar las veces que una linea(viaje) 
     * concuerda con el numero máximo.
     * @throws IOException 
     */
    private void cantViajes() throws IOException {
        URL pcgull2 = new URL("http://www.giraldojorge.com/jorge/quiz/quiztpa/quiz216/historico.txt");
        URLConnection pcg2 = pcgull2.openConnection();
        BufferedReader in2 = new BufferedReader(new InputStreamReader(pcg2.getInputStream()));
        int co = 0;
        String inputLine;
        String[] v;
        int max = maximo(); 

        while ((inputLine = in2.readLine()) != null) {
            v = inputLine.split(";");
            if (v[1].length() == max) {
                co++;
            }
        }

        System.out.println("Cantidad de viajes con mayor numero de empleados: " + co);
    }
    
    /**
     * Compara por regiones de la cadena que se recibe si concuerda 
     * con los caracteres del empleado.
     * @param buscaren Es la cadena en la que se va a buscar el empleado.
     * @param encontrar Es el empleado que se va a buscar en cada viaje.
     * @return True si lo encuentra.
     */
    private boolean esta(String buscaren, String encontrar) {
        int tmnoBuscar = buscaren.length();
        int tmnoEncontrar = encontrar.length();
        boolean encontrado = false;
        for (int i = 0;
                i <= (tmnoBuscar - tmnoEncontrar);
                i++) {
            if (buscaren.regionMatches(i, encontrar, 0, tmnoEncontrar)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    /**
     * Hace uso del método 'está' para poder contar el empleado en cada viaje.
     * @param emp Es el documento del empleado.
     * @throws MalformedURLException
     * @throws IOException 
     */
    private void serviciosTomados(String emp) throws MalformedURLException, IOException {
        URL pcgull = new URL("http://www.giraldojorge.com/jorge/quiz/quiztpa/quiz216/historico.txt");
        URLConnection pcg = pcgull.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(pcg.getInputStream()));
        String inputLine;
        String[] v;
        int co = 0;
        while ((inputLine = in.readLine()) != null) {
            v = inputLine.split(";");
            if (esta(v[1], emp)) {
                co++;
            }
        }
        System.out.printf("El empleado \"%s\" tomó: %d servicios. \n", emp, co);

    }

}
