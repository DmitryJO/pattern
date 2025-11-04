package ru.dm.smirnov.observer;

/**
 * Класс StatisticsDisplay - еще одна реализация Observer
 * 
 * Отображает статистику по погоде (минимум, максимум, среднее).
 * Показывает, что может быть несколько разных подписчиков.
 */
public class StatisticsDisplay implements Observer {
    private float maxTemp = 0.0f;
    private float minTemp = 200.0f;
    private float tempSum = 0.0f;
    private int numReadings = 0;
    private Subject weatherData;
    
    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(float temperature, float humidity, float pressure) {
        tempSum += temperature;
        numReadings++;
        
        if (temperature > maxTemp) {
            maxTemp = temperature;
        }
        
        if (temperature < minTemp) {
            minTemp = temperature;
        }
        
        display();
    }
    
    public void display() {
        float avgTemp = tempSum / numReadings;
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│   СТАТИСТИКА ПОГОДЫ             │");
        System.out.println("├─────────────────────────────────┤");
        System.out.printf("│  Средняя температура: %.1f°C   │\n", avgTemp);
        System.out.printf("│  Максимальная: %.1f°C          │\n", maxTemp);
        System.out.printf("│  Минимальная: %.1f°C            │\n", minTemp);
        System.out.printf("│  Измерений: %d                  │\n", numReadings);
        System.out.println("└─────────────────────────────────┘");
    }
}

