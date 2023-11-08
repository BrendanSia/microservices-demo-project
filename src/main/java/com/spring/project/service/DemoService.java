package com.spring.project.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.dto.RequestDTO;
import com.spring.project.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class DemoService {

    private final ObjectMapper objectMapper;

    public String sayHello(){
        return "Hello There! Welcome to my Project!";
    }

    public ResponseDTO retrieveDetailsGet(UUID id) throws IOException {

        //For demo & convenience, we will use the sample response data provided
        String response = getResponse("src/main/resources/SampleResponseData.json");
        ResponseDTO responseDTO = objectMapper.readValue(response, ResponseDTO.class);
        return responseDTO;
    }

    public ResponseDTO retrieveDetailsPost(RequestDTO requestDTO) throws IOException {

        //For demo & convenience, we will use the sample response data provided
        //In live situation, Jpa Repositories, JDBC scripts, etc. will be used to obtain data

        String response = getResponse("src/main/resources/SampleResponseData.json");
        ResponseDTO responseDTO = objectMapper.readValue(response, ResponseDTO.class);
        return responseDTO;
    }

    public String getResponse(String path) throws IOException {
        String file = new String(Files.readAllBytes(Path.of(path)));
        return file;
    }
}
