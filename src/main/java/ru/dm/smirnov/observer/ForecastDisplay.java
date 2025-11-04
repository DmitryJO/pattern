package ru.dm.smirnov.observer;

/**
 * Класс ForecastDisplay - еще одна реализация Observer
 * 
 * Отображает прогноз погоды на основе текущего давления.
 * Демонстрирует, что каждый наблюдатель может реагировать
 * на одни и те же данные по-разному.
 */
public class ForecastDisplay implements Observer {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private Subject weatherData;
    
    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }
    
    public void display() {
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│   ПРОГНОЗ ПОГОДЫ                │");
        System.out.println("├─────────────────────────────────┤");
        
        if (currentPressure > lastPressure) {
            System.out.println("│  Прогноз: Улучшение погоды!    │");
        } else if (currentPressure == lastPressure) {
            System.out.println("│  Прогноз: Без изменений        │");
        } else {
            System.out.println("│  Прогноз: Ухудшение погоды     │");
        }
        
        System.out.printf("│  Давление: %.2f мм рт.ст.      │\n", currentPressure);
        System.out.println("└─────────────────────────────────┘");
    }
}

