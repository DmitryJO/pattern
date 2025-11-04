package ru.dm.smirnov.command;

import java.util.Stack;

/**
 * Класс Invoker (Вызывающий)
 * 
 * Пульт управления. Хранит команды и вызывает их выполнение.
 * Не знает, как выполняется команда - только вызывает execute().
 */
public class RemoteControl {
    // Кнопки на пульте (слоты для команд)
    private Command[] onCommands;
    private Command[] offCommands;
    
    // История команд для отмены
    private Stack<Command> commandHistory;
    
    // Количество кнопок на пульте
    private static final int NUM_SLOTS = 4;
    
    public RemoteControl() {
        onCommands = new Command[NUM_SLOTS];
        offCommands = new Command[NUM_SLOTS];
        commandHistory = new Stack<>();
        
        // По умолчанию все кнопки пустые (NoCommand)
        Command noCommand = new NoCommand();
        for (int i = 0; i < NUM_SLOTS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }
    
    /**
     * Назначает команды на кнопку
     * @param slot номер кнопки (0-3)
     * @param onCommand команда для кнопки "Включить"
     * @param offCommand команда для кнопки "Выключить"
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot < 0 || slot >= NUM_SLOTS) {
            System.out.println("⚠ Неверный номер кнопки!");
            return;
        }
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }
    
    /**
     * Нажимает кнопку "Включить"
     */
    public void pressOnButton(int slot) {
        if (slot < 0 || slot >= NUM_SLOTS) {
            System.out.println("⚠ Неверный номер кнопки!");
            return;
        }
        System.out.println("\n[Кнопка " + slot + " - ВКЛЮЧИТЬ]");
        onCommands[slot].execute();
        commandHistory.push(onCommands[slot]);
    }
    
    /**
     * Нажимает кнопку "Выключить"
     */
    public void pressOffButton(int slot) {
        if (slot < 0 || slot >= NUM_SLOTS) {
            System.out.println("⚠ Неверный номер кнопки!");
            return;
        }
        System.out.println("\n[Кнопка " + slot + " - ВЫКЛЮЧИТЬ]");
        offCommands[slot].execute();
        commandHistory.push(offCommands[slot]);
    }
    
    /**
     * Отменяет последнюю команду
     */
    public void pressUndoButton() {
        if (!commandHistory.isEmpty()) {
            System.out.println("\n[ОТМЕНА последней команды]");
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("\n⚠ Нет команд для отмены");
        }
    }
    
    /**
     * Показывает, какие команды назначены на кнопки
     */
    public void showButtons() {
        System.out.println("\n=== Пульт управления ===");
        for (int i = 0; i < NUM_SLOTS; i++) {
            System.out.println("Кнопка " + i + ": " + 
                             onCommands[i].getClass().getSimpleName() + " / " +
                             offCommands[i].getClass().getSimpleName());
        }
        System.out.println("========================");
    }
}

