package ejercicios.clase13;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Ejemplo de reproducción de ficheros de sonido.
 *
 * @author Admin
 */
import java.awt.*;

public class Sonido {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 101; i++) {
                Toolkit pitido = Toolkit.getDefaultToolkit();
                pitido.beep();
                Thread.sleep(400);
            }
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

}
