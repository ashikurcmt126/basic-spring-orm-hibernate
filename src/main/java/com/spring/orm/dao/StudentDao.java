package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    //save student
    @Transactional          //write operation enable
    public int insert(Student student){
        // Insert
        Integer i = (Integer) this.hibernateTemplate.save(student);
        return i;
    }

    // Get the single data(object)
    @Transactional
    public Student getStudent(int studentId){
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        return student;
    }

    public List<Student> getAllStudent(){
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    //deleting the data
    @Transactional
    public void deleteStudent(int studentId){
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        this.hibernateTemplate.delete(student);
    }

    //updating data
    @Transactional
    public void updateStudent(Student student){
        this.hibernateTemplate.update(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
