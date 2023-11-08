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
        person.setId(UUID.fromString(requestDTO.getId()));
        person.setName(requestDTO.getName());
        person.setAge(requestDTO.getAge());
        person.setPosition(requestDTO.getPosition());
        return personRepository.save(person);
    }

    public ResponseDTO retrieveDetailsGet(UUID id) throws IOException {

//  Example of Jpa Repository retrieving based on the provided UUID:
//        Optional<Person> person = personRepository.findById(id);
//        ResponseDTO result = new ResponseDTO();
//        if(person.isPresent()){
//            Person data = person.get();
//            result.convertToDTO(data);
//        }

//  For the current demo, the sample response data provided is used instead:
        String response = getResponse("src/main/resources/SampleResponseData.json");
        ResponseDTO result = objectMapper.readValue(response, ResponseDTO.class);
        return result;
    }

    public ResponseDTO retrieveDetailsPost(RetrieveRequestDTO retrieveRequestDTO) throws IOException {

//  In a live situation JDBC SELECT scripts will be used to obtain data.
//  For the current demo, the sample response data provided is used instead:
        String response = getResponse("src/main/resources/SampleResponseData.json");
        ResponseDTO responseDTO = objectMapper.readValue(response, ResponseDTO.class);
        return responseDTO;
    }

    public String getResponse(String path) throws IOException {
        String file = new String(Files.readAllBytes(Path.of(path)));
        return file;
    }
}
