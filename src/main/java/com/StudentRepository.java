package com;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void initData() {

        Student student = new Student();
        student.setId(0);
        student.setName("Katy");
        student.setAge(22);
        student.setAddress("Voronezh");
        students.add(student);

        student = new Student();
        student.setId(2);
        student.setName("Oly");
        student.setAge(45);
        student.setAddress("Voronezh");
        students.add(student);

        student = new Student();
        student.setId(3);
        student.setName("Anna");
        student.setAge(21);
        student.setAddress("Dubai");
        students.add(student);
    }

    public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        for(Student student: students){
            if (student.getName().equals(name))
                return student;
        }
        return null;
    }

    public Student findStudentById(int id) {
        Assert.notNull(id, "The Student's id must not be null");
        for(Student student: students){
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    public List<Student> findStudentByAge(int age) {
        Assert.notNull(age, "The Student's age must not be null");
        List<Student> result = new ArrayList<>();
        for(Student student: students){
            if (student.getAge() == age)
                result.add(student);
        }
        return result;
    }
}