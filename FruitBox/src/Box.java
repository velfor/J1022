import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> fruits;

    public Box(){
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public double weight(){
        double weight = 0.0;
        if (fruits.size() != 0){
            weight = fruits.get(0).getWeight()*fruits.size();
        }
        return weight;
    }

    boolean compare(Box<?> box){
        return Math.abs(this.weight() - box.weight()) < 1E-6;
    }

    public ArrayList<T> getFruits(){
        return fruits;
    }

    public boolean isEmpty(){
        return fruits.size() == 0;
    }

    public void move(Box<T> box){
        if(box == this) return;
        if(box.isEmpty()) return;
        if(!this.fruits.get(0).getClass().equals(box.fruits.get(0).getClass())){
            return;
        }
        this.fruits.addAll(box.fruits);
        box.fruits.clear();
    }
}
