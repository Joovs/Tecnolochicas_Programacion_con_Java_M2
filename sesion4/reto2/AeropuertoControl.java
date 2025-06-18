import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AeropuertoControl {

    //private static List<CompletableFuture<String>> Arrays;

    //método de latencia
    static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("Error: "+ e);
        }
    } 

    public static void main(String[] args) {

        Random random = new Random();
       
        // método para verificar pista
        CompletableFuture<Boolean> verificarPista = CompletableFuture
        .supplyAsync(() -> {
            sleep(3000);
            boolean disponible = random.nextInt(100) < 80; 
            System.out.println("- Pista disponible: "+ disponible);
            return disponible;
        });
       
        // método para verificar clima
        CompletableFuture<Boolean> verificarClima = CompletableFuture
        .supplyAsync(() -> {
            sleep(3000);
            boolean disponible = random.nextInt(100) < 85; 
            System.out.println("- Clima favorable: "+ disponible);
            return disponible;
        });
       
        // método para verificar tráfico aéreo
        CompletableFuture<Boolean> verificarTraficoAereo = CompletableFuture
        .supplyAsync(() -> {
            sleep(3000);
            boolean disponible = random.nextInt(100) < 90; 
            System.out.println("- Tráfico aéreo despejado: "+ disponible);
            return disponible;
        });
       
        // método para verificar Personal en tierra
        CompletableFuture<Boolean> verificarPersonalTierra = CompletableFuture
        .supplyAsync(() -> {
            sleep(3000);
            boolean disponible = random.nextInt(100) < 95; 
            System.out.println("- Personal disponible: "+ disponible);
            return disponible;
        });


        // método para verificar todas las condiciones
        CompletableFuture<Void> verificaciones = CompletableFuture
        .allOf(verificarPista, verificarClima, verificarTraficoAereo, verificarPersonalTierra)
        .thenAccept(v -> {
                    try {
                        boolean pista = verificarPista.get();
                        boolean clima = verificarClima.get();
                        boolean trafico = verificarTraficoAereo.get();
                        boolean personal = verificarPersonalTierra.get();

                        if (pista && clima && trafico && personal) {
                            System.out.println("\n✓ Aterrizaje autorizado: todas las condiciones óptimas.");
                        } else {
                            System.out.println("\n✕ Aterrizaje denegado: condiciones no óptimas.");
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("\n⌂ Error en la evaluación de condiciones: " + e.getMessage());
                    }
                })
            .exceptionally(ex -> {
                System.out.println("\n⌂ Error en el proceso de aterrizaje: " + ex.getMessage());
                return null;
            });

        verificaciones.join();
    
            
    
    }

}