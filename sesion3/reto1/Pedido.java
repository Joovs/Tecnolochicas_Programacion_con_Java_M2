
import java.util.Optional;

public class Pedido {
    //https://stackoverflow.com/questions/61826895/how-to-avoid-visual-studio-code-warning-myfile-java-is-a-non-project-file-o
    String cliente;
    String tipoEntrega;
    String telefono;    //opcional

    //constructor
    public Pedido (String cliente, String tipoEntrega, String telefono){
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    //getters
    public String getCliente () { return cliente; }
    public String getTipoEntrega () { return tipoEntrega; }

    public Optional<String> getTelefono () {
        return Optional.ofNullable(telefono);
    }

}
