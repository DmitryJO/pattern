package ru.dm.smirnov.command;

/**
 * Конкретная команда: Уменьшить громкость телевизора
 */
public class TVVolumeDownCommand implements Command {
    private TV tv;
    
    public TVVolumeDownCommand(TV tv) {
        this.tv = tv;
    }
    
    @Override
    public void execute() {
        tv.volumeDown();
    }
    
    @Override
    public void undo() {
        tv.volumeUp();
    }
}

