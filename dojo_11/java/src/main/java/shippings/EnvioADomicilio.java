package shippings;

import payments.Rango;

public class EnvioADomicilio implements ShippingOption {
    Integer price;
    public EnvioADomicilio(Integer price) {
        this.price = price;
    }

    public Object puedeSerPagado(Rango rango, Object review, Object inconsistencia) {
        return rango.contiene(this.price, review, inconsistencia);
    }
}
