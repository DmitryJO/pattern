package ru.dm.smirnov.command;

/**
 * Конкретная команда: Включить свет
 * 
 * Инкапсулирует запрос на включение света.
 * Связывает действие (включить свет) с получателем (Light).
 */
public class TurnOnLightCommand implements Command {
    private Light light;
    
    public TurnOnLightCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOn();
    }
    
    @Override
    public void undo() {
        light.turnOff();
    }
}

