package ru.Kirpikova.geometry;

public class Rectangle extends Figure {
    private Coordinates2D topLeft;
    private int width;
    private int height;

    public Rectangle(Coordinates2D topLeft, int width, int height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Прямоугольник: верхний левый угол " + topLeft + ", ширина = " + width +
                ", высота = " + height + ", площадь = " + getArea();
    }
}
