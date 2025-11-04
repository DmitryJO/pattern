package ru.dm.smirnov.command;

/**
 * Пустая команда (Null Object Pattern)
 * 
 * Используется для инициализации кнопок пульта.
 * Позволяет не проверять на null перед вызовом execute().
 */
public class NoCommand implements Command {
    
    @Override
    public void execute() {
        // Пустая команда - ничего не делает
    }
    
    @Override
    public void undo() {
        // Пустая команда - ничего не делает
    }
}

