package ru.dm.smirnov.command;

/**
 * Конкретная команда: Увеличить громкость телевизора
 */
public class TVVolumeUpCommand implements Command {
    private TV tv;
    
    public TVVolumeUpCommand(TV tv) {
        this.tv = tv;
    }
    
    @Override
    public void execute() {
        tv.volumeUp();
    }
    
    @Override
    public void undo() {
        tv.volumeDown();
    }
}

