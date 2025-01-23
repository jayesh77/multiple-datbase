package com.example.multiple_datbase.repository;


import com.example.multiple_datbase.dto.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MultipleDatabaseRespository {

//    private final JdbcTemplate jdbcTemplate;

    private final JdbcTemplate primaryJdbcTemplate;
    private final JdbcTemplate secondaryJdbcTemplate;

    @Autowired
    MultipleDatabaseRespository(JdbcTemplate primaryJdbcTemplate ,JdbcTemplate secondaryJdbcTemplate){
        this.primaryJdbcTemplate=primaryJdbcTemplate;
        this.secondaryJdbcTemplate= secondaryJdbcTemplate;
    }


    public List<Student> getStudentDetails(int id) {
        return primaryJdbcTemplate.query("SELECT * FROM STUDENTS WHERE ID = ?",(rs, rowNum) ->
                Student.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .age(rs.getString("age"))
                .build(), id );
    }

    public List<Student> getStudentDetailsUsingMysql(int id) {
        System.out.println("Mysql server");
        return secondaryJdbcTemplate.query("SELECT * FROM SQL_STUDENTS WHERE ID = ?",(rs, rowNum) ->
                Student.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .age(rs.getString("age"))
                        .build(), id );

    }
}
