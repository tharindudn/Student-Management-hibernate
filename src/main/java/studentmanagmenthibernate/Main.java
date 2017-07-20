package studentmanagmenthibernate;

import controller.MarksControl;
import controller.StudentControl;
import repository.ExamRepository;
import repository.StudentRepository;
import model.Student;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Scanner;

import repository.impl.ExamImpl;
import repository.impl.StudentImpl;

/**
 * Created by tharindu on 7/17/17.
 */
public class Main {

    private StudentRepository studentRepository = new StudentImpl();
    private ExamRepository examRepository = new ExamImpl();

    public void inputMethod() {


        Logger logger = Logger.getLogger(Main.class);


        Scanner in = new Scanner(System.in);

        String status = "";
        int id;
        Student student = null;
        int result = 0;
        StudentControl studentControl = new StudentControl();
        MarksControl marksControl=new MarksControl();
        while (!(status.equalsIgnoreCase("exit"))) {

            System.out.println("Press 1 to enter student details..");

            System.out.println("Press 2 to enter marks of a student...");

            System.out.println("Press 3 to check marks of a student...");

            System.out.println("Press 4 to update marks");

            System.out.println("Press 5 to delete student marks");

            System.out.println("Press 8 to exit..");

            try {
                int sw = in.nextInt();

                switch (sw) {
                    case 1:
                        studentControl.addStudent();
                        break;
                    case 2:
                        marksControl.addMark();
                        break;
                    case 3:
                       marksControl.printMarks();
                        break;
                    case 4:
                        marksControl.updatestudentMarks();
                        break;
                    case 5:
                        marksControl.deletestudentmarks();
                        break;
                    case 8:
                        System.exit(0);


                }


            } catch (Exception e) {
                System.out.println("wrong input... check again...");
                logger.error("Press 8 Run Watch directory...");

            }
            System.out.println("Press any key to continue...");
            logger.info("Press any key to continue...");
            status = in.next();
        }
    }


    public static void main(String[] args) {
        String log4jConfigFile = "/home/tharindu/IdeaProjects/Student-Management-db/src/main/resources/log4j.properties";
        //System.getProperty("user.dir")
        //+ File.separator + "log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);
        Main newmain = new Main();
        newmain.inputMethod();

    }
}
