package steps;

import payments.Boleto;
import payments.Oxxo;

public class SeleccionDeMedioDePago extends CheckoutStep implements CambiadorDeMedioDePago{
    public AltaDeTarjeta altaDeTarjetaDeCredito() {
        return new AltaDeTarjeta();
    }

    @Override
    public Review seleccionar(Oxxo oxxo) {
        return new Review();
    }

    @Override
    public SeleccionDeMedioDePago cambiarMedioDePago() {
        return new SeleccionDeMedioDePago();
    }

    @Override
    public Review seleccionar(Boleto boleto) {
        return new Review();
    }
}
