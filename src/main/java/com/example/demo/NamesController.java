package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NamesController {
    @GetMapping("/names")
    public List<Person> names(Names names){
        return names.getNames();
    }
    @PostMapping(value = "/names", consumes = "application/json")
    public void names(@RequestBody Person object, Names names){
        names.setNames(object);
    }
}
