package ru.dm.smirnov.observer;

/**
 * Класс CurrentConditionsDisplay - конкретная реализация Observer
 * 
 * Отображает текущие условия погоды.
 * Это один из подписчиков метеостанции.
 */
public class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;
    private Subject weatherData;
    
    /**
     * Конструктор принимает Subject для регистрации себя как наблюдателя
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
    
    /**
     * Отображает текущие условия
     */
    public void display() {
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│   ТЕКУЩИЕ УСЛОВИЯ ПОГОДЫ        │");
        System.out.println("├─────────────────────────────────┤");
        System.out.printf("│  Температура: %.1f°C            │\n", temperature);
        System.out.printf("│  Влажность: %.1f%%              │\n", humidity);
        System.out.println("└─────────────────────────────────┘");
    }
}

