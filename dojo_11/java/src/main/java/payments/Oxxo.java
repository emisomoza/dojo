package payments;

import shippings.EnvioADomicilio;

public class Oxxo {
    Rango rango;
    public Oxxo(Integer minAllowedAmount, Integer maxAllowedAmount){
        this.rango = new Rango(minAllowedAmount, maxAllowedAmount);
    }

    public Object pagar(EnvioADomicilio envio, Object review, Object inconsistencia) {
        return envio.puedeSerPagado(this.rango, review, inconsistencia);
    }
}
