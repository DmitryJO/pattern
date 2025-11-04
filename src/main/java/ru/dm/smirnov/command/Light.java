package ru.dm.smirnov.command;

/**
 * Класс Receiver (Получатель)
 * 
 * Знает, как выполнить операцию, связанную с запросом.
 * В данном случае - это свет, который можно включить/выключить.
 */
public class Light {
    private boolean isOn = false;
    private String location;
    
    public Light(String location) {
        this.location = location;
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println("✓ Свет в " + location + " включен");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println("✗ Свет в " + location + " выключен");
    }
    
    public boolean isOn() {
        return isOn;
    }
    
    public String getLocation() {
        return location;
    }
}

