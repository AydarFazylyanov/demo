package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class Names {
    private List<Person> names;
    private final Logger logger = LoggerFactory.getLogger(Names.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private final String fileName = "src/main/java/com/example/demo/names.json";

    Names() {
        try {
            names = mapper.readValue(new FileReader(fileName), new TypeReference<>() {
            });
        } catch (IOException e) {
            names = new ArrayList<>();
            logger.info("Ошибка чтения файла!");
        }
    }

    public void setNames(Person person) {
        names.add(person);
        try (FileWriter fr = new FileWriter(fileName)) {
            fr.write(mapper.writeValueAsString(names));
            logger.info("Записал в файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getNames() {
        return names;
    }
}
