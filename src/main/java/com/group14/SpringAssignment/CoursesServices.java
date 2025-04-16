package com.group14.springassigment;

import com.group14.springassigment.foundation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class courseServices {

    // Initialize with three different arrays
    private final List<foundation> arrays = new ArrayList<>();

    public courseServices() {
        // Initialize with 3 arrays containing 2, 4, and 5 items respectively
        arrays.add(new foundation("Foundation", new String[]{"Algorithms and Programming", "Computing Systems" ,"Data and Analysis","Impacts of Computing","Networks and Internet"}));
        arrays.add(new foundation("Undergraduate", new String[]{"Software engineering", "Data Science", "Computer programming", "Database Developer"}));
        arrays.add(new foundation("Honours", new String[]{"Data analyst", "Artificial intelligence", "Machine learning", "Web Developer", "Data Science"}));
    }
