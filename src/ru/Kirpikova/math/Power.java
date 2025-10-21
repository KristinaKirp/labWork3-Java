package ru.Kirpikova.math;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Power {
    public static double power(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }
}
