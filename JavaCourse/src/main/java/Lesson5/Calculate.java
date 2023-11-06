package Lesson5;

public interface Calculate {
    default double calculatePerimeter(int r){ // Circle
         return Math.PI * 2 * r;
    }
    default double calculatePerimeter(int width, int length){ // Rectangle
        return 2 * (width + length);
    }
    default double calculatePerimeter(int a, int b, int c){ // triangle
        return a + b + c;
    }
    default double calculateSquare(int r){ // Circle
        return Math.PI * r*r;
    }
    default double calculateSquare(int width, int length){ // Rectangle
        return width * length;
    }
    default double calculateSquare(int a, int b, int c, int r){ // triangle
        return (double) a * b * c / (4 * r);
    }
}
