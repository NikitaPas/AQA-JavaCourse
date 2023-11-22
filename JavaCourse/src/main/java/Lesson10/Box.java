package Lesson10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Box<T extends Fruit> {
    private List<T> fruitBox = new ArrayList<>();

    void addFruit(T fruit) {
        fruitBox.add(fruit);
    }
    public double getWeight(){
        float total = 0.0f;
        for (T fruit : fruitBox) {
            total += fruit.getFruitWeight();
        }
        return total;
    }


    public boolean compare(Box<?> another) {
        if(Math.abs(this.getWeight() - another.getWeight()) < 0.0001){
            return true;
        }
        else return false;
    }
    public void moveFruitsTo(Box<T> another) {
        if (this.fruitBox.get(0).getClass() == another.fruitBox.get(0).getClass()) {
            another.fruitBox.addAll(this.fruitBox);
            this.fruitBox.clear();
        } else {
            System.out.println("Нельзя перемещать фрукты разных типов");
        }
    }
}
