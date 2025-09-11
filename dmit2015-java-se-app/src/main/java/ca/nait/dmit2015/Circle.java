package ca.nait.dmit2015;

public class Circle {

    // backing field
    private double radius;

    // properties - getter/setters
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        this.radius = radius;
    }

    // Create a circle with a radius of 1
    public Circle() {
        setRadius(1);
    }

    // Create a circle with a specific radius
    public Circle(double radius) {
//        this.radius = radius;
        setRadius(radius);
    }

    public double diameter() {
        return radius * 2;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
