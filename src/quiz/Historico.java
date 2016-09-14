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

    public void sePuede() throws MalformedURLException, IOException {
        URL pcgull = new URL("http://www.giraldojorge.com/jorge/quiz/quiztpa/quiz216/historico.txt");
        URLConnection pcg = pcgull.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(pcg.getInputStream()));
        String inputLine;
        String[] v;
        int co = 0;
        
        cantViajes(in);

    }

    public int maximo(BufferedReader in) throws IOException {
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
    

    public void cantViajes(BufferedReader in) throws IOException {
        URL pcgull2 = new URL("http://www.giraldojorge.com/jorge/quiz/quiztpa/quiz216/historico.txt");
        URLConnection pcg2 = pcgull2.openConnection();
        BufferedReader in2 = new BufferedReader(new InputStreamReader(pcg2.getInputStream()));
        int co = 0;
        String inputLine;
        String[] v;
        int max = maximo(in);

        while ((inputLine = in2.readLine()) != null) {
            v = inputLine.split(";");
            if (v[1].length() == max) {
                co++;
            }
        }

        System.out.println("Cantidad de viajes con mayor numero de empleados: " + co);
    }
    
    

}
