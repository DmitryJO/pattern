package ru.dm.smirnov;

import ru.dm.smirnov.command.*;

/**
 * Демонстрация паттерна Command (Команда)
 * 
 * Простой пример: пульт управления для дома.
 * Команды инкапсулируют запросы как объекты, позволяя:
 * - параметризовать объекты запросами
 * - ставить запросы в очередь
 * - поддерживать отмену операций
 * - логировать запросы
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("  ПАТТЕРН COMMAND (КОМАНДА)");
        System.out.println("  Пример: Пульт управления для дома");
        System.out.println("=========================================\n");
        
        // Создаем устройства (Receivers)
        Light livingRoomLight = new Light("Гостиная");
        Light kitchenLight = new Light("Кухня");
        TV tv = new TV();
        
        // Создаем команды
        Command livingRoomLightOn = new TurnOnLightCommand(livingRoomLight);
        Command livingRoomLightOff = new TurnOffLightCommand(livingRoomLight);
        Command kitchenLightOn = new TurnOnLightCommand(kitchenLight);
        Command kitchenLightOff = new TurnOffLightCommand(kitchenLight);
        Command tvOn = new TurnOnTVCommand(tv);
        Command tvOff = new TurnOffTVCommand(tv);
        Command tvVolumeUp = new TVVolumeUpCommand(tv);
        Command tvVolumeDown = new TVVolumeDownCommand(tv);
        
        // Создаем пульт управления (Invoker)
        RemoteControl remote = new RemoteControl();
        
        // Назначаем команды на кнопки пульта
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, tvOn, tvOff);
        
        // Показываем, какие команды назначены
        remote.showButtons();
        
        // Пример 1: Используем пульт для управления устройствами
        System.out.println("\n=== Пример 1: Управление устройствами ===");
        remote.pressOnButton(0);   // Включить свет в гостиной
        remote.pressOnButton(1);   // Включить свет на кухне
        remote.pressOnButton(2);   // Включить телевизор
        remote.pressOffButton(0);  // Выключить свет в гостиной
        
        // Пример 2: Отмена команд
        System.out.println("\n=== Пример 2: Отмена команд ===");
        remote.pressUndoButton();  // Отменяем последнюю команду (свет в гостиной снова включится)
        remote.pressUndoButton();  // Отменяем еще одну команду
        
        // Пример 3: Команды можно выполнять напрямую
        System.out.println("\n=== Пример 3: Выполнение команд напрямую ===");
        tvVolumeUp.execute();      // Увеличить громкость
        tvVolumeUp.execute();      // Еще раз увеличить
        tvVolumeDown.execute();    // Уменьшить громкость
        
        // Пример 4: Команды можно параметризовать
        System.out.println("\n=== Пример 4: Команды как параметры ===");
        executeCommand(livingRoomLightOn);   // Передаем команду в метод
        executeCommand(tvOff);               // Можно передать любую команду
        
        System.out.println("\n=========================================");
        System.out.println("  Ключевая идея паттерна:");
        System.out.println("  - Команда инкапсулирует запрос как объект");
        System.out.println("  - Пульт (Invoker) не знает, что делает команда");
        System.out.println("  - Устройство (Receiver) знает, как выполнить действие");
        System.out.println("  - Команды можно отменять, логировать, ставить в очередь");
        System.out.println("=========================================");
    }
    
    /**
     * Пример метода, который принимает команду как параметр
     * Это показывает, как команды можно передавать и использовать гибко
     */
    private static void executeCommand(Command command) {
        System.out.println("\n[Выполнение команды через метод]");
        command.execute();
    }

}
