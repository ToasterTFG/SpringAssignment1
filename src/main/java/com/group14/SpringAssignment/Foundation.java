package com.group14.springassigment;



import org.springframework.web.bind.annotation.*;


public class foundation {
    private String name;
    private String[] items;
package com.group14.springassigment;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


public class foundation {
    private String name;
    private String[] items;

    // Constructors
    public foundation() {}

    public foundation(String name, String[] items) {
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
