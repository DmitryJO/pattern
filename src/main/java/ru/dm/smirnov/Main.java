package ru.dm.smirnov;

import ru.dm.smirnov.observer.*;

/**
 * Демонстрация паттерна Observer (Наблюдатель)
 * 
 * Этот пример показывает, как паттерн Observer позволяет объектам
 * подписываться на события и автоматически получать уведомления
 * об изменениях состояния.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║   ДЕМОНСТРАЦИЯ ПАТТЕРНА OBSERVER (НАБЛЮДАТЕЛЬ)   ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");
        
        // Создаем метеостанцию (Subject - издатель)
        WeatherData weatherData = new WeatherData();
        
        // Создаем различные дисплеи (Observers - подписчики)
        // Они автоматически регистрируются при создании
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        
        System.out.println("\n=== Все наблюдатели зарегистрированы ===\n");
        
        // Симулируем получение новых данных о погоде
        // Все зарегистрированные наблюдатели автоматически получат уведомления
        System.out.println(" Симуляция получения данных о погоде...\n");
        weatherData.setMeasurements(25.5f, 65.0f, 1013.2f);
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Получаем еще данные - все наблюдатели снова обновятся
        System.out.println(" Новые данные о погоде...\n");
        weatherData.setMeasurements(27.0f, 70.0f, 1012.8f);
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Еще одни данные
        System.out.println(" Еще одни данные о погоде...\n");
        weatherData.setMeasurements(26.0f, 68.0f, 1014.0f);
        
        System.out.println("\n" + "=".repeat(60) + "\n");
        
        // Демонстрация: можем отписать наблюдателя
        System.out.println(" Отписываем ForecastDisplay от уведомлений...\n");
        weatherData.removeObserver(forecastDisplay);
        
        // Теперь при новых данных ForecastDisplay не получит уведомление
        System.out.println("\n Новые данные о погоде (ForecastDisplay не получит уведомление)...\n");
        weatherData.setMeasurements(24.5f, 60.0f, 1015.5f);
        
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║   Демонстрация завершена!                        ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

}
