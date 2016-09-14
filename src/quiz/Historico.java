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
 * @author sala304
 */
public class Historico {

    String empleado;

    public Historico(String empleado) throws IOException {
        this.empleado = empleado;
        serviciosTomados(empleado);
        cantViajes();
    }


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

    private boolean esta(String buscaren, String encontrar) {
        int tmnoBuscar = buscaren.length();
        int tmnoEncontrar = encontrar.length();
        boolean foundIt = false;
        for (int i = 0;
                i <= (tmnoBuscar - tmnoEncontrar);
                i++) {
            if (buscaren.regionMatches(i, encontrar, 0, tmnoEncontrar)) {
                foundIt = true;
                break;
            }
        }
        return foundIt;
    }

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
