package payments;

public class Rango<T> {
    T min;
    T max;

    Rango(T min, T max){
        this.min = min;
        this.max = max;
    }

    public Object contiene(Comparable<T> price, Object siContiene, Object sinoContiene) {
        //Boolean puedeSerPagado = this.min.compareTo(price) <= 0 && this.max.compareTo(price) >= 0;
        Boolean puedeSerPagado = price.compareTo(min) > 0 && price.compareTo(max) < 0;
        if(puedeSerPagado){
            return siContiene;
        } else {
            return sinoContiene;
        }
    }
}
