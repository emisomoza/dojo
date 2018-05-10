import payments.Boleto;
import payments.Oxxo;
import steps.*;

public class Inconsistencia implements CambiadorDeMedioDePago {

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
