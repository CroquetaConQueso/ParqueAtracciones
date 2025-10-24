/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parquedeatracciones;

/**
 *
 * @author ctorleo571
 */
public class Atraccion extends Thread {
    private String nombre;
    private ParqueAtracciones parqueA; 
    public Atraccion(ParqueAtracciones parqueA, String nombre){
        this.nombre = nombre;
        this.parqueA = parqueA;
    }
    
    @Override
    public void run(){
        while(true){
            parqueA.salir(nombre);
        }
    }
}
