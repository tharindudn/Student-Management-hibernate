package controller;

import model.Marks;
import model.Student;
import org.apache.log4j.Logger;
import repository.ExamRepository;
import repository.StudentRepository;
import repository.impl.ExamImpl;
import repository.impl.StudentImpl;
import studentmanagmenthibernate.Main;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by tharindu on 7/18/17.
 */
public class StudentControl {
    Logger logger = Logger.getLogger(Main.class);
    private StudentRepository studentRepository = new StudentImpl();
    private ExamRepository examRepository = new ExamImpl();
    Scanner in = new Scanner(System.in);

    String status = "";
    int id;
    Student student = null;

    int result = 0;

    public void addStudent() {
        Student newstudent = new Student();
        System.out.println("Enter student id : ");

        newstudent.setId(in.nextInt());
        System.out.println("Enter student name : ");

        newstudent.setName(in.next());
        result = 0;
        try {
            result = studentRepository.addstudentDetails(newstudent);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (result ==newstudent.getId()) {
            System.out.println("data added...");
            logger.info("data added...");
        }

    }
    public void checkStudent() throws SQLException, ClassNotFoundException {
        studentRepository.checkStudent(100);
    }
}
