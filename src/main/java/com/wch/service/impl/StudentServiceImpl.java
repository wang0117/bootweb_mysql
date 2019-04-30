package com.wch.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wch.model.Student;
import com.wch.repository.StudentRepository;
import com.wch.service.StudentService;

/**
 * Description:   
 * @author wangchenghong 
 * @since: 2019年4月29日: 下午4:45:26
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentRepository studentRepository;
     
    @Override
    public List<Student> findAllByownUser(String ownUser) {
        return studentRepository.findAllByownUser(ownUser);
    }

     
    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

     
    @Override
    @Transactional
    public void deleteById(Long id) {
        studentRepository.deleteByid(id);
    }

     
    @Override
    public Student findStudentByid(Long id) {
        return studentRepository.findStudentByid(id);
    }

    @Override
    public void editStudent(Student student) {
        studentRepository.save(student);
    }

}
