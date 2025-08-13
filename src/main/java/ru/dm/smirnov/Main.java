package ru.dm.smirnov;

import ru.dm.smirnov.impl.Headphone;
import ru.dm.smirnov.impl.UsbJackAdapter;

public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer();
        Headphone headphone = new Headphone("airPods");

        UsbJackAdapter usbJackAdapter = new UsbJackAdapter(headphone);
        computer.connectUsb(usbJackAdapter);
    }

}