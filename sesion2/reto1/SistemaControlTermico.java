import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String>{
    
    @Override
    public String call() {
        try {
            Thread.sleep(1000);
            return "🔥 Control Térmico: temperatura estable (22°C).";
        } catch (InterruptedException exe) {
            return "Error: " + exe;
        }
        
    }
}
