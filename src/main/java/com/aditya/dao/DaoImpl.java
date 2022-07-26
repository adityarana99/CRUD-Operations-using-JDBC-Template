package com.aditya.dao;

import com.aditya.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoImpl implements Dao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getStudents(){
        return jdbcTemplate.query("SELECT * FROM Student", new BeanPropertyRowMapper<Student>(Student.class));
    }

    @Override
    public int addStudent(Student student){
        return jdbcTemplate.update("INSERT INTO Student(firstName, lastName, gender, department) VALUES(?, ?, ?, ?)", new Object[]{student.getFirstName(), student.getLastName(), student.getGender(), student.getDepartment()});
    }

    @Override
    public int updateStudent(Student student, int studentId){
        return jdbcTemplate.update("UPDATE Student SET firstName=?, lastName=?, gender=?, department=? WHERE studentId=?", new Object[]{student.getFirstName(), student.getLastName(), student.getGender(), student.getDepartment(), studentId});
    }

    @Override
    public int deleteStudent(int studentId){
        return jdbcTemplate.update("DELETE * FROM Student WHERE studentId=?", studentId);
    }


}
