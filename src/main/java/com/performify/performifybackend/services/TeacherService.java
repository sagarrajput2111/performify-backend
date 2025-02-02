package com.performify.performifybackend.services;

import com.performify.performifybackend.models.Address;
import com.performify.performifybackend.models.PendingRegistration;
import com.performify.performifybackend.models.Teacher;
import com.performify.performifybackend.models.User;
import com.performify.performifybackend.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private  TeacherRepo teacherRepo;
    @Autowired
    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public void registerTeacher(PendingRegistration pendingRegistration, Address address, User user) {
        Teacher teacher=new Teacher(user,pendingRegistration.getFirstName(), pendingRegistration.getLastName(), pendingRegistration.getDepartment(), pendingRegistration.getSubject(),address);
        teacherRepo.save(teacher);
        System.out.println("Teacher Created");
    }
}
