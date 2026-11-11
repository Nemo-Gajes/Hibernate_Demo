package com.spring.hibernate_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Student;
import java.util.List;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class HibernateDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(HibernateDemoApplication.class, args);
  }

  // ======= 1st =========
  // @Bean
  // CommandLineRunner commandLineRunner(String[] args) {
  // return runner -> {
  // System.out.println("Hello World");
  // };
  // }

  @Bean
  CommandLineRunner commandLineRunner(StudentDao studentDao) {
    return runner -> {
      createStudent(studentDao);
      // readStudent(studentDao);
      // queryStudents(studentDao);
      // queryStudentLastName(studentDao);
      // updateStudent(studentDao);
      // deleteStudent(studentDao);
      // deleteAllStudent(studentDao);
    };
  }

  // Create
  private void createStudent(StudentDao studentDao) {
    System.out.println("Creating student info...");
    Student student = new Student("Light", "Yagami", "light.yagami@example.com");

    System.out.println("Saving student info...");
    studentDao.save(student);

    System.out.println("Saved! Generated ID: " + student.getId());
  }

  // Read
  private void readStudent(StudentDao studentDao) {
    System.out.println("Retrieving student id 2...");
    Student student = studentDao.findById(2);

    System.out.println("Found the student " + student);
  }

  // Query
  private void queryStudents(StudentDao studentDao) {
    List<Student> students = studentDao.findAll();

    for (Student s : students) {
      System.out.println(s);
    }
  }

  // Query - BONUS
  private void queryStudentLastName(StudentDao studentDao) {
    List<Student> students = studentDao.findByLastName("Abasula");

    for (Student s : students) {
      System.out.println(s);
    }
  }

  // Update
  private void updateStudent(StudentDao studentDao){
    int id = 1;
    System.out.println("Student ID: "+ id);
    Student student = studentDao.findById(id);

    System.out.println("Updating student name...");
    student.setFirstName("Dark");

    studentDao.update(student);

    System.out.println("Updated student information: " + student);
  }

  // Delete
  private void deleteStudent(StudentDao studentDao){
    int id = 1;
    System.out.println("Delete ID: " + id);

    studentDao.delete(id);
  }

  // Delete - ALL
  private void deleteAllStudent(StudentDao studentDao){
    System.out.println("Deleting all student information...");
    int rowsDeleted = studentDao.deleteAll();
    System.out.println("Number of deleted rows: " + rowsDeleted);
  }


}
