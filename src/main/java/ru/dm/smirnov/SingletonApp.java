package ru.dm.smirnov;

public class SingletonApp {

    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // всегда true т.к любой instance это один и тот же объект
        boolean isSingleton = instance1.equals(instance2);
        System.out.println(isSingleton);
    }

}
