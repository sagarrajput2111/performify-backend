package com.performify.performifybackend.services;

import com.performify.performifybackend.models.Address;
import com.performify.performifybackend.models.PendingRegistration;
import com.performify.performifybackend.models.Student;
import com.performify.performifybackend.models.User;
import com.performify.performifybackend.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void registerStudent(PendingRegistration pendingRegistration, Address address, User user) {
        //roll number and section decided in future or put in pending registration form
        //for roll number
//        select rollno from student order by rollno desc limit 1;

        Student student=new Student(user,pendingRegistration.getFirstName(),pendingRegistration.getLastName(),pendingRegistration.getRollNo(),pendingRegistration.getStandard(),pendingRegistration.getSection(),pendingRegistration.getStream(),address);

        System.out.println(student);
        studentRepo.save(student);
        System.out.println("Student Created");
    }
}
