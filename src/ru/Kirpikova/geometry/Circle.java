package ru.Kirpikova.geometry;

public class Circle extends Figure {
    private Coordinates2D center;
    private int radius;

    public Circle(Coordinates2D center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Круг: центр " + center + ", радиус = " + radius + ", площадь = " + getArea();
    }

}
