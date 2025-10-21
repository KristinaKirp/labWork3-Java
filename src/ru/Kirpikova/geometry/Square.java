package ru.Kirpikova.geometry;

import ru.Kirpikova.main.Polyline;


public class Square extends Figure {
    private Coordinates2D topLeft;
    private int side;

    public Square(Coordinates2D topLeft, int side) {
        this.topLeft = topLeft;
        this.side = side;
    }

    public Polyline getPolyline() {
        Coordinates2D[] points = new Coordinates2D[5];
        points[0] = topLeft;
        points[1] = new Coordinates2D(topLeft.getX() + side, topLeft.getY());
        points[2] = new Coordinates2D(topLeft.getX() + side, topLeft.getY() + side);
        points[3] = new Coordinates2D(topLeft.getX(), topLeft.getY() + side);
        points[4] = topLeft;
        return new Polyline(points);
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Квадрат: верхний левый угол " + topLeft + ", сторона = " + side + ", площадь = " + getArea();
    }
}
