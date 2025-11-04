package ru.dm.smirnov.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс WeatherData - конкретная реализация Subject (Издателя)
 * 
 * Представляет метеостанцию, которая собирает данные о погоде
 * и уведомляет всех подписчиков об изменениях.
 */
public class WeatherData implements Subject {
    // Список всех наблюдателей (подписчиков)
    private List<Observer> observers;
    
    // Данные о погоде
    private float temperature;
    private float humidity;
    private float pressure;
    
    public WeatherData() {
        this.observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Новый наблюдатель зарегистрирован: " + observer.getClass().getSimpleName());
    }
    
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Наблюдатель удален: " + observer.getClass().getSimpleName());
    }
    
    @Override
    public void notifyObservers() {
        // Уведомляем всех подписчиков об изменениях
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
    
    /**
     * Метод вызывается, когда метеостанция получает новые данные
     * После обновления данных уведомляются все наблюдатели
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        
        System.out.println("\n=== Метеостанция получила новые данные ===");
        measurementsChanged(); // Уведомляем всех подписчиков
    }
    
    /**
     * Внутренний метод, который уведомляет всех наблюдателей
     */
    private void measurementsChanged() {
        notifyObservers();
    }
    
    // Геттеры для получения текущих данных
    public float getTemperature() {
        return temperature;
    }
    
    public float getHumidity() {
        return humidity;
    }
    
    public float getPressure() {
        return pressure;
    }
}

