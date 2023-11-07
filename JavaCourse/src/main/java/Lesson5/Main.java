package Lesson5;

public class Main {
    public static void main(String[] args) {
        //Task1
    Animal animal = new Animal("Бобчик");
    Cat catMur = new Cat("Мур");
    Dog dogBobik = new Dog("Бобик");

    animal.run(150);
    animal.swim(200);
    catMur.run(100);
    catMur.swim(100);
    dogBobik.run(400);
    dogBobik.swim(11);

    System.out.println("Количество животных: " + Animal.getAnimalCount());
    System.out.println("Количество котов: " + Cat.getCatCount());
    System.out.println("Количество собак: " + Dog.getDogCount());

    Plate foodPlate = new Plate(50);
    Cat[] arrCats = new Cat[3];

    arrCats[0] = new Cat("Мик");
    arrCats[1] = new Cat("Майк");
    arrCats[2] = new Cat("Боб");

    foodPlate.addFood(25);
    for(int i = 0; i < arrCats.length; i++){
        arrCats[i].eat(foodPlate, 30);
        System.out.println(arrCats[i].getSatiety());
    }

    // Task2
    Circle circle = new Circle("red", "black", 15);
    circle.printShapeInfo();
    Rectangle rectangle = new Rectangle("black", "blue", 15, 20);
    rectangle.printShapeInfo();
    Triangle triangle = new Triangle("green", "white", 15, 20, 10, 5);
    triangle.printShapeInfo();
    }
}
