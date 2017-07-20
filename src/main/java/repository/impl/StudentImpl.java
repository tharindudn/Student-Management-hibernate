package repository.impl;


import model.Marks;
import model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.StudentRepository;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


/**
 * Created by tharindu on 7/18/17.
 */
public class StudentImpl implements StudentRepository {
    private static SessionFactory factory;


    @Override
    public int addstudentDetails(Student student) throws SQLException, ClassNotFoundException {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        int res = 0;
        try {
            tx = session.beginTransaction();

            res = (Integer) session.save(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.out.println(e);

        } finally {
            session.close();
        }
        return res;
    }

    @Override
    public Student checkStudent(int id) throws SQLException, ClassNotFoundException {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            List students = session.createQuery("FROM Student").list();
            for (Iterator iterator = students.iterator(); iterator.hasNext(); ) {
                Student student = (Student) iterator.next();

                if (id == student.getId()) {
                    return student;
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.out.print(e);
        } finally {
            session.close();
        }
        return null;
    }
}
