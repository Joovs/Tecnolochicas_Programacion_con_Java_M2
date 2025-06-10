public class OrdenPrototipo extends OrdenProduccion {
    //atributos
    String faseDesarrollo;
    
    public OrdenPrototipo(String codigo, int cantidad, String fase) {
        super(codigo, cantidad);
        this.faseDesarrollo = fase;
    }

    public String getFaseDesarrollo () { return faseDesarrollo; }
 
    @Override
    public void mostrarResumen(){
        System.out.println("ÓrdenPrototipo - Código: " + getCodigo() +
                " - Cantidad: " + getCantidad() +
                " - Fase: " + faseDesarrollo);
    }
}
