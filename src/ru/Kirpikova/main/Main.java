package ru.Kirpikova.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ru.Kirpikova.phones.BookPhone;
import ru.Kirpikova.students.Student;
import ru.Kirpikova.geometry.Circle;
import ru.Kirpikova.geometry.Coordinates2D;
import ru.Kirpikova.geometry.Figure;
import ru.Kirpikova.geometry.Coordinates3D;
import ru.Kirpikova.geometry.Rectangle;
import ru.Kirpikova.geometry.Point;
import ru.Kirpikova.geometry.Square;
import ru.Kirpikova.geometry.Triangle;
import ru.Kirpikova.math.Power;
import ru.Kirpikova.validator.Validation;
import ru.Kirpikova.validator.InvalidGradeException;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookPhone bookPhone = new BookPhone();
        List<Figure> areaOfFigurer = new ArrayList<>();

        while (true) {
            System.out.println("Выберите номер задания:");
            System.out.println("Задание 1.9");
            System.out.println("Задание 2.3");
            System.out.println("Задание 3.5");
            System.out.println("Задание 4.4");
            System.out.println("Задание 5.3");
            System.out.println("Задание 5.6");
            System.out.println("Задание 6.2");
            System.out.println("Задание 7.3");
            System.out.println("Задание 8.4");
            System.out.println("Выход 0");

            String mainChoice = scanner.next();

            switch (mainChoice) {
                case "1.9":
                    try {
                        System.out.println("Введите имя студента:");
                        String name = scanner.nextLine();

                        System.out.println("Введите количество оценок, которое хотите добавить:");
                        int count;
                        if (scanner.hasNextInt()) {
                            count = scanner.nextInt();
                        } else {
                            throw new RuntimeException("Нужно ввести целое число!");
                        }

                        Student student = new Student(name, count);

                        for (int i = 0; i < count; i++) {
                            System.out.println("Введите оценку №" + (i + 1) + " (от 2 до 5):");
                            int grade;

                            if (scanner.hasNextInt()) {
                                grade = scanner.nextInt();
                            } else {
                                System.out.println("Ошибка ввода");
                                scanner.next();
                                i--;
                                continue;
                            }

                            try {
                                student.addGrade(grade);
                            } catch (InvalidGradeException e) {
                                System.out.println("Ошибка: " + e.getMessage());
                                i--;
                            } catch (RuntimeException e) {
                                System.out.println("Ошибка: " + e.getMessage());
                                break;
                            }
                        }
                        System.out.println(student.toString());

                    } catch (RuntimeException ex) {
                        System.out.println("Ошибка: " + ex.getMessage());
                    }
                    break;
                case "2.3":
                    while (true) {
                        System.out.println("Телефонный справочник");
                        System.out.println("1. Добавить контакт");
                        System.out.println("2. Показать все контакты");
                        System.out.println("3. Удалить контакт");
                        System.out.println("4. Найти телефон по имени");
                        System.out.println("5. Проверить имя");
                        System.out.println("6. Проверить телефон");
                        System.out.println("7. Количество контактов");
                        System.out.println("8. Все пары");
                        System.out.println("9. Все телефоны");
                        System.out.println("10. Все имена");
                        System.out.println("11. Поиск имен по префиксу");
                        System.out.println("0. Назад");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        if (choice == 0) {
                            break;
                        }

                        try {
                            switch (choice) {
                                case 1:
                                    System.out.println("Введите имя:");
                                    String name = scanner.nextLine();
                                    Validation.validateName(name);
                                    System.out.println("Введите телефон:");
                                    String phone = scanner.nextLine();
                                    Validation.validatePhone(phone);
                                    bookPhone.addContact(name, phone);
                                    break;
                                case 2:
                                    System.out.println(bookPhone.toString());
                                    break;
                                case 3:
                                    System.out.println("Введите имя для удаления:");
                                    name = scanner.nextLine();
                                    Validation.validateName(name);
                                    bookPhone.removeContact(name);
                                    break;
                                case 4:
                                    System.out.println("Введите имя для поиска:");
                                    name = scanner.nextLine();
                                    Validation.validateName(name);
                                    System.out.println(bookPhone.getPhone(name));
                                    break;
                                case 5:
                                    System.out.println("Введите имя для проверки:");
                                    name = scanner.nextLine();
                                    Validation.validateName(name);
                                    System.out.println(bookPhone.containsName(name));
                                    break;
                                case 6:
                                    System.out.println("Введите телефон для проверки:");
                                    phone = scanner.nextLine();
                                    Validation.validatePhone(phone);
                                    System.out.println(bookPhone.containsPhone(phone));
                                    break;
                                case 7:
                                    System.out.println(bookPhone.getSize());
                                    break;
                                case 8:
                                    System.out.println(java.util.Arrays.toString(bookPhone.getAllPairs()));
                                    break;
                                case 9:
                                    System.out.println(java.util.Arrays.toString(bookPhone.getAllPhones()));
                                    break;
                                case 10:
                                    System.out.println(java.util.Arrays.toString(bookPhone.getAllNames()));
                                    break;
                                case 11:
                                    System.out.println("Введите префикс:");
                                    String prefix = scanner.nextLine();
                                    Validation.validatePrefix(prefix);
                                    System.out.println(java.util.Arrays.toString(bookPhone.getNamesStartingWith(prefix)));
                                    break;
                                default:
                                    System.out.println("Неверный выбор!");
                            }
                        } catch (RuntimeException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                    }
                    break;
                case "3.5":
                    System.out.println("Введите координату X для 3D точки:");
                    int x3 = scanner.nextInt();
                    System.out.println("Введите координату Y для 3D точки:");
                    int y3 = scanner.nextInt();
                    System.out.println("Введите координату Z для 3D точки:");
                    int z3 = scanner.nextInt();
                    Coordinates3D point3D = new Coordinates3D(x3, y3, z3);
                    System.out.println("Введённая 3D точка: " + point3D);
                    break;
                case "4.4":
                    while (true) {
                        System.out.println("1. Круг");
                        System.out.println("2. Квадрат");
                        System.out.println("3. Прямоугольник");
                        System.out.println("4. Треугольник");
                        System.out.println("0. Назад");
                        System.out.print("Ваш выбор: ");

                        int figChoice = scanner.nextInt();
                        if (figChoice == 0) {
                            break;
                        }
                        try {
                            switch (figChoice) {
                                case 1:
                                    System.out.print("Введите X центра: ");
                                    int xC = scanner.nextInt();
                                    System.out.print("Введите Y центра: ");
                                    int yC = scanner.nextInt();
                                    Coordinates2D center = new Coordinates2D(xC, yC);

                                    System.out.print("Введите радиус: ");
                                    int radius = scanner.nextInt();
                                    Circle circle = new Circle(center, radius);
                                    areaOfFigurer.add(circle);
                                    System.out.println("Площадь круга: " + circle.getArea());

                                    break;

                                case 2:
                                    System.out.print("Введите X верхнего левого угла: ");
                                    int xS = scanner.nextInt();
                                    System.out.print("Введите Y верхнего левого угла: ");
                                    int yS = scanner.nextInt();
                                    Coordinates2D squarePoint = new Coordinates2D(xS, yS);
                                    System.out.print("Введите длину стороны: ");
                                    int side = scanner.nextInt();
                                    Square square = new Square(squarePoint, side);
                                    areaOfFigurer.add(square);
                                    System.out.println("Площадь квадрата: " + square.getArea());
                                    break;

                                case 3:
                                    System.out.print("Введите X верхнего левого угла: ");
                                    int xR = scanner.nextInt();
                                    System.out.print("Введите Y верхнего левого угла: ");
                                    int yR = scanner.nextInt();
                                    Coordinates2D rectPoint = new Coordinates2D(xR, yR);

                                    System.out.print("Введите ширину: ");
                                    int width = scanner.nextInt();
                                    System.out.print("Введите высоту: ");
                                    int height = scanner.nextInt();
                                    Rectangle rectangle = new Rectangle(rectPoint, width, height);
                                    areaOfFigurer.add(rectangle);
                                    System.out.println("Площадь прямоугольника: " + rectangle.getArea());
                                    break;

                                case 4:
                                    System.out.print("Введите X первой точки: ");
                                    int xT1 = scanner.nextInt();
                                    System.out.print("Введите Y первой точки: ");
                                    int yT1 = scanner.nextInt();
                                    Coordinates2D pT1 = new Coordinates2D(xT1, yT1);

                                    System.out.print("Введите X второй точки: ");
                                    int xT2 = scanner.nextInt();
                                    System.out.print("Введите Y второй точки: ");
                                    int yT2 = scanner.nextInt();
                                    Coordinates2D pT2 = new Coordinates2D(xT2, yT2);

                                    System.out.print("Введите X третьей точки: ");
                                    int xT3 = scanner.nextInt();
                                    System.out.print("Введите Y третьей точки: ");
                                    int yT3 = scanner.nextInt();
                                    Coordinates2D pT3 = new Coordinates2D(xT3, yT3);

                                    Triangle triangle = new Triangle(pT1, pT2, pT3);
                                    areaOfFigurer.add(triangle);
                                    System.out.println("Площадь треугольника: " + triangle.getArea());
                                    break;
                                default:
                                    System.out.println("Неверный выбор!");
                            }
                        } catch (RuntimeException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                    }
                    break;
                case "5.3":
                    if (areaOfFigurer.isEmpty()) {
                        System.out.println("Сначала создайте фигуры (пункт 1).");
                    } else {
                        double totalArea = 0;
                        for (Figure f : areaOfFigurer) {
                            totalArea += f.getArea();
                        }
                        System.out.println("Общая площадь всех фигур: " + totalArea);
                    }
                    break;
                case "5.6":
                    try {
                        System.out.print("Введите X верхнего левого угла квадрата: ");
                        int x = scanner.nextInt();

                        System.out.print("Введите Y верхнего левого угла квадрата: ");
                        int y = scanner.nextInt();

                        Coordinates2D topLeft = new Coordinates2D(x, y);

                        System.out.print("Введите длину стороны квадрата: ");
                        int side = scanner.nextInt();

                        Square square = new Square(topLeft, side);

                        System.out.println("Площадь квадрата: " + square.getArea());

                        Polyline polyline = square.getPolyline();
                        System.out.println("Замкнутая ломаная линия квадрата: ");
                        for (Coordinates2D point : polyline.getPoints()) {
                            System.out.println(point);
                        }

                    } catch (RuntimeException e) {
                        System.out.println("Ошибка ввода: " + e.getMessage());
                    }
                    break;
                case "6.2":
                    try {
                        System.out.println("Введите координаты первой точки:");
                        System.out.print("X1 = ");
                        int x1 = scanner.nextInt();
                        System.out.print("Y1 = ");
                        int y1 = scanner.nextInt();
                        Coordinates2D point1 = new Coordinates2D(x1, y1);

                        System.out.println("Введите координаты второй точки:");
                        System.out.print("X2 = ");
                        int x2 = scanner.nextInt();
                        System.out.print("Y2 = ");
                        int y2 = scanner.nextInt();
                        Coordinates2D point2 = new Coordinates2D(x2, y2);

                        System.out.println("Первая точка: " + point1);
                        System.out.println("Вторая точка: " + point2);

                        if (point1.equals(point2)) {
                            System.out.println("Точки совпадают!");
                        } else {
                            System.out.println("Точки различны.");
                        }

                    } catch (RuntimeException e) {
                        System.out.println("Ошибка ввода: " + e.getMessage());
                    }
                    break;
                case "7.3":
                    System.out.println("Введите число X:");
                    String xStr = scanner.next();
                    System.out.println("Введите степень Y:");
                    String yStr = scanner.next();
                    double result = Power.power(xStr, yStr);
                    System.out.println(xStr + " ^ " + yStr + " = " + result);
                    break;
            }
        }
    }
}