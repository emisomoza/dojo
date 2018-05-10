package steps;

import payments.Boleto;
import payments.Oxxo;

public interface CambiadorDeMedioDePago{
    SeleccionDeMedioDePago cambiarMedioDePago();
    Review seleccionar(Boleto boleto);
    Review seleccionar(Oxxo oxxo);
}
