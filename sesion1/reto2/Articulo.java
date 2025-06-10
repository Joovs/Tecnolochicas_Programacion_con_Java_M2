public class Articulo extends MaterialCurso {
    //atributos
    protected int palabras;

    //constructor
    public Articulo (String titulo, String autor, int palabras){
        super(titulo, autor);
        this.palabras = palabras;
    }

    //getters y setters
    public int getPalabras () { return  palabras; }
    public void setPalabras (int palabras) {this.palabras = palabras; }

    //metodos
    @Override
    public void mostrarDetalle(){
        System.out.println("Artículo: "+titulo+" - Autor: "+autor+" - Palabras: "+palabras);
    }
}
