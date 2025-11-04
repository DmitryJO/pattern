package ru.dm.smirnov.command;

/**
 * Интерфейс Command (Команда)
 * 
 * Инкапсулирует запрос как объект.
 * Все команды реализуют этот интерфейс.
 */
public interface Command {
    /**
     * Выполняет команду
     */
    void execute();
    
    /**
     * Отменяет выполнение команды (опционально)
     */
    void undo();
}

