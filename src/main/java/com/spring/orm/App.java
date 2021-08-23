package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;

public class App {
    public static void main(String args[]){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student(102, "Ashikur Rahman", "Dhaka");
//        int result = studentDao.insert(student);
//        System.out.println("Done "+result);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        boolean go = true;
        while (go){
            System.out.println("Press 1 for add new student: ");
            System.out.println("Press 2 for display all students: ");
            System.out.println("Press 3 for get detail for single student: ");
            System.out.println("Press 4 for delete student: ");
            System.out.println("Press 5 for for update student: ");
            System.out.println("Press 6 for Exit.. ");

            try {
                int input = Integer.parseInt(bufferedReader.readLine());

                switch (input){
                    case 1:
                        //add a new student
                        System.out.println("Enter user id: ");
                        int uId = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("Enter user name: ");
                        String uName = bufferedReader.readLine();

                        System.out.println("Enter user city: ");
                        String uCity = bufferedReader.readLine();

                        Student student = new Student(uId, uName, uCity);
                        int result = studentDao.insert(student);
                        System.out.println("Done "+result);
                        break;
                    case 2:
                        //display all student
                        List<Student> students = studentDao.getAllStudent();
                        System.out.println(students);
                        break;
                    case 3:
                        //get single student
                        Student student1 = studentDao.getStudent(102);
                        System.out.println(student1);
                        break;
                    case 4:
                        //delete student
                        studentDao.deleteStudent(102);
                        break;
                    case 5:
                        //updated stduent
                        Student student2 = new Student(103, "Ashikur Rahman", "Dhaka");
                        int result1 = studentDao.insert(student2);
                        System.out.println("Updated "+result1);
                        break;
                    case 6:
                        //exit
                        go = false;
                        break;

                }


            }catch (Exception e){
                System.out.println("Invalid Input Try with another one !!");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thank you for using my application.. ");


    }
}
