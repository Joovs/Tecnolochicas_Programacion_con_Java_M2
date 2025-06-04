import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String>{
    
    @Override
    public String call() {
        try {
            Thread.sleep(1000);
            return "🧪 Soporte Vital: presión y oxígeno dentro de parámetros normales.";
        } catch (InterruptedException exe) {
            return "Error: " + exe;
        }
        
    }
}
