package ru.Kirpikova.validator;

public class Validation {
    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Имя не может быть пустым!");
        }
        if(name.length()<2){
            throw new InvalidNameException ("Имя не может быть меньше 2 букв!");
        }
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            if(!Character.isLetter(c)){
                throw new InvalidNameException ("Имя должно состоять только из букв!");
            }
        }
    }

    public static void validateGradeArraySize(int size) {
        if (size < 0) {
            throw new InvalidArraySizeException("Размер массива не может быть отрицательным!");
        }
    }

    public static void validateGrade(int grade) {
        if (grade < 2 || grade > 5) {
            throw new InvalidGradeException("Оценка " + grade + " недопустима! Разрешены только 2–5.");
        }
    }

    public static void validatePhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new InvalidPhoneException("Телефон не может быть пустым!");
        }
        if (!phone.matches("\\+?\\d+")) {
            throw new InvalidPhoneException ( "Телефон должен содержать только цифры.");
        }
    }
    public static void validatePrefix(String prefix) {
        if (prefix == null || prefix.trim().isEmpty()) {
            throw new InvalidPrefixException("Префикс не может быть пустым!");
        }
    }
}
