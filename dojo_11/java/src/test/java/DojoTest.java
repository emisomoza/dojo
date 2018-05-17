import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import payments.Boleto;
import payments.Oxxo;
import shippings.EnvioADomicilio;
import steps.*;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	
	@Before
	public void setup() {

	}

	@Test
	public void cuando_EligeEnvioADomicilio_nextStepIs_SeleccionDeMedioDePago() {
	    // Con Precargadas y Dinero En Cuenta o Tarjeta Precargada
        // Paso 1 -> Selecciona Express a Domicilio
        // Paso 2 -> ¿Como quieres pagar? -> Dinero en Cuenta
        // Paso 3 -> Review -> Modificar Envio
        // Paso 4 -> Selecciona Retiro en Sucursal
        // Paso 5 -> Selecciona Sucursal
        // Paso 6 -> Review

	    // Paso 1 -> ¿Como queres recibir el producto? 00_01 -> Enviar a mi ubicacion actual
        // Paso 2 -> Envio a Villa Urquiza 01_01
        // Zeplin: https://zpl.io/25zKgWV
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();

        CambiadorDeMedioDePago nextStep = seleccionDeEnvio.envio();

        // Zeplin: https://zpl.io/br1Km7L
        Assert.assertEquals(SeleccionDeMedioDePago.class, nextStep.getClass());
	}

    @Test
    public void cuando_modificaEnvioDesdeReview_EligeEnvioADomicilio_nextStepIs_Review() {
	    // Zeplin: https://zpl.io/be48RDa
        Review review = new Review();

        SeleccionDeEnvio modificarMedioDeEnvio = review.modificarEnvio();

        CambiadorDeMedioDePago nextStep = modificarMedioDeEnvio.envio();

        Assert.assertEquals(Review.class, nextStep.getClass());
    }

    @Test
    public void cuando_modificaEnvioDesdeReview_EligeEnvioASucursal_nextStepIs_SucursalDeCorreo() {
        // Zeplin: https://zpl.io/be48RDa
        Review review = new Review();

        SeleccionDeEnvio modificarMedioDeEnvio = review.modificarEnvio();

        // Zeplin: https://zpl.io/V10Ye52
        CheckoutStep nextStep = modificarMedioDeEnvio.retiroEnCorreo();

        Assert.assertEquals(MapaDeSucursales.class, nextStep.getClass());
    }

    @Test
    public void cuando_EligeEnvioADomicilioSeleccionDeMedioDePago_AltaNuevaTarjeta_nextStepIs_Review() {
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();

        SeleccionDeMedioDePago seleccionDeMedioDePago = (SeleccionDeMedioDePago) seleccionDeEnvio.envio();

        AltaDeTarjeta altaDeTarjeta = seleccionDeMedioDePago.altaDeTarjetaDeCredito();

        CheckoutStep nextStep = altaDeTarjeta.darDeAlta();

        // Zeplin: https://zpl.io/br1Km7L
        Assert.assertEquals(Review.class, nextStep.getClass());
    }

    @Test
    public void cuando_EligeEnvioASucursal_SeleccionDeMedioDePago_Review_ModificaPorEnvioADomicilio_SeleccionDeMedioDePagoPorInconsistencia_nextStepIs_Review() {
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();

        MapaDeSucursales mapaDeSucursales = (MapaDeSucursales) seleccionDeEnvio.retiroEnCorreo();

        SeleccionDeMedioDePago seleccionDeMedioDePago = (SeleccionDeMedioDePago) mapaDeSucursales.seleccionSucursalMasCercana();

        Oxxo oxxo = new Oxxo(0,1000);
        Review review = seleccionDeMedioDePago.seleccionar(oxxo);

        SeleccionDeEnvio modificarEnvio = review.modificarEnvio();

        Inconsistencia inconsistencia = (Inconsistencia) modificarEnvio.envio(new EnvioADomicilio(1300), oxxo);

        SeleccionDeMedioDePago modificarMedioDePago = inconsistencia.cambiarMedioDePago();

        CheckoutStep nextStep = modificarMedioDePago.seleccionar(new Boleto(0, 1500));

        // Zeplin: https://zpl.io/br1Km7L
        Assert.assertEquals(Review.class, nextStep.getClass());
    }

    @Test
    public void cuando_EligeEnvioASucursal_SeleccionDeMedioDePago_Review_ModificaPorEnvioADomicilio_nextStepIs_Review() {
        SeleccionDeEnvio seleccionDeEnvio = new SeleccionDeEnvio();

        MapaDeSucursales mapaDeSucursales = (MapaDeSucursales) seleccionDeEnvio.retiroEnCorreo();

        SeleccionDeMedioDePago seleccionDeMedioDePago = (SeleccionDeMedioDePago) mapaDeSucursales.seleccionSucursalMasCercana();

        Oxxo oxxo = new Oxxo(0,1000);
        Review review = seleccionDeMedioDePago.seleccionar(oxxo);

        SeleccionDeEnvio modificarEnvio = review.modificarEnvio();

        CheckoutStep nextStep = (CheckoutStep) modificarEnvio.envio(new EnvioADomicilio(500), oxxo);

        // Zeplin: https://zpl.io/br1Km7L
        Assert.assertEquals(Review.class, nextStep.getClass());
    }
}
