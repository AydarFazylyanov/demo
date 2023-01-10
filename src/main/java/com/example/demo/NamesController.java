package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NamesController {
    private final Names names = new Names();
    @GetMapping("/names")
    public List<Person> namesGET(){
        return names.getNames();
    }
    @PostMapping(value = "/names", consumes = "application/json")
    public void namesPOST(@RequestBody Person object){
        names.setNames(object);
    }
}
