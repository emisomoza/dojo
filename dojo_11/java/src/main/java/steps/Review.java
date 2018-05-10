package steps;

import payments.Boleto;
import payments.Oxxo;

public class Review  extends CheckoutStep implements CambiadorDeMedioDePago{
    public SeleccionDeEnvio modificarEnvio() {
        return new SeleccionDeEnvio(this);
    }

    @Override
    public SeleccionDeMedioDePago cambiarMedioDePago() {
        return new SeleccionDeMedioDePago();
    }

    @Override
    public Review seleccionar(Boleto boleto) {
        return new Review();
    }

    @Override
    public Review seleccionar(Oxxo oxxo) {
        return new Review();
    }
}
