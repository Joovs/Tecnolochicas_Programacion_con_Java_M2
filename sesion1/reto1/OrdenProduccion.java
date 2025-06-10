
public abstract class OrdenProduccion {
    //atributos
    String codigo;
    int cantidad;

    //constructor 
    public OrdenProduccion (String codigo, int cantidad){
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    //getters
    public String getCodigo () { return codigo; }
    public Integer getCantidad () { return cantidad; }

    //métodos
    public abstract void mostrarResumen();

    


}