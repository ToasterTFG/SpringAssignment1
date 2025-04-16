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
}