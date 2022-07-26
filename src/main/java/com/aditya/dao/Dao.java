package com.aditya.dao;

import com.aditya.model.Student;

import java.util.List;

public interface Dao {

    public List<Student> getStudents();

    public int addStudent(Student student);

    public int updateStudent(Student student, int studentId);

    public int deleteStudent(int studentId);
}
