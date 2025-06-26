package ru.dm.smirnov;

/**
 * Singleton - реализует одноименный паттерн.
 * Из данного класса можно получить только 1 объект.
 * Имеет единую точку получения объекта.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Тестовый метод
    public void work() {
        System.out.println("Singleton works");
    }

}
