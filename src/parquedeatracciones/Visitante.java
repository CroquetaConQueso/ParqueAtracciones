package parquedeatracciones;

public class Visitante extends Thread {
    private ParqueAtracciones parque;
    private final int id;

    public Visitante(ParqueAtracciones parque, int id) {
        this.parque = parque;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            parque.entrar(id);  // se encola y espera a terminar su viaje
        }
    }
}
