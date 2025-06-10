public abstract class MaterialCurso {
    //atributos
    protected String titulo;
    protected String autor;

    //costructor
    public MaterialCurso(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    //getters y setters
    public String getTitulo () { return  titulo; }
    public void setTitulo (String titulo) {this.titulo = titulo; }
    public String getAutor () { return  autor; }
    public void setAutor (String autor) {this.autor = autor; }

    //metodos
    public abstract void mostrarDetalle ();
}