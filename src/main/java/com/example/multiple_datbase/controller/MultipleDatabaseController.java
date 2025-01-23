package com.example.multiple_datbase.controller;


import com.example.multiple_datbase.dto.Student;
import com.example.multiple_datbase.service.MultipleDatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MultipleDatabaseController {

    private final MultipleDatabaseService multipleDatabaseService;


    @PostMapping("/getDataPostGresql/{id}")
    public List<Student> getStudents(@PathVariable("id") int id,
                                     @RequestParam(value = "dataserver",defaultValue = "postgresql") String server
    ){
        return multipleDatabaseService.getStudents(id,server);
    }




}
