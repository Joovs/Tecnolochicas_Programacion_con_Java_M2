import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String>{

    @Override
    public String call() {
        try {
            Thread.sleep(1000);
            return "📡 Comunicaciones: enlace con estación terrestre establecido.";
        } catch (InterruptedException exe) {
            return "Error: " + exe;
        }
        
    }
}
