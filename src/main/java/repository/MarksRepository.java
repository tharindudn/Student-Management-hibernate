package repository;

import model.Marks;
import model.Student;

import java.sql.SQLException;

/**
 * Created by tharindu on 7/20/17.
 */
public interface MarksRepository {
    int addstudentMarks(Marks marks) throws SQLException, ClassNotFoundException;
    Marks checkMarks(int id) throws SQLException, ClassNotFoundException;
    int updatestudentMarks(Marks marks) throws SQLException, ClassNotFoundException;
    int deletestudentMarks(Marks marks) throws SQLException, ClassNotFoundException;
}
