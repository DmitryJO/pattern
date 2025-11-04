package ru.dm.smirnov.strategy;

/**
 * Интерфейс Strategy (Стратегия)
 * 
 * Определяет способ расчета скидки.
 * Разные стратегии = разные способы расчета скидки.
 */
public interface DiscountStrategy {
    /**
     * Рассчитывает финальную цену со скидкой
     * @param originalPrice исходная цена
     * @return цена со скидкой
     */
    double calculatePrice(double originalPrice);
    
    /**
     * Возвращает название стратегии
     */
    String getDiscountName();
}

