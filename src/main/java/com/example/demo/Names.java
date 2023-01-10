package com.example.demo;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Names {
    private JSONArray names;
    private final String fileName = "src/main/java/com/example/demo/names.json";

    Names() {
        names = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(fileName));
            names.addAll((JSONArray) object);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public void setNames(JSONObject object) {
        names.add(object);
        try (FileWriter fr = new FileWriter(fileName)) {
            fr.write(names.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<org.json.simple.JSONObject> getNames() {
        return names;
    }
}
