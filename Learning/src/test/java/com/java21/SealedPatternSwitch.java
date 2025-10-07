package com.java21;

sealed interface Shape permits Circle, Square {
    double area();
}

record Circle(double radius) implements Shape {
    @Override public double area() { return Math.PI * radius * radius; }
}

record Square(double side) implements Shape {
    @Override public double area() { return side * side; }
}

public class SealedPatternSwitch {
    static String describe(Shape s) {
        return switch (s) {
            case Circle c -> "Circle with area " + c.area();
            case Square sq -> "Square with area " + sq.area();
            // No default needed (all permitted types covered)!
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(new Circle(5))); // "Circle with area 78.53..."
    }
}