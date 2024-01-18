package ru.gb;

public class Calculator {
    public static <T extends Number> void sum(T a, T b) {
        System.out.printf("Сумма: %s\n", a.doubleValue() + b.doubleValue());
    }
    public static <T extends Number> void multiply(T a, T b) {
        System.out.printf("Произведение: %s\n", a.doubleValue() * b.doubleValue());
    }
    
    public static <T extends Number> void divide(T a, T b) {
        if (b.doubleValue() == 0) {
            System.out.println("Деление на ноль!");
            return;
        }
        System.out.printf("Деление: %s\n", a.doubleValue() / b.doubleValue());
    }
    
    public static <T extends Number> void subtract(T a, T b) {
        System.out.printf("Разность: %s\n", a.doubleValue() - b.doubleValue());
    }
}
