public class OrdenMasa extends OrdenProduccion {
    
    public OrdenMasa(String codigo, int cantidad) {
        super(codigo, cantidad);
    }

    //método sobreescrito
    @Override
    public void mostrarResumen() {
        System.out.println("ÓrdenMasa - Código: " + getCodigo() + " - Cantidad: " + getCantidad());
    }
}
