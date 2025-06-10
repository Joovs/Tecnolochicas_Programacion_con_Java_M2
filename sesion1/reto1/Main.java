
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("\n---Órdenes registradas:---");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n---Procesando órdenes personalizadas...---");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                OrdenPersonalizada op = (OrdenPersonalizada) obj;
                System.out.println("Órden " + op.getCodigo() + " ajustada con costo adicional de $" + costoAdicional);
            }
        }
    }

    public static void contarOrdenes(List<? extends OrdenProduccion> lista) {
        long masas = lista.stream().filter(o -> o instanceof OrdenMasa).count();
        long personalizadas = lista.stream().filter(o -> o instanceof OrdenPersonalizada).count();
        long prototipos = lista.stream().filter(o -> o instanceof OrdenPrototipo).count();

        System.out.println("\nResumen total de órdenes:");
        System.out.println("Producción en masa: " + masas);
        System.out.println("Personalizadas: " + personalizadas);
        System.out.println("Prototipos: " + prototipos);
    }


    public static void main(String[] args) {
        //creación de objetos
        List<OrdenProduccion> lista = new ArrayList<>();
        lista.add( new OrdenMasa("M123", 5));
        lista.add( new OrdenMasa("M456", 7));
        lista.add( new OrdenPersonalizada("P123", 3, "Cliente 1"));
        lista.add( new OrdenPersonalizada("P456", 4, "Cliente 2"));
        lista.add( new OrdenPrototipo("PT123", 8, "En proceso"));
        lista.add( new OrdenPrototipo("PT456", 6, "Finilizado"));

        //mostrar resumen de todos los objetos
        mostrarOrdenes(lista);

        //procesar órdenes personalizadas
        procesarPersonalizadas(lista, 200);

        //contar órdenes por tipo
        contarOrdenes(lista);


    }
}
