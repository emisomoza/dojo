public class Carta {
    Integer numero;
    Palo palo;
    ValorTruco valorTruco;

    Carta(){

    }

    public Carta ganaEnTruco(Carta cartaDesafiante) {
        if(cartaDesafiante.comparar(this.valorTruco) < 0) {
            return cartaDesafiante;
        } else {
            return this;
        }
    }

    public Integer comparar(ValorTruco valorTruco){
        return valorTruco.compareTo(this.valorTruco);
    }

    public Palo obtenerPaloDeCarta(){

        return palo;

    }

    public boolean esDelMismoPaloQue(Carta otraCarta) {
        return (this.mismoPalo(otraCarta));
    }

    public Integer obtenerValorEnvido() {
        if (numero < 10)
            return numero;
        else return 0;
    }

    private boolean mismoPalo(Carta otraCarta){
        return otraCarta.mismoPalo(this.palo);
    }

    private boolean mismoPalo(Palo otroPalo){
        return this.palo.equals(otroPalo);
    }
}
