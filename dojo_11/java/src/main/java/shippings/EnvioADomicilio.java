package shippings;

public class EnvioADomicilio implements ShippingOption {
    Integer price;
    public EnvioADomicilio(Integer price) {
        this.price = price;
    }
}
