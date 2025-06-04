import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String>{

    @Override
    public String call() {
        try {
            Thread.sleep(1000);
            return "🧭 Navegación: trayectoria corregida con éxito.";
        } catch (InterruptedException exe) {
            return "Error: " + exe;
        }
        
    }
}