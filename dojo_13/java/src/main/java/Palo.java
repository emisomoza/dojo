public abstract class Palo {
    @Override
    public boolean equals(Object palo){
        return palo.getClass() == this.getClass();
    }
}
