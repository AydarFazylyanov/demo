package com.example.demo;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NamesController {
    private final Names names = new Names();
    @GetMapping("/names")
    public List<?> namesGET(){
        return names.getNames();
    }
    @PostMapping(value = "/names", consumes = "application/json")
    public void namesPOST(@RequestBody JSONObject object){
        names.setNames(object);
    }
}
