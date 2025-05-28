
import java.util.List;

public class Sucursal {
    //atributos
    String nombre;
    List<Encuesta> encuestas;

    //constructor
    public Sucursal(String nombre, List<Encuesta> encuestas) {
        this.nombre = nombre;
        this.encuestas = encuestas;
    }

    //getters
    public List<Encuesta> getEncuestas() { return encuestas; }
    public String getNombre() { return nombre; }
}
