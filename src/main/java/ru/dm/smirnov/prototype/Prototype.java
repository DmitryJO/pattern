package ru.dm.smirnov.prototype;

/**
 * Простой интерфейс для паттерна Prototype с дженериками
 */
public interface Prototype<T> {
    /**
     * Создает копию объекта
     */
    T copy();
} 