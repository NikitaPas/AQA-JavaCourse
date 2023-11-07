package Lesson5;

public class Shape implements Calculate {
    private String fillColor;
    private String borderColor;

    public Shape(String fillColor, String borderColor){
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    public String getFillColor(){
        return fillColor;
    }
    public String getBorderColor(){
        return borderColor;
    }
    public void printShapeInfo(){
        System.out.println("Цвет фона: " + fillColor);
        System.out.println("Цвет границ: " + borderColor);
    }
}
