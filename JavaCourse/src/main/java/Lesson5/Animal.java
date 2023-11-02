package Lesson5;

public class Animal {
    private static int animalCount = 0;
    String name;
    public Animal(String name){
        this.name = name;
        animalCount++;
    }
    public static int getAnimalCount() {
        return animalCount;
    }
    public void run(int distance){
        System.out.println("Животное " + name + " пробежало: " + distance);
    }
    public void swim(int distance){
        System.out.println("Животное " + name + " проплыло: " + distance);
    }
}
