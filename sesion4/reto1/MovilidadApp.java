
import java.util.concurrent.CompletableFuture;

public class MovilidadApp {

    public static void main(String[] args) {
        
        CompletableFuture <String> calcularRuta = CompletableFuture
        .supplyAsync(() -> {
            System.out.println("Calculando ruta...");
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                return "Error: "+ e;
            }
            return "Ruta: Centro -> Norte";
        });

        CompletableFuture <Double> estimarTarifa = CompletableFuture
        .supplyAsync(() -> {
            System.out.println("Estimando tarifa...");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.println("Error: "+ e);
            }
            return 75.50;
        });

        CompletableFuture <String> combinarOperaciones =
        calcularRuta.thenCombine(estimarTarifa, (ruta, tarifa) -> {
                return "Ruta calculada: "+ ruta + " | Tarifa estimada: "+ tarifa;
            })
        .exceptionally(ex -> {
            return "Error: " + ex.getMessage();
            });

        
        //System.out.println(combinarOperaciones);
        System.out.println(combinarOperaciones.join());

    }
}