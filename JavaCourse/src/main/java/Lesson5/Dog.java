package Lesson5;

public class Dog extends Animal {
    private static int dogCount;
    public Dog(String name) {
        super(name);
        dogCount++;
    }
    public static int getDogCount() {
        return dogCount;
    }
    @Override
    public void run(int distance){
        if(distance > 500){
            System.out.println("Собака пробежала только 500м.");
        }
        else{
            System.out.println("Собака " + name + " пробежала: " + distance);
        }
    }
    @Override
    public void swim(int distance){
        if(distance > 10){
            System.out.println("Собака может проплыть только 10м");
        }
        else{
            System.out.println("Собака " + name + " проплыла: " + distance);
        }
    }
}
