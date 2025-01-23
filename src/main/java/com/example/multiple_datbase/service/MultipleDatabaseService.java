package com.example.multiple_datbase.service;

import com.example.multiple_datbase.dto.Student;
import com.example.multiple_datbase.repository.MultipleDatabaseRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MultipleDatabaseService {

    private final MultipleDatabaseRespository multipleDatabaseRespository;



    public List<Student> getStudents(int id, String server) {
        if(server.equals("postgresql")){
        return multipleDatabaseRespository.getStudentDetails(id);}
        else return multipleDatabaseRespository.getStudentDetailsUsingMysql(id);

    }
}
