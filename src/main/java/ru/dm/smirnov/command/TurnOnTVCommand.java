package ru.dm.smirnov.command;

/**
 * Конкретная команда: Включить телевизор
 */
public class TurnOnTVCommand implements Command {
    private TV tv;
    
    public TurnOnTVCommand(TV tv) {
        this.tv = tv;
    }
    
    @Override
    public void execute() {
        tv.turnOn();
    }
    
    @Override
    public void undo() {
        tv.turnOff();
    }
}

