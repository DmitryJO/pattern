package ru.dm.smirnov.strategy;

/**
 * Класс Context (Контекст)
 * 
 * Использует стратегию расчета скидки.
 * Может менять стратегию в любой момент.
 */
public class PriceCalculator {
    private DiscountStrategy discountStrategy;
    
    /**
     * Конструктор с установкой стратегии
     */
    public PriceCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    /**
     * Устанавливает новую стратегию скидки
     */
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    /**
     * Рассчитывает финальную цену используя текущую стратегию
     */
    public double calculateFinalPrice(double originalPrice) {
        return discountStrategy.calculatePrice(originalPrice);
    }
    
    /**
     * Возвращает название текущей стратегии
     */
    public String getCurrentDiscountName() {
        return discountStrategy.getDiscountName();
    }
}

