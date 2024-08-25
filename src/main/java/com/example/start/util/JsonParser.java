package com.example.start.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonParser {

    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final String JSON_DIR = "../data/input/inventories.json";

    public String readJson() {
        Path inventoriesPath = Paths.get("../data/input/inventories.json");
        Path inventoriesPath1 = Paths.get("./data/input/inventories.json");
        try {
            return new String(Files.readAllBytes(inventoriesPath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Error reading inventories file");
            return new String();
        }
    }
}
