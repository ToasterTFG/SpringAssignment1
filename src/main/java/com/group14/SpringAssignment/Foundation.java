package com.group14.SpringAssignment;


public class Foundation {
    private String name;
    private String[] items;

    // Constructors
    public Foundation() {}

    public Foundation(String name, String[] items) {
        this.name = name;
        this.items = items;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }
}
