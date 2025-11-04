package ru.dm.smirnov.command;

/**
 * Класс Receiver (Получатель)
 * 
 * Телевизор, который можно включить/выключить и менять громкость.
 */
public class TV {
    private boolean isOn = false;
    private int volume = 10;
    
    public void turnOn() {
        isOn = true;
        System.out.println("✓ Телевизор включен (громкость: " + volume + ")");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println("✗ Телевизор выключен");
    }
    
    public void volumeUp() {
        if (isOn) {
            volume++;
            System.out.println("📢 Громкость увеличена до " + volume);
        } else {
            System.out.println("⚠ Телевизор выключен, нельзя изменить громкость");
        }
    }
    
    public void volumeDown() {
        if (isOn) {
            volume--;
            System.out.println("🔇 Громкость уменьшена до " + volume);
        } else {
            System.out.println("⚠ Телевизор выключен, нельзя изменить громкость");
        }
    }
    
    public boolean isOn() {
        return isOn;
    }
    
    public int getVolume() {
        return volume;
    }
}

