/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parquedeatracciones;

/**
 *
 * @author ctorleo571
 */
public class Visitante extends Thread{
    private ParqueAtracciones parqueA;
    private int id;
    public Visitante(ParqueAtracciones parqueA, Integer id){
        this.parqueA = parqueA;
        this.id = id;
    }
    
    @Override
    public void run(){
        while(true){
            parqueA.entrar(id);
        }
    }
}
