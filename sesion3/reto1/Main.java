
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo!");

        List<Pedido> pedidos = List.of(
            new Pedido("Cliente 1", "domicilio", "555-1234"),
            new Pedido("Cliente 3", "local", null),
            new Pedido("Cliente 2", "domicilio", "555-5678"),
            new Pedido("Cliente 4", "local", null),
            new Pedido("cliente 5", "domicilio", null)
        );

        pedidos.stream()
            .filter(p -> "domicilio".equals(p.getTipoEntrega()) )
            .map(Pedido::getTelefono)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .map(tel -> "📞 Confirmación enviada al número: " + tel) 
            .forEach(System.out::println); 
    }
}
