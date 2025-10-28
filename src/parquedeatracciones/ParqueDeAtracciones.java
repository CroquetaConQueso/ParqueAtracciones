package parquedeatracciones;

//Ejercicio de Carlos Torres León
public class ParqueDeAtracciones {
    public static void main(String[] args) {
        int cantidad = 10;

        ParqueAtracciones parque = new ParqueAtracciones(cantidad);

        //10 visitantes
        // 4 atracciones
        // Cuando se monta un visitante, esa atraccion queda ocupada y no se puede volver a usar hasta que este termine

        //Las 4 atracciones
        new Atraccion(parque, "MontañaRusa").start();
        new Atraccion(parque, "Noria").start();
        new Atraccion(parque, "Barcas").start();
        new Atraccion(parque, "CasaDelTerror").start();
       
        //Los 10 visitantes
        for (int i = 0; i < cantidad; i++) {
            new Visitante(parque, i).start();
        }
        
    }
}
