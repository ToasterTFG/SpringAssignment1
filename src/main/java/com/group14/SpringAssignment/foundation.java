package com.group14.SpringAssignment;




import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.*;


public class foundation {
    @NotBlank(message = "Course name is required")
    @Pattern(regexp = "foundation|undergraduate|honors", message = "Course type must be foundation, undergraduate, or honors")
    private String name;
    @NotBlank(message = "Module name is required")
    @Size(min = 3, max = 100, message = "Module name must be between 3 and 100 characters")
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
