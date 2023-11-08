package com.spring.project.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.project.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {
    private String id;
    private String name;
    private String age;
    private String position;

    public ResponseDTO convertToDTO(Person person){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setId(String.valueOf(person.getId()));
        responseDTO.setName(person.getName());
        responseDTO.setAge(person.getAge());
        responseDTO.setPosition(person.getPosition());
        return responseDTO;
    }
}