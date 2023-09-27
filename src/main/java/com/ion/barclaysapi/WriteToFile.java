package com.ion.barclaysapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class WriteToFile {
    ObjectMapper objectMapper;

    public WriteToFile() {
        this.objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public void write(File location, Object value) {
        try {
            objectMapper.writeValue(location, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
