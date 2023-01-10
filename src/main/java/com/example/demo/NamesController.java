package com.example.demo;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NamesController {
    @GetMapping("/names")
    public List<?> namesGET(){
        return new Names().getNames();
    }
    @PostMapping(value = "/names", consumes = "application/json")
    public void namesPOST(@RequestBody JSONObject object){
        new Names().setNames(object);
    }
}
