package ru.dm.smirnov.command;

/**
 * Конкретная команда: Выключить свет
 */
public class TurnOffLightCommand implements Command {
    private Light light;
    
    public TurnOffLightCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.turnOff();
    }
    
    @Override
    public void undo() {
        light.turnOn();
    }
}

