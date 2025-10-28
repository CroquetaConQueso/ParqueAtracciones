// ParqueAtracciones.java
package parquedeatracciones;

import java.util.LinkedList;
import java.util.Queue;

public class ParqueAtracciones {
    private Queue<Integer> cola = new LinkedList<>();
    private boolean[] situacion;

    public ParqueAtracciones(int cantidad) { situacion = new boolean[cantidad]; }

    public synchronized void entrar(int id) {
        situacion[id] = false;            
        cola.add(id);
        notifyAll();                
        while (!situacion[id]) {
            try { wait(); } catch (InterruptedException ex) {System.out.println("Error");}
        }
    }

    // No es synchronized por que acoto el monitor y paso la synchronización a dos metodos auxiliares
    public void salir(String nombre) {
        int id = tomarSiguienteVisitante();   

        System.out.println("Visitante " + id + " entra en " + nombre);
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        System.out.println("Visitante " + id + " se baja de " + nombre);

        finAtraccion(id);
    }

    private synchronized int tomarSiguienteVisitante() {
        while (cola.isEmpty()) {
            try { wait(); } catch (InterruptedException ignored) {}
        }
        return cola.remove();
    }

    private synchronized void finAtraccion(int id) {
        situacion[id] = true;
        notifyAll();
    }
}
