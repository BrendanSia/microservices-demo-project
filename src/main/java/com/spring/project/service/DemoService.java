package com.spring.project.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.dto.RetrieveRequestDTO;
import com.spring.project.dto.ResponseDTO;
import com.spring.project.dto.SaveRequestDTO;
import com.spring.project.entity.Person;
import com.spring.project.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class DemoService {

    private final ObjectMapper objectMapper;
    private final PersonRepository personRepository;

    public String sayHello(){
        return "Hello There! Welcome to my Project!";
    }
    public Person saveDetail(SaveRequestDTO requestDTO){
        Person person = new Person();
        person.setId(UUID.randomUUID());
        person.setName(requestDTO.getName());
        person.setAge(requestDTO.getAge());
        person.setPosition(requestDTO.getPosition());
        return personRepository.save(person);
    }

    public Person retrieveDetailsGet(UUID id) throws IOException {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            return person.get();
        }
        return new Person();
    }

    public ResponseDTO retrieveDetailsPost(RetrieveRequestDTO retrieveRequestDTO) throws IOException {

//  In a live situation JDBC SELECT scripts will be used to obtain data.
//  For the current demo, the sample response data provided is used instead:
        String response = getResponse("src/main/resources/SampleResponseData.json");
        ResponseDTO responseDTO = objectMapper.readValue(response, ResponseDTO.class);
        return responseDTO;
    }

    public String updateDetails(UUID id, SaveRequestDTO request){
        if(personRepository.existsById(id)){

            //Retrieve the existing record from database
            Optional<Person> person = personRepository.findById(id);
            Person updatePerson = person.get();

            //Replace old data with new data
            updatePerson.setName(request.getName());
            updatePerson.setAge(request.getAge());
            updatePerson.setPosition(request.getPosition());

            //Save into database
            personRepository.saveAndFlush(updatePerson);
            return "Record updated succesfully";
        } else {
            return "This record does not exist";
        }
    }

    public String deleteDetails(UUID id){
        try{
            personRepository.deleteById(id);
            return "Record deleted successfully";
        } catch(Exception e){
           return "Error deletion: " + e.getMessage();
        }
    }

    public String getResponse(String path) throws IOException {
        String file = new String(Files.readAllBytes(Path.of(path)));
        return file;
    }
}
