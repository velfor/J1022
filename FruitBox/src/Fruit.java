public class Fruit {
    private double weight;

    Fruit(){
        weight = 0.1;
    }

    public Fruit(double weight) {
        this.weight = weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;

        Fruit fruit = (Fruit) o;

        return Double.compare(fruit.getWeight(), getWeight()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getWeight());
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }
}
