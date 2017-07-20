package repository;

import model.Marks;
import model.Student;

import java.sql.SQLException;

/**
 * Created by tharindu on 7/18/17.
 */
public interface StudentRepository{



    int addstudentDetails(Student student) throws SQLException, ClassNotFoundException;

    Student checkStudent(int id) throws SQLException, ClassNotFoundException;


}
