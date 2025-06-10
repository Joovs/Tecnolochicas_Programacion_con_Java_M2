import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    //métodos genéricos
    //método para mostrar resumen de todos los materiales
    public static void mostrarMateriales(List<? extends MaterialCurso> lista){
        System.out.println("\n---Materiales del Curso:---");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    //metodo para contar el total de minutos de los materiales de tipo video
    public static void contarDuracionVideos(List<? extends Video> lista){
        System.out.println("\n---Duración total de los videos:---");
        int duracionTotal = 0;
        for (Video material : lista){
            duracionTotal += material.duracion;
        }
        System.out.println(duracionTotal + "mins.");
    }

    //metodo para actualizar el estado de los ejercicios a revisado = true
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        System.out.println("\n---Revisión de Ejercicios:---");
        for (Object material : lista) {
            if (material instanceof Ejercicio){
                Ejercicio e = (Ejercicio) material;
                ((Ejercicio) material).setRevisado(true);
                System.out.println("Ejercicio '" + e.getTitulo() + "' marcado como revisado.");
            }
        }
    }

    //metodo para filtrar materiales por autor usando
    public static void filtrarMateriales (List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("\n---Filtrando materiales por autor:---");
        for (MaterialCurso material : lista) {
            if (filtro.test(material)) {
                material.mostrarDetalle();
            }
        }

    }

    public static void main(String[] args) {
        //creación de objetos
        List<MaterialCurso> lista = new ArrayList<>();
        List<Video> listaVideo = Arrays.asList(
            new Video("Introducción a Java", "Mario", 15),
            new Video("POO en Java", "Carlos", 20)
        );
        lista.addAll(listaVideo);
        lista.add( new Articulo("Historia de Java", "Ana", 1200));
        lista.add( new Articulo("Tipos de datos", "Luis", 800));
        lista.add( new Ejercicio("Variables y tipos", "Luis", false));
        lista.add( new Ejercicio("Condicionales", "Mario", false));

        mostrarMateriales(lista);
        contarDuracionVideos(listaVideo);
        marcarEjerciciosRevisados(lista);
        filtrarMateriales(lista, m -> m.getAutor().equals("Mario"));


    }
}
