/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Respaldo;

import java.io.IOException;
import quiz.ClaseSerializable;

/**
 *
 * @author Jorge L Granda.
 */
public class RespaldoLeer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ClaseSerializable claseSerializable;
        Deserializar deserializar = new Deserializar();
        deserializar.abrir();
        do {
            claseSerializable = deserializar.leer();
            System.out.println(claseSerializable);
        } while (claseSerializable!=null);
        
    }
    
}
