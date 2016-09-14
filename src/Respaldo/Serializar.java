/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Respaldo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import quiz.ClaseSerializable;

/**
 *
 * @author Jorge L Granda.
 */
public class Serializar { 
    
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    
    public void abrir() throws FileNotFoundException, IOException{
        fos = new FileOutputStream("respaldo.mt");
        oos = new ObjectOutputStream(fos);
    }
    
    public void cerrar() throws IOException{
        if(oos !=null){
            oos.close();
        }
    }
    
    public void escribir(ClaseSerializable claseSerializable) throws IOException{
            oos.writeObject(claseSerializable);
    }

}
