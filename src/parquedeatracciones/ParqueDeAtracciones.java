/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parquedeatracciones;

/**
 *
 * @author ctorleo571
 */
public class ParqueDeAtracciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //10 visitantes
        //4 atracciones
        //cada atraccion(1 ocupante)
        // 1 visitante -> busca atraccion disponible -> esperar o ocupar atraccion disponible
        //entrada visitante -> subir a atraccion
        ParqueAtracciones parque = new ParqueAtracciones();
        Atraccion atraccion1 = new Atraccion(parque,"P1");
        Atraccion atraccion2 = new Atraccion(parque,"P2");
        Atraccion atraccion3 = new Atraccion(parque,"P3");
        Atraccion atraccion4 = new Atraccion(parque,"P4");
        
        
        for (int i = 0; i < 10; i++) {
            new Visitante(parque,i).start();
        }
        
        for (int i = 0; i < 4; i++) {
            new Atraccion(parque,"p"+i).start();
        }
        
    }
    
}
