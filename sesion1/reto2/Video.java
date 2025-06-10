public class Video extends MaterialCurso {
    //atributos
    protected int duracion;

    //consturctor
    public Video (String titulo, String autor, int diracion){
        super(titulo, autor);
        this.duracion = diracion;
    }

    //getters y setters
    public int getDuracion () { return  duracion; }
    public void setDuracion (int duracion) {this.duracion = duracion; }

    //metodos
    @Override
    public void mostrarDetalle(){
        System.out.println("Video: "+titulo+" - Autor: "+autor+" - Duración: "+duracion+" min");
    }
}
