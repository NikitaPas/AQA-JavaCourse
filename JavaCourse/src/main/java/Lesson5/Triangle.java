package Lesson5;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;
    private double radius;
    public Triangle(String fillColor, String borderColor, double side1, double side2, double side3, double radius){
        super(fillColor, borderColor);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.radius = radius;
    }
    @Override
    public void printShapeInfo(){
        super.printShapeInfo();
        System.out.println("Периметр треугольника: " + calculatePerimeter(side1, side2, side3));
        System.out.println("Площадь треугольника: " + calculateSquare(side1, side2, side3, radius));
    }
}
