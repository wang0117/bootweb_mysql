package com.wch.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wch.model.Student;

/**
 * Description:
 * 
 * @author wangchenghong
 * @since: 2019年4月29日: 下午4:45:14
 */
@Repository
public interface StudentService {
    
    List<Student> findAllByownUser(String ownUser);
    
    void saveStudent(Student student);
    
    void deleteById(Long id);
    
    Student findStudentByid(Long id);
    
    void editStudent(Student student);
}
