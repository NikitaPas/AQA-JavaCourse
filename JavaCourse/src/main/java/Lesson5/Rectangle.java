package Lesson5;

public class Rectangle extends Shape {
    private double width;
    private double length;
    public Rectangle(String fillColor, String borderColor, double width, double length){
        super(fillColor, borderColor);
        this.width = width;
        this.length = length;
    }
    @Override
    public void printShapeInfo(){
        super.printShapeInfo();
        System.out.println("Периметр прямоугольника: " + calculatePerimeter(width, length));
        System.out.println("Площадь прямоугольника: " + calculateSquare(width, length));
    }
}
