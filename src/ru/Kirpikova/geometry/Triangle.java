package ru.Kirpikova.geometry;

public class Triangle extends Figure {
    private Coordinates2D p1;
    private Coordinates2D p2;
    private Coordinates2D p3;

    public Triangle(Coordinates2D p1, Coordinates2D p2, Coordinates2D p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public double getArea() {
        double a = Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
        double b = Math.hypot(p2.getX() - p3.getX(), p2.getY() - p3.getY());
        double c = Math.hypot(p3.getX() - p1.getX(), p3.getY() - p1.getY());
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString() {
        return "Треугольник: точки " + p1 + ", " + p2 + ", " + p3 + ", площадь = " + getArea();
    }
}
