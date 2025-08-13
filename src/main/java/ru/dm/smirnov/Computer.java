package ru.dm.smirnov;

import ru.dm.smirnov.interfaces.Usb;

public class Computer {

    public void connectUsb(Usb usb) {
        usb.connect();
    }

}
