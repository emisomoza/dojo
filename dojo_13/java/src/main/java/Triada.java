import java.util.ArrayList;

public class Triada extends ArrayList<Carta> {
    Triada(){

    }
    Triada(Carta carta1, Carta carta2, Carta carta3){
        this.add(carta1);
        this.add(carta2);
        this.add(carta3);
    }
}
