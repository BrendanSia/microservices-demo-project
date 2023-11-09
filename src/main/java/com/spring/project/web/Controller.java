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

    @GetMapping(value="/print")
    public String samplePrint(){
        try{
            return demoService.sayHello();
        }catch(Exception e){
            return "Something went wrong:" + e.getMessage();
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

    //Updating a record based on its known UUID
    @PostMapping(value="/update/{id}")
    public String sampleUpdate(
            @PathVariable UUID id,
            @RequestBody SaveRequestDTO requestDTO
    ) {
        try{
            return demoService.updateDetails(id, requestDTO);
        } catch (Exception e){
            return "Something went wrong:" + e.getMessage();
        }

    }

    //Deleting a record based on its known UUID
    @PostMapping(value="/delete/{id}")
    public String sampleDelete(
            @PathVariable UUID id
    ) {
        return demoService.deleteDetails(id);
    }
}
