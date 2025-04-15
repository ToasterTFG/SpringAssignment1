package com.group14.SpringAssignment;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CoursesServices {

    // Initialize with three different arrays
    private final List<Foundation> arrays = new ArrayList<>();

    public CoursesServices() {
        // Initialize with 3 arrays containing 2, 4, and 5 items respectively
        arrays.add(new Foundation("Foundation", new String[]{"Algorithms and Programming", "Computing Systems" ,"Data and Analysis","Impacts of Computing","Networks and Internet"}));
        arrays.add(new Foundation("Undergraduate", new String[]{"Software engineering", "Data Science", "Computer programming", "Database Developer"}));
        arrays.add(new Foundation("Honours", new String[]{"Data analyst", "Artificial intelligence", "Machine learning", "Web Developer", "Data Science"}));
    }

    // CREATE - Add new array
    @PostMapping
    public Foundation createArray(@RequestBody Foundation newArray) {
        arrays.add(newArray);
        return newArray;
    }

    // READ ALL - Get all arrays
    @GetMapping
    public List<Foundation> getAllArrays() {
        return arrays;
    }

    // READ ONE - Get array by name
    @GetMapping("/{name}")
    public ResponseEntity<Foundation> getArrayByName(@PathVariable String name) {
        Optional<Foundation> foundArray = arrays.stream()
                .filter(array -> array.getName().equalsIgnoreCase(name))
                .findFirst();

        return foundArray.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE - Modify an existing array
    @PutMapping("/{name}")
    public ResponseEntity<Foundation> updateArray(
            @PathVariable String name,
            @RequestBody String[] newItems) {

        for (Foundation array : arrays) {
            if (array.getName().equalsIgnoreCase(name)) {
                array.setItems(newItems);
                return ResponseEntity.ok(array);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE - Remove an array
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteArray(@PathVariable String name) {
        boolean removed = arrays.removeIf(array -> array.getName().equalsIgnoreCase(name));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // SPECIAL OPERATION: Add item to existing array
    @PatchMapping("/{name}/add")
    public ResponseEntity<Foundation> addItemToArray(
            @PathVariable String name,
            @RequestParam String item) {

        for (Foundation array : arrays) {
            if (array.getName().equalsIgnoreCase(name)) {
                String[] currentItems = array.getItems();
                String[] newItems = new String[currentItems.length + 1];
                System.arraycopy(currentItems, 0, newItems, 0, currentItems.length);
                newItems[newItems.length - 1] = item;
                array.setItems(newItems);
                return ResponseEntity.ok(array);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
