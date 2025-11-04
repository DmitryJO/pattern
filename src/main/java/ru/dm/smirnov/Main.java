package ru.dm.smirnov;

import ru.dm.smirnov.strategy.*;

/**
 * Демонстрация паттерна Strategy (Стратегия)
 * 
 * Простой пример: расчет цены товара со скидками.
 * Разные стратегии = разные способы расчета скидки.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("  ПАТТЕРН STRATEGY (СТРАТЕГИЯ)");
        System.out.println("  Пример: Расчет цены со скидками");
        System.out.println("=========================================\n");
        
        double originalPrice = 1000.0; // Исходная цена товара
        System.out.println("Исходная цена товара: " + originalPrice + " руб.\n");
        
        // Создаем калькулятор цен с начальной стратегией (без скидки)
        PriceCalculator calculator = new PriceCalculator(new NoDiscountStrategy());
        
        // Пример 1: Обычный покупатель (без скидки)
        System.out.println("=== Пример 1: Обычный покупатель ===");
        double finalPrice1 = calculator.calculateFinalPrice(originalPrice);
        System.out.println("Стратегия: " + calculator.getCurrentDiscountName());
        System.out.println("Итоговая цена: " + finalPrice1 + " руб.\n");
        
        // Пример 2: Меняем стратегию на скидку для студентов
        System.out.println("=== Пример 2: Студент ===");
        calculator.setDiscountStrategy(new StudentDiscountStrategy());
        double finalPrice2 = calculator.calculateFinalPrice(originalPrice);
        System.out.println("Стратегия: " + calculator.getCurrentDiscountName());
        System.out.println("Итоговая цена: " + finalPrice2 + " руб.");
        System.out.println("Скидка: " + (originalPrice - finalPrice2) + " руб.\n");
        
        // Пример 3: Меняем стратегию на скидку для пенсионеров
        System.out.println("=== Пример 3: Пенсионер ===");
        calculator.setDiscountStrategy(new PensionerDiscountStrategy());
        double finalPrice3 = calculator.calculateFinalPrice(originalPrice);
        System.out.println("Стратегия: " + calculator.getCurrentDiscountName());
        System.out.println("Итоговая цена: " + finalPrice3 + " руб.");
        System.out.println("Скидка: " + (originalPrice - finalPrice3) + " руб.\n");
        
        // Пример 4: Праздничная скидка
        System.out.println("=== Пример 4: Праздничная акция ===");
        calculator.setDiscountStrategy(new HolidayDiscountStrategy());
        double finalPrice4 = calculator.calculateFinalPrice(originalPrice);
        System.out.println("Стратегия: " + calculator.getCurrentDiscountName());
        System.out.println("Итоговая цена: " + finalPrice4 + " руб.");
        System.out.println("Скидка: " + (originalPrice - finalPrice4) + " руб.\n");
        
        // Пример 5: Выбор стратегии в зависимости от типа покупателя
        System.out.println("=== Пример 5: Выбор стратегии в зависимости от покупателя ===");
        
        String buyerType = "студент"; // Можно менять: "студент", "пенсионер", "обычный"
        DiscountStrategy strategy;
        
        if ("студент".equals(buyerType)) {
            strategy = new StudentDiscountStrategy();
        } else if ("пенсионер".equals(buyerType)) {
            strategy = new PensionerDiscountStrategy();
        } else {
            strategy = new NoDiscountStrategy();
        }
        
        calculator.setDiscountStrategy(strategy);
        double finalPrice5 = calculator.calculateFinalPrice(originalPrice);
        System.out.println("Тип покупателя: " + buyerType);
        System.out.println("Применена стратегия: " + calculator.getCurrentDiscountName());
        System.out.println("Итоговая цена: " + finalPrice5 + " руб.\n");
        
        System.out.println("=========================================");
        System.out.println("  Ключевая идея паттерна:");
        System.out.println("  - Один класс (PriceCalculator)");
        System.out.println("  - Может использовать разные стратегии");
        System.out.println("  - Стратегии можно менять в любой момент");
        System.out.println("  - Легко добавить новую стратегию");
        System.out.println("=========================================");
    }

}
