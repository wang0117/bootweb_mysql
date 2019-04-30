package com.wch.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wch.model.Student;
import com.wch.service.StudentService;

/**
 * Description:   
 * @author wangchenghong 
 * @since: 2019年4月29日: 下午4:38:42
 */
@Controller
public class StudentController {
    
    @Resource
    private StudentService studentService;
    
    @RequestMapping("/toAddStudent")
    private String toAddStudent(String ownUser, Model model){
        model.addAttribute("ownUser", ownUser);
        return "addStudent";
    }
    
    @RequestMapping("/addStudent")
    private String addStudent(Student student, String ownUser, Model model){
        student.setOwnUser(ownUser);
        studentService.saveStudent(student);
        List<Student> studentList = studentService.findAllByownUser(ownUser);
        model.addAttribute("studentList", studentList);
        model.addAttribute("ownUser", ownUser);
        return "studentList";
    }
    
    @RequestMapping("/toEditStudent")
    private String toEditStudent(Long id, Model model){
        Student student = studentService.findStudentByid(id);
        model.addAttribute("student", student);
        model.addAttribute("ownUser", student.getOwnUser());
        return "editStudent";
    }
    
    @RequestMapping("/edit")
    private String editStudent(Long id, Model model, Student student, String ownUser){
        student.setOwnUser(ownUser);
        studentService.editStudent(student);
        List<Student> studentList = studentService.findAllByownUser(ownUser);
        model.addAttribute("studentList", studentList);
        model.addAttribute("ownUser", ownUser);
        return "studentList";
    }
    
    @RequestMapping("/delete")

    private String delete(Long id, Model model, String ownUser){
        studentService.deleteById(id);
        List<Student> studentList = studentService.findAllByownUser(ownUser);
        model.addAttribute("studentList", studentList);
        model.addAttribute("ownUser", ownUser);
        return "studentList";
    }
    
    @RequestMapping("/list")
    private String delete(String ownUser, Model model){
        List<Student> studentList = studentService.findAllByownUser(ownUser);
        model.addAttribute("studentList", studentList);
        model.addAttribute("ownUser", ownUser);
        return "studentList";
    }
    
}
