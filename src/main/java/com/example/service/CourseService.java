package com.example.service;

import com.example.model.Course;
import com.example.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseHandle;
    public List<Course> getCourseList() {
        ArrayList<Course> data = new ArrayList<Course>();
        courseHandle.findAll().forEach(e -> data.add(e));
        return data;
    }

    public long addNewCourse(Course course){
        Course c = courseHandle.save(course);
        return c.getcourseID();
    }

    public Course getCoursebyId(long courseId) throws NullPointerException, NoSuchElementException {
        Optional<Course> record = null;
        if (courseHandle.existsById(courseId))
            record = courseHandle.findById(courseId);
        return (record != null) ? record.get() : null;
    }
}
