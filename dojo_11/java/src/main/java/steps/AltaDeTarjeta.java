package steps;

public class AltaDeTarjeta extends CheckoutStep {
    public CheckoutStep darDeAlta(){
        return new Review();
    }
}
