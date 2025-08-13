package ru.dm.smirnov.impl;

import ru.dm.smirnov.interfaces.Jack3_5;
import ru.dm.smirnov.interfaces.Usb;

public class UsbJackAdapter implements Usb {

	private final Jack3_5 jackDevice;

	public UsbJackAdapter(Jack3_5 jackDevice) {
		this.jackDevice = jackDevice;
	}

	@Override
	public void connect() {
		System.out.println("Using USB->Jack 3.5 adapter");
		jackDevice.connect();
	}

}
