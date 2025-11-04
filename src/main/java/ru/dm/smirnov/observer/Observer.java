package ru.dm.smirnov.observer;

/**
 * Интерфейс Observer (Наблюдатель)
 * 
 * Представляет объект, который должен быть уведомлен об изменениях
 * в состоянии объекта, за которым он наблюдает.
 */
public interface Observer {
    /**
     * Метод вызывается, когда наблюдаемый объект изменяет свое состояние
     * @param temperature температура
     * @param humidity влажность
     * @param pressure давление
     */
    void update(float temperature, float humidity, float pressure);
}

