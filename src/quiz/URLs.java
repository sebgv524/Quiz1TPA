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
public class URLs {

    public boolean sePuede(String cc) throws MalformedURLException, IOException {
        boolean b = false;
        URL pcgull = new URL("http://www.giraldojorge.com/jorge/quiz/quiztpa/quiz216/bono.php?doc=" + cc.toUpperCase());
        URLConnection pcg = pcgull.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(pcg.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if(inputLine.equals("si")){
                b = true;
            }else{
                b = false;
            }
        }
        in.close();
        return b;
    }
}
