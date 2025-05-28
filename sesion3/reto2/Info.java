public class Info {
    //atributos 
    Encuesta encuesta;
    String sucursal;

    //constructor
    public Info (Encuesta encuesta, String sucursal){
        this.encuesta = encuesta;
        this.sucursal = sucursal;
    }

    //getters
    public Encuesta getEncuesta () { return encuesta; }
    public String getSucursal () { return sucursal; }
}
