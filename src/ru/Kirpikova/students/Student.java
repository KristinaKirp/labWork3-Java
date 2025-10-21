package ru.Kirpikova.students;

import java.util.Arrays;

public class Student {
    private String name;
    private int[] grades;
    private int gradeCount;

    public Student(String name, int gradeArraySize) {
        Validation.validateName(name);
        Validation.validateGradeArraySize(gradeArraySize);

        this.name = name;
        this.grades = new int[gradeArraySize];
        this.gradeCount = 0;
    }

    public void addGrade(int grade) {
        Validation.validateGrade(grade);

        if (grades.length == 0) {
            throw new RuntimeException("Нельзя добавить оценку: массив имеет размер 0.");
        }
        if (gradeCount >= grades.length) {
            throw new RuntimeException("Массив оценок заполнен!");
        }

        grades[gradeCount++] = grade;
    }

    public double getAverageGrade() {
        if (gradeCount == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return (double) sum / gradeCount;
    }

    @Override
    public String toString() {
        // отображаем только фактические оценки, а не пустые элементы массива
        int[] actualGrades = Arrays.copyOf(grades, gradeCount);
        return "Студент: " + name +
                ", оценки: " + Arrays.toString(actualGrades) +
                ", средний балл: " + String.format("%.2f", getAverageGrade());
    }
}
