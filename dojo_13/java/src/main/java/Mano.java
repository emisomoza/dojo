public class Mano {

    Triada cartas;

    Mano(Triada cartas){
        this.cartas = cartas;
    }

    public Mano ganaEnEnvido(Mano manoRival){
        if(this.envido() > manoRival.envido()){
            return this;
        } else {
            return manoRival;
        }
    }

    public Integer envido(){
        if (this.tieneTodasCartasDeDistintoPalo()){
            return cartaMasAltaDelEnvido();
        }
        else
            return sumatoriaEnvido();
    }

    public Integer cartaMasAltaDelEnvido() {
        Integer numeroMayor = 0;

        for (Carta carta: this.cartas){
            if(numeroMayor < carta.obtenerValorEnvido())
                numeroMayor = carta.obtenerValorEnvido();
        }

        return numeroMayor;
    }

    public Palo obtenerPaloDelEnvido() {
        Palo unPalo = null;
        Carta carta1 = cartas.get(0);
        Carta carta2 = cartas.get(1);
        Carta carta3 = cartas.get(2);

        if (carta1.esDelMismoPaloQue(carta2)) {
            unPalo = carta1.obtenerPaloDeCarta();
        }
        else
        if (carta1.esDelMismoPaloQue(carta3)) {
            unPalo = carta1.obtenerPaloDeCarta();
        }
        else
        if (carta2.esDelMismoPaloQue(carta3)) {
            unPalo = carta2.obtenerPaloDeCarta();
        }

        return unPalo;
    }

    public Integer sumatoriaEnvido() {
        int sumatoriaDeCartas = 0;

        for (Carta carta : this.cartas) {
            if (this.esDelPaloDelEnvido(carta))
                sumatoriaDeCartas += carta.obtenerValorEnvido();
        }

        if (tieneFlor()) {
            return (sumatoriaDeCartas + 20 - cartaMasBajaDelEnvido());
        } else
            return (sumatoriaDeCartas + 20);

    }

    private boolean esDelPaloDelEnvido(Carta carta){
        return this.obtenerPaloDelEnvido().getClass() == carta.obtenerPaloDeCarta().getClass();
    }

    public Integer cartaMasBajaDelEnvido() {
        int numeroMenor = 99;

        for (Carta carta: this.cartas) {

            if (numeroMenor > carta.obtenerValorEnvido()) {
                numeroMenor = carta.obtenerValorEnvido();
            }
        }

        return numeroMenor;
    }

    public boolean tieneFlor() {
        Carta carta1 = this.cartas.get(0);
        Carta carta2 = this.cartas.get(1);
        Carta carta3 = this.cartas.get(2);

        return (carta1.esDelMismoPaloQue(carta2) && carta1.esDelMismoPaloQue(carta3) && carta2.esDelMismoPaloQue(carta3));
    }

    public boolean tieneTodasCartasDeDistintoPalo() {
        Carta carta1 = this.cartas.get(0);
        Carta carta2 = this.cartas.get(1);
        Carta carta3 = this.cartas.get(2);

        return (!carta1.esDelMismoPaloQue(carta2) && !carta1.esDelMismoPaloQue(carta3) && !carta2.esDelMismoPaloQue(carta3));
    }
}
