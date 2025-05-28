
import java.util.Optional;

public class Encuesta {
    //atributos
    String paciente;
    String comentario;
    int calificacion;

    //constructor
    public Encuesta (String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    //getters
    public String getPaciente () { return paciente; }
    public Integer getCalificacion () { return calificacion; }
    public Optional<String> getComentario () {
        return Optional.ofNullable(comentario);
    }

}