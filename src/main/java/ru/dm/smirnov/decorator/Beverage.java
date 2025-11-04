package ru.dm.smirnov.decorator;

/**
 * Интерфейс Beverage (Напиток)
 * 
 * Базовый компонент, который может быть декорирован.
 * Определяет общий интерфейс для всех напитков.
 */
public interface Beverage {
    /**
     * Возвращает описание напитка
     */
    String getDescription();
    
    /**
     * Возвращает стоимость напитка
     */
    double getCost();
}

