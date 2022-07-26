package com.aditya.controller;


import com.aditya.dao.Dao;
import com.aditya.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {

    @Autowired
    private Dao dao;

    @GetMapping(value = "/getStudent")
    public List<Student> getAllStudents(){ return this.dao.getStudents();}


    @PostMapping(value = "/addStudent")
    @ResponseBody
    public int addStudentDetails(@RequestBody Student student){ return this.dao.addStudent(student); }


    @PutMapping(value = "/updateStudent")
    public int updateStudentDetails(@RequestBody Student student, @PathVariable int id){
        return this.dao.updateStudent(student, id);
    }


    @DeleteMapping(value = "/deleteStudent")
    public int deleteStudentDetails(@PathVariable int id){
        return this.dao.deleteStudent(id);
    }


}
