import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
            new Sucursal("Centro", List.of(
                new Encuesta("Paciente 1", "Me gustó la actención", 5),
                new Encuesta("Paciente 2", "No me gustó la atención", 1)
            )),
            new Sucursal("Norte", List.of(
                new Encuesta("Paciente 3", null, 4),
                new Encuesta("Paciente 4", null, 2)
            )),
            new Sucursal("Sur", List.of(
                new Encuesta("Paciente 5", null, 5),
                new Encuesta("Paciente 6", "No encontraron mi expediente", 3)
            )),
            new Sucursal("Este", List.of(
                new Encuesta("Paciente 7", "Tienen wifi", 5),
                new Encuesta("Paciente 8", null, 1)
            ))
        );

        sucursales.stream()
            .flatMap(sucursal -> 
                sucursal.getEncuestas().stream()
                    .filter(e -> e.getCalificacion() <= 3)
                    .map(encuesta -> new Info(encuesta, sucursal.getNombre()))
            )
            .filter(info -> info.getEncuesta().getComentario().isPresent())
            .map(info -> {
                String sucursal = info.getSucursal();
                String comentario = info.getEncuesta().getComentario().get();
                return "Sucursal "+sucursal+": Seguimiento a paciente con comentario: "+ comentario;
            })
            .forEach(System.out::println);
    }
}
