package com.spring.project.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.dto.RequestDTO;
import com.spring.project.dto.ResponseDTO;
import com.spring.project.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor
public class Controller {

    private final DemoService demoService;
    private final ObjectMapper objectMapper;

    @GetMapping(value="/print")
    public String samplePrint(){
        try{
            return demoService.sayHello();
        }catch(Exception e){
            return "Something went wrong:" + e;
        }
    }

    //For when users expect specific record/information to be returned
    //e.g. When the UUID of a particular record of a database is known
    @GetMapping(value="/retrieve/{id}")
    public ResponseDTO sampleRetrieveGet(
            @PathVariable UUID id
    ) {
       try{
           return demoService.retrieveDetailsGet(id);
       }catch(IOException e){
           throw new RuntimeException();
       }
    }

    //For when users are expected to provide params for the request body
    //e.g. Names, age, position and etc.
    @PostMapping(value="/retrieve")
    public ResponseDTO sampleRetrievePost(
            @RequestBody RequestDTO requestDTO
    ) throws IOException {

        //For this demo, the sample request data provided will be used
        String request = getRequest("src/main/resources/SampleRequestData.json");
        requestDTO = objectMapper.readValue(request, RequestDTO.class);

        return demoService.retrieveDetailsPost(requestDTO);
    }

    public String getRequest(String path) throws IOException {
        String file = new String(Files.readAllBytes(Path.of("src/main/resources/SampleRequestData.json")));
        return file;
    }
}
