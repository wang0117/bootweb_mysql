package com.wch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wch.model.Student;

/**
 * Description:
 * 
 * @author wangchenghong
 * @since: 2019年4月29日: 下午4:44:29
 */

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findAllByownUser(String ownUser);
    
    void deleteByid(Long id);
    
    Student findStudentByid(Long id);
}
