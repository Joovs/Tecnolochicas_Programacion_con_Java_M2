import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Doctores {
    public static void main (String[]args){

        RecursoMedico recurso = new RecursoMedico("Sala de cirugía");
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Runnable dr1 = () -> recurso.usar("Dra. Sánchez");
        Runnable dr2 = () -> recurso.usar("Dr. Gómez");
        Runnable dr3 = () -> recurso.usar("Dra. Escobar");
        Runnable dr4 = () -> recurso.usar("Dr. Ramirez");
        Runnable dr5 = () -> recurso.usar("Dra. Rojas");
        Runnable dr6 = () -> recurso.usar("Dr. Vela");

        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...");

        executor.submit(dr1);
        executor.submit(dr2);
        executor.submit(dr3);
        executor.submit(dr4);
        executor.submit(dr5);
        executor.submit(dr6);

        executor.shutdown();

        

    }
}
