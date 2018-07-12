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
	    //Triada con 28 de tanto
        Triada cartasJugador1 = new Triada(new SieteDeEspadas(), new AnchoDeEspadas(), new CuatroDeCopas());

        //Triada con 32 de tanto
        Triada cartasJugador2 = new Triada(new SieteDeOro(), new CincoDeOro(), new TresDeCopas());

        Mano manoJugador1 = new Mano(cartasJugador1);
        Mano manoJugador2 = new Mano(cartasJugador2);

        Assert.assertEquals(manoJugador2, manoJugador1.ganaEnEnvido(manoJugador2));
    }

    @Test
    public void test_mano_con_28_de_tanto_pierde_con_mano_con_32_de_tanto() {
	    //Triada con 28 de tanto
        Triada cartasJugador1 = new Triada(new SieteDeEspadas(), new AnchoDeEspadas(), new CuatroDeCopas());

        //Triada con 32 de tanto
        Triada cartasJugador2 = new Triada(new SieteDeOro(), new CincoDeOro(), new TresDeCopas());

        Mano manoJugador1 = new Mano(cartasJugador1);
        Mano manoJugador2 = new Mano(cartasJugador2);

        Assert.assertEquals(manoJugador2, manoJugador2.ganaEnEnvido(manoJugador1));
    }

    @Test
    public void Dadas_dos_triadas_conformadas_por_espada1_espada7_copa5_y_espada1_espada10_copa5_ante_un_envido_debe_ganar_la_primer_triada_de_cartas(){
        //Triada con 28 de tanto
        Triada cartasJugador1 = new Triada(new SieteDeEspadas(), new AnchoDeEspadas(), new CincoDeCopas());

        //Triada con 21 de tanto
        Triada cartasJugador2 = new Triada(new SieteDeEspadas(), new AnchoDeEspadas(), new DiezDeEspadas());

        Mano manoJugador1 = new Mano(cartasJugador1);
        Mano manoJugador2 = new Mano(cartasJugador2);

        Assert.assertEquals(manoJugador1, manoJugador2.ganaEnEnvido(manoJugador1));
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