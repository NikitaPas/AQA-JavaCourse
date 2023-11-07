package Lesson5;

public interface Calculate {
    default double calculatePerimeter(double radius){ // Circle
         return Math.PI * 2 * radius;
    }
    default double calculatePerimeter(double width, double length){ // Rectangle
        return 2 * (width + length);
    } // Recrangle
    default double calculatePerimeter(double side1, double side2, double side3){ // triangle
        return side1 + side2 + side3;
    } // Triangle
    default double calculateSquare(double radius){ // Circle
        return Math.PI * (radius*radius);
    }
    default double calculateSquare(double width, double length){ // Rectangle
        return width * length;
    } // Recrangle
    default double calculateSquare(double side1, double side2, double side3, double r){ // triangle
        return (double) side1 * side2 * side3 / (4 * r);
    } // Triangle
}
