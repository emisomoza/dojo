public class ValorTruco {
    Integer valor;

    public ValorTruco(Integer valor) {
        this.valor = valor;
    }

    public Integer compareTo(ValorTruco valorTruco){
        return valorTruco.compareTo(this.valor);
    }

    public Integer compareTo(Integer valor){
        return valor.compareTo(this.valor);
    }
}
