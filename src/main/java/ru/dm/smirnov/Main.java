package ru.dm.smirnov;

import ru.dm.smirnov.decorator.*;

/**
 * Демонстрация паттерна Decorator (Декоратор)
 * 
 * Простой пример: кофе с добавками.
 * Декораторы позволяют добавлять функциональность (молоко, сахар, сливки)
 * к базовому объекту (кофе) динамически, оборачивая его.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("  ПАТТЕРН DECORATOR (ДЕКОРАТОР)");
        System.out.println("  Пример: Кофе с добавками");
        System.out.println("=========================================\n");
        
        // Пример 1: Простой кофе без добавок
        System.out.println("=== Пример 1: Простой кофе ===");
        Beverage coffee1 = new SimpleCoffee();
        printBeverage(coffee1);
        
        // Пример 2: Кофе с молоком
        // Обертываем SimpleCoffee в MilkDecorator
        System.out.println("\n=== Пример 2: Кофе с молоком ===");
        Beverage coffee2 = new MilkDecorator(new SimpleCoffee());
        printBeverage(coffee2);
        
        // Пример 3: Кофе с молоком и сахаром
        // Обертываем SimpleCoffee в MilkDecorator, затем в SugarDecorator
        System.out.println("\n=== Пример 3: Кофе с молоком и сахаром ===");
        Beverage coffee3 = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        printBeverage(coffee3);
        
        // Пример 4: Кофе со всеми добавками
        // Можно оборачивать сколько угодно раз!
        System.out.println("\n=== Пример 4: Кофе со всеми добавками ===");
        Beverage coffee4 = new WhippedCreamDecorator(
                            new SugarDecorator(
                                new MilkDecorator(
                                    new SimpleCoffee())));
        printBeverage(coffee4);
        
        // Пример 5: Только кофе с сахаром
        System.out.println("\n=== Пример 5: Кофе только с сахаром ===");
        Beverage coffee5 = new SugarDecorator(new SimpleCoffee());
        printBeverage(coffee5);
        
        // Пример 6: Показываем, как можно динамически добавлять декораторы
        System.out.println("\n=== Пример 6: Динамическое добавление декораторов ===");
        Beverage coffee6 = new SimpleCoffee();
        System.out.println("Начальный кофе:");
        printBeverage(coffee6);
        
        System.out.println("\nДобавляем молоко...");
        coffee6 = new MilkDecorator(coffee6);
        printBeverage(coffee6);
        
        System.out.println("\nДобавляем сахар...");
        coffee6 = new SugarDecorator(coffee6);
        printBeverage(coffee6);
        
        System.out.println("\n=========================================");
        System.out.println("  РЕШЕНИЕ ПРОБЛЕМЫ 1: Множество операторов new");
        System.out.println("  Используем Builder паттерн для читаемости");
        System.out.println("=========================================\n");
        
        // Используем Builder - читаемо и красиво!
        System.out.println("=== Builder паттерн для создания кофе ===");
        Beverage coffeeBuilder1 = new CoffeeBuilder()
            .withMilk()
            .withSugar()
            .build();
        printBeverage(coffeeBuilder1);
        
        System.out.println("\nКофе со всеми добавками через Builder:");
        Beverage coffeeBuilder2 = new CoffeeBuilder()
            .withMilk()
            .withSugar()
            .withWhippedCream()
            .build();
        printBeverage(coffeeBuilder2);
        
        System.out.println("\n=========================================");
        System.out.println("  РЕШЕНИЕ ПРОБЛЕМЫ 2: Добавление к существующему объекту");
        System.out.println("  Используем обертку DecoratedBeverage");
        System.out.println("=========================================\n");
        
        // Создаем базовый кофе
        System.out.println("=== Создаем базовый кофе ===");
        DecoratedBeverage coffee7 = new DecoratedBeverage(new SimpleCoffee());
        printBeverage(coffee7);
        
        // Добавляем декораторы к уже созданному объекту
        System.out.println("\nДобавляем молоко к существующему объекту...");
        coffee7 = coffee7.addMilk();
        printBeverage(coffee7);
        
        System.out.println("\nДобавляем сахар...");
        coffee7 = coffee7.addSugar();
        printBeverage(coffee7);
        
        System.out.println("\nДобавляем взбитые сливки...");
        coffee7 = coffee7.addWhippedCream();
        printBeverage(coffee7);

    }
    
    /**
     * Вспомогательный метод для вывода информации о напитке
     */
    private static void printBeverage(Beverage beverage) {
        System.out.println("Описание: " + beverage.getDescription());
        System.out.println("Стоимость: " + beverage.getCost() + " руб.");
    }

}
