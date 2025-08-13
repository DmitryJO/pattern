package ru.dm.smirnov.impl;

import ru.dm.smirnov.interfaces.Jack3_5;

public class Headphone implements Jack3_5 {

    public Headphone(String modelName) {
        this.modelName = modelName;
    }

    private final String modelName;

    @Override
    public void connect() {
        System.out.println(modelName + " was Connected");
    }

}
