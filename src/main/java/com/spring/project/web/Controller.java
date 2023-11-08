package com.spring.project.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.dto.RetrieveRequestDTO;
import com.spring.project.dto.ResponseDTO;
import com.spring.project.dto.SaveRequestDTO;
import com.spring.project.entity.Person;
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

    //Creating a new record in the database
    @PostMapping(value="/save")
    public Person sampleSave(
            @RequestBody SaveRequestDTO requestDTO
    ){
        try{
            return demoService.saveDetail(requestDTO);
        }catch(Exception e){
            throw new RuntimeException();
        }
    }

    //Retrieving a record based on its known UUID
    @GetMapping(value="/retrieve/{id}")
    public Person sampleRetrieveGet(
            @PathVariable UUID id
    ) {
       try{
           return demoService.retrieveDetailsGet(id);
       }catch(IOException e){
           throw new RuntimeException();
       }
    }

    //Retrieving a record based on name
    @PostMapping(value="/retrieve")
    public ResponseDTO sampleRetrievePost(
            @RequestBody RetrieveRequestDTO retrieveRequestDTO
    ){
        try{
            return demoService.retrieveDetailsPost(retrieveRequestDTO);
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
}
