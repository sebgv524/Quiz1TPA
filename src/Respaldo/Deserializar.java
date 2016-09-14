/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Respaldo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import quiz.ClaseSerializable;

/**
 *
 * @author Jorge L Granda.
 */
public class Deserializar {

    private FileInputStream fis;
    private ObjectInputStream ois;

    public void abrir() throws FileNotFoundException, IOException {
        fis = new FileInputStream("respaldo.mt");
        ois = new ObjectInputStream(fis);
    }

    public void cerrar() throws IOException {
        if (ois != null) {
            ois.close();
        }
    }

    public ClaseSerializable leer() {
        ClaseSerializable claseSerializable = null;
        try {
            claseSerializable = (ClaseSerializable) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return claseSerializable;
    }
}
