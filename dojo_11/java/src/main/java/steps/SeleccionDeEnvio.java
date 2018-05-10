package steps;

import shippings.EnvioADomicilio;
import shippings.RetiroEnCorreo;
import shippings.ShippingOption;

public class SeleccionDeEnvio extends CheckoutStep{
    private final CambiadorDeMedioDePago defaultNextStep;

    public SeleccionDeEnvio() {
        this.defaultNextStep = new SeleccionDeMedioDePago();
    }

    public SeleccionDeEnvio(Review review) {
        this.defaultNextStep = review;
    }

    public CambiadorDeMedioDePago envioADomicilio() {
        return this.defaultNextStep;
    }

    public CheckoutStep retiroEnCorreo() {
        return new MapaDeSucursales();
    }
}
