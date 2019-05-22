package edu.mum.waa.service;

import edu.mum.waa.entity.Student;
import edu.mum.waa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }


}

