package com.example.controller;

import com.example.model.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CourseController {
    @Autowired
    private CourseService service;

    @RequestMapping("/courseData")
    public List<Course> getCourseList(){
        return service.getCourseList();
    }

    @PostMapping("/addCourse")
    public long addNewCourse(@RequestParam String name, @RequestParam String professor){
        return service.addNewCourse(new Course(name,professor));
    }

    @PostMapping("/searchCourse")
    public Course searchCourse(@RequestParam long id){
        try {
            return service.getCoursebyId(id);
        }
        catch(NoSuchElementException ex){
            System.out.println(ex.getMessage() + " Check");
            return null;
        }
        catch(NullPointerException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
