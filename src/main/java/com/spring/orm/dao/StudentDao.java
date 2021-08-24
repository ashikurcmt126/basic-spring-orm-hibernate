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
        try {
            Integer i = (Integer) this.hibernateTemplate.save(student);
            return i;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    // Get the single data(object)
    @Transactional
    public Student getStudent(int studentId){
        try{
            Student student = this.hibernateTemplate.get(Student.class, studentId);
            return student;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Student> getAllStudent(){
        try{
            List<Student> students = this.hibernateTemplate.loadAll(Student.class);
            return students;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       return null;
    }

    //deleting the data
    @Transactional
    public void deleteStudent(int studentId){
        try{
            Student student = this.hibernateTemplate.get(Student.class, studentId);
            this.hibernateTemplate.delete(student);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
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
