package Lesson5;

public class Plate {
    private int amountFood;
    public Plate(int amountFood){
        this.amountFood = amountFood;
    }

    public int getAmountFood(){
        return amountFood;
    }

    public void addFood(int amount){
        this.amountFood += amount;
        System.out.println("Еда успешно добавлена. Текущее значение еды в тарелке: " + this.amountFood);
    }
    public void decreaseFood(int amount){
        this.amountFood -= amount;
    }
}
