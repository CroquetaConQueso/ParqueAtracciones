package parquedeatracciones;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ParqueAtracciones {
    // Cola FIFO de visitantes (IDs)
    private final Queue<Integer> cola = new LinkedList<>();

    // Exclusión mutua para la cola
    private final Semaphore mutex = new Semaphore(1, true);

    // Contador de visitantes disponibles para consumir
    private final Semaphore hayVisitantes = new Semaphore(0, true);

    /**
     * PRODUCTOR: el visitante llega y se encola.
     */
    public void entrar(int id) {
        try {
            mutex.acquire();
            cola.add(id);
            System.out.println("Visitante " + id + " llega y se pone en la COLA.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        } finally {
            mutex.release();
            // Señaliza que hay un visitante disponible
            hayVisitantes.release();
        }
    }

    /**
     * CONSUMIDOR: la atracción toma al siguiente visitante y lo atiende.
     * Tu clase Atraccion llama a este método en bucle.
     */
    public void salir(String nombreAtraccion) {
        int id;
        try {
            // Espera a que exista al menos 1 visitante en cola
            hayVisitantes.acquire();

            // Extrae de la cola de forma atómica
            mutex.acquire();
            id = cola.poll(); // no será null porque hayVisitantes > 0
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        } finally {
            mutex.release();
        }

        // Simula el viaje en la atracción
        System.out.println("Atracción " + nombreAtraccion + " **TOMA** al visitante " + id);
        try {
            Thread.sleep(4000); // tiempo de “viaje”
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Atracción " + nombreAtraccion + " **LIBERA** al visitante " + id);
    }
}
