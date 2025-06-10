public class Ejercicio extends MaterialCurso {
    //atributos
    protected boolean revisado;

    //constructor
    public Ejercicio (String titulo, String autor, boolean  rev){
        super(titulo, autor);
        this.revisado = rev;
    }

    //getters y setters
    public boolean getRevisado () { return  revisado; }
    public void setRevisado (boolean revisado) {this.revisado = revisado; }

    //metodos
    @Override
    public void mostrarDetalle(){
        System.out.println("Ejercicio: "+titulo+" - Autor: "+autor+" - Revisado: "+revisado);
    }
}
