package com.fwbananas.afternoonproject9b;

public class Item {
    String name, number;
    int image;

    public Item(String name, String number, int image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getImage() {
        return image;
    }
}
