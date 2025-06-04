import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MisionAeroespacial {
    public static void main(String[] args) {
        
        //crear el pool ("alberca") de hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        //agregar hilos al pool
        System.out.println("🚀 Simulación de misión espacial iniciada...");
        Future<String> comun = executor.submit(new SistemaComunicaciones());
        Future<String> vital = executor.submit(new SistemaSoporteVital());
        Future<String> termi = executor.submit(new SistemaControlTermico());
        Future<String> naveg = executor.submit(new SistemaNavegacion());

        try {
            System.out.println(comun.get());
            System.out.println(vital.get());
            System.out.println(termi.get());
            System.out.println(naveg.get());
            System.out.println("✅ Todos los sistemas reportan estado operativo.");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error: "+ e);
        }
        
        executor.shutdown();
    }
}
