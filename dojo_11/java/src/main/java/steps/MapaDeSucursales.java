package steps;

public class MapaDeSucursales extends CheckoutStep{
    private CheckoutStep defaultNextStep;

    MapaDeSucursales(){
        this.defaultNextStep = new SeleccionDeMedioDePago();
    }

    public CheckoutStep seleccionSucursalMasCercana(){
        return this.defaultNextStep;
    }
}
