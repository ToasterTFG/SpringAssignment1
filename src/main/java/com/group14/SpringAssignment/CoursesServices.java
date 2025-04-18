package com.group14.SpringAssignment;

import com.group14.SpringAssignment.foundation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@Validated
public class CoursesServices {

    // Initialize with three different arrays
    private final List<foundation> arrays = new ArrayList<>();

    public CoursesServices() {
        // Initialize with 3 arrays containing 2, 4, and 5 items respectively
        arrays.add(new foundation("Foundation", new String[]{"Introduction to Computer Science", "Data Structures"}));
        arrays.add(new foundation("Undergraduate", new String[]{"Algorithms", "Computer Networks", "Software Engineering", "Database Systems","Web Developer"}));
        arrays.add(new foundation("Honours", new String[]{"Data analyst", "Artificial intelligence", "Machine learning", "Data Science"}));
    }

    // CREATE - Add new array
    @PostMapping
    public foundation createArray(@Valid @RequestBody foundation newArray) {

        arrays.add(newArray);
        return newArray;
    }

    // READ ALL - Get all arrays
    @GetMapping
    public List<foundation> getAllArrays() {
        return arrays;
    }

    // READ ONE - Get array by name
    @GetMapping("/{name}")
    public ResponseEntity<foundation> getArrayByName(@Valid @PathVariable String name) {
        Optional<foundation> foundArray = arrays.stream()
                .filter(array -> array.getName().equalsIgnoreCase(name))
                .findFirst();
            return foundArray.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
// UPDATE - Modify an existing array
        @PutMapping("/{name}")
        public ResponseEntity<foundation> updateArray (
                @PathVariable String name,
                @Valid @RequestBody String[]newItems){

            for (foundation array : arrays) {
                if (array.getName().equalsIgnoreCase(name)) {
                    array.setItems(newItems);
                    return ResponseEntity.ok(array);
                }
            }
            return ResponseEntity.notFound().build();
        }

        // DELETE - Remove an array
        @DeleteMapping("/{name}")
        public ResponseEntity<Void> deleteArray (@Valid @PathVariable String name){
            if (!arrays.contains(name)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course type not found");
            }
            boolean removed = arrays.removeIf(array -> array.getName().equalsIgnoreCase(name));
            return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        }


    }
