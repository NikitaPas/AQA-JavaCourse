package Lesson5;

public class Cat extends Animal{
    private boolean satiety = false;
    private static int catCount;

    public Cat(String name){
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }
    public boolean getSatiety(){
        return satiety;
    }

    @Override
    public void run(int distance){
        if(distance > 200){
            System.out.println("Кот пробежал только 200м.");
        }
        else{
            System.out.println("Кот " + name + " пробежал: " + distance);
        }
    }
    @Override
    public void swim(int distance){
        System.out.println("Кот "+ name +" не умеет плавать");
    }
    public void eat(Plate plate, int countEat){
        if(plate.getAmountFood() >= countEat){
            satiety = true;
            plate.decreaseFood(countEat);
        }
        else{
            System.out.println("Еда для " + this.name + " закончилась");
        }
    }

}
