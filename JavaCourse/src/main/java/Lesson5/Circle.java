package Lesson5;

class Circle extends Shape {
    private double radius;
    public Circle(String fillColor, String borderColor, double radius){
        super(fillColor, borderColor);
        this.radius = radius;
    }
    @Override
    public void printShapeInfo(){
        super.printShapeInfo();
        System.out.println("Периметр круга: " + calculatePerimeter(radius));
        System.out.println("Площадь круга: " + calculateSquare(radius));
    }
}
