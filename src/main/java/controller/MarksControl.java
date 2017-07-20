package controller;

import model.Marks;
import model.Marks;
import model.Student;
import org.apache.log4j.Logger;
import repository.ExamRepository;
import repository.MarksRepository;
import repository.StudentRepository;
import repository.impl.ExamImpl;
import repository.impl.MarksImpl;
import repository.impl.StudentImpl;
import studentmanagmenthibernate.Main;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by tharindu on 7/20/17.
 */
public class MarksControl {
    Logger logger = Logger.getLogger(Main.class);
    private MarksRepository marksRepository = new MarksImpl();
    private ExamRepository examRepository = new ExamImpl();
    private StudentRepository studentRepository = new StudentImpl();
    Scanner in = new Scanner(System.in);

    String status = "";
    int id;
    Student student = null;
    Marks marks=null;
    int result = 0;
    public void addMark() {
        System.out.println("Enter student id : ");
        logger.info("Enter student id : ");
        id = in.nextInt();
        try {
            student = studentRepository.checkStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (student != null) {


            System.out.println("Student exist...");
            logger.info("Student exist...");
            System.out.println("Enter marks for subject 1...");
            logger.info("Enter marks for subject 1...");
            int marks1 = in.nextInt();
            System.out.println("Enter marks for subject 2...");
            logger.info("Enter marks for subject 2...");
            int marks2 = in.nextInt();
            Marks marks=new Marks();
            marks.setId(id);
            marks.setMarks1(marks1);
            marks.setMarks1(marks2);
            result = 0;
            try {
                result = marksRepository.addstudentMarks(marks);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (result == marks.getId()) {
                System.out.println("marks added...");
                logger.info("marks added...");
            }

        } else {
            System.out.println("No student marks found with " + id);
            logger.info("No student marks found with " + id);
        }
    }
    public void printMarks() {
        System.out.println("Enter student id to check marks: ");
        logger.info("Enter student id to check marks: ");
        id = in.nextInt();
        //Marks marks=null;
        try {
            marks = marksRepository.checkMarks(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (marks != null) {
            System.out.println("Student exist...");
            logger.info("Student exist...");

            System.out.println("NAME     | MARKS | GRADE  |");
            System.out.println("Subject1 | " + marks.getMarks1() + "    |  " + examRepository.grade(marks.getMarks1()) + "     |");
            System.out.println("Subject2 | " + marks.getMarks2() + "    |  " + examRepository.grade(marks.getMarks2()) + "     |");

        } else {
            System.out.println("No student with " + id);
            logger.info("No student with " + id);
        }
    }
    public void updatestudentMarks() {
        System.out.println("Enter student id to update marks: ");

        id = in.nextInt();

        System.out.println("Enter marks for sub 1: ");
        marks.setMarks1( in.nextInt());
        System.out.println("Enter marks for sub 2: ");
        marks.setMarks2(in.nextInt());

        marks.setId(id);
        try {
            result = marksRepository.updatestudentMarks(marks);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("updated...");
            logger.info("marks updated...");
        } else {
            System.out.println("Update fail..." + id);
            logger.info("Update fail..." + id);
        }
    }
    public void deletestudentmarks() {
        System.out.println("Enter student id to Delete marks");
        id = in.nextInt();
        marks.setId(id);
        try {
            result = marksRepository.deletestudentMarks(marks);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (result == 1) {
            System.out.println("deleted...");
            logger.info("marks deleted...");
        } else {
            System.out.println("Delete fail..." + id);
            logger.info("Delete fail..." + id);
        }
    }

}
