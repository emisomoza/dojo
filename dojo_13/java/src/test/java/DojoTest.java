import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	
	@Before
	public void setup() {

	}

    @Test
    public void test_1_de_espada_gana_al_7_de_espada() {
        AnchoDeEspadas anchoDeEspada = new AnchoDeEspadas();
        SieteDeEspadas sieteDeEspadas = new SieteDeEspadas();
	    Assert.assertEquals(anchoDeEspada, anchoDeEspada.ganaEnTruco(sieteDeEspadas));
    }

    @Test
    public void test_1_de_basto_pierde_con_1_de_espada() {
        AnchoDeBasto anchoDeBasto = new AnchoDeBasto();
        AnchoDeEspadas anchoDeEspadas = new AnchoDeEspadas();
        Assert.assertEquals(anchoDeEspadas, anchoDeEspadas.ganaEnTruco(anchoDeBasto));
    }

    @Test
    public void test_1_de_espadas_gana_con_1_de_basto() {
        AnchoDeBasto anchoDeBasto = new AnchoDeBasto();
        AnchoDeEspadas anchoDeEspadas = new AnchoDeEspadas();
        Assert.assertEquals(anchoDeEspadas, anchoDeBasto.ganaEnTruco(anchoDeEspadas));
    }

    @Test
    public void test_mano_con_32_de_tanto_gana_a_mano_con_28_de_tanto() {
        SieteDeEspadas sieteDeEspadas = new SieteDeEspadas();
        AnchoDeEspadas anchoDeEspadas = new AnchoDeEspadas();
        CuatroDeCopas cuatroDeCopas = new CuatroDeCopas();
        ArrayList<Carta> cartasJugador1 = new ArrayList<>();
        cartasJugador1.add(sieteDeEspadas);
        cartasJugador1.add(anchoDeEspadas);
        cartasJugador1.add(cuatroDeCopas);

        SieteDeOro sieteDeOro = new SieteDeOro();
        CincoDeOro cincoDeOro = new CincoDeOro();
        TresDeCopas tresDeCopas = new TresDeCopas();
        ArrayList<Carta> cartasJugador2 = new ArrayList<>();
        cartasJugador2.add(sieteDeOro);
        cartasJugador2.add(cincoDeOro);
        cartasJugador2.add(tresDeCopas);

        Mano manoJugador1 = new Mano(cartasJugador1);
        Mano manoJugador2 = new Mano(cartasJugador2);

        Assert.assertEquals(manoJugador2, manoJugador1.ganaEnEnvido(manoJugador2));
    }

    @Test
    public void test_mano_con_28_de_tanto_pierde_con_mano_con_32_de_tanto() {
	    //Mano con 28 de tanto
        SieteDeEspadas sieteDeEspadas = new SieteDeEspadas();
        AnchoDeEspadas anchoDeEspadas = new AnchoDeEspadas();
        CuatroDeCopas cuatroDeCopas = new CuatroDeCopas();
        ArrayList<Carta> cartasJugador1 = new ArrayList<>();
        cartasJugador1.add(sieteDeEspadas);
        cartasJugador1.add(anchoDeEspadas);
        cartasJugador1.add(cuatroDeCopas);

        //Mano con 32 de tanto
        SieteDeOro sieteDeOro = new SieteDeOro();
        CincoDeOro cincoDeOro = new CincoDeOro();
        TresDeCopas tresDeCopas = new TresDeCopas();
        ArrayList<Carta> cartasJugador2 = new ArrayList<>();
        cartasJugador2.add(sieteDeOro);
        cartasJugador2.add(cincoDeOro);
        cartasJugador2.add(tresDeCopas);

        Mano manoJugador1 = new Mano(cartasJugador1);
        Mano manoJugador2 = new Mano(cartasJugador2);

        Assert.assertEquals(manoJugador2, manoJugador2.ganaEnEnvido(manoJugador1));
    }
}

/*
1 de espadas
1 de basto
7 de espada
7 de oro
3 (cualquiera)
2 (cualquiera)
1 (copa y oro)
7 (basto y copa)
6
5
4
 */