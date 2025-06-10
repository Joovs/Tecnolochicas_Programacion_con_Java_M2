public class OrdenPersonalizada extends OrdenProduccion {
    //atributos
    String cliente;
    
    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    public String getCliente () { return cliente; }

    @Override
    public void mostrarResumen(){
        System.out.println("ÓrdenPersonalizada - Código: " + getCodigo() +
                " - Cantidad: " + getCantidad() +
                " - Cliente: " + cliente);
    }
    
}
