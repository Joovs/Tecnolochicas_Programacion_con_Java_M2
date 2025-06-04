import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    //atributos
    String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    //constructor
    public RecursoMedico (String nombre){
        this.nombre = nombre;
    }

    //métodos
    public void usar (String profesional){
        lock.lock();
        try {
            System.out.println("🩺 " + profesional + " ha ingresado a " + nombre);
            Thread.sleep(5000);
            System.out.println("✅ " + profesional + " ha salido de " + nombre+ "\n");
        } catch (InterruptedException e) {
            System.out.println("Error: "+ e);
        } finally {
            lock.unlock();
        }
    }
}