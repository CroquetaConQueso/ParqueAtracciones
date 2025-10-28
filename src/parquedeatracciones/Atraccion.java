package parquedeatracciones;

public class Atraccion extends Thread {
    private final String nombre;
    private final ParqueAtracciones parque;

    public Atraccion(ParqueAtracciones parque, String nombre) {
        this.parque = parque;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            parque.salir(nombre);
        }
    }
}
