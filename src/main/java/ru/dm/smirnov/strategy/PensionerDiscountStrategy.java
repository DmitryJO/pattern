package ru.dm.smirnov.strategy;

/**
 * Конкретная стратегия: Скидка для пенсионеров (15%)
 */
public class PensionerDiscountStrategy implements DiscountStrategy {
    
    private static final double DISCOUNT_PERCENT = 0.15; // 15%
    
    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice * (1 - DISCOUNT_PERCENT); // Цена минус 15%
    }
    
    @Override
    public String getDiscountName() {
        return "Скидка для пенсионеров (15%)";
    }
}

