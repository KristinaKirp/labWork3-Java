package ru.Kirpikova.main;
import ru.Kirpikova.geometry.Coordinates2D;

public class Polyline {
    private Coordinates2D[] points;

    public Polyline(Coordinates2D[] points) {
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException("Ломаная линия должна содержать хотя бы 2 точки");
        }
        this.points = points;
    }

    public Coordinates2D[] getPoints() {
        return points;
    }

    public int getSize() {
        return points.length;
    }


    @Override
    public String toString() {
        String result = "ru.kirpikova.main.ru.Kirpikova.main.Polyline: ";
        for (int i = 0; i < points.length; i++) {
            result += points[i];
            if (i < points.length - 1) {
                result += " - ";
            }
        }
        return result;
    }
}
