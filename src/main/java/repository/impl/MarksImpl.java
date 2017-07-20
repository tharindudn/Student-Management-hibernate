package repository.impl;

import model.Marks;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.MarksRepository;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tharindu on 7/20/17.
 */
public class MarksImpl implements MarksRepository {
    private static SessionFactory factory;

    public int addstudentMarks(Marks marks) throws SQLException, ClassNotFoundException {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        int res = 0;
        try {
            tx = session.beginTransaction();

            res = (Integer) session.save(marks);
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
    public Marks checkMarks(int id) throws SQLException, ClassNotFoundException {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            List markslist = session.createQuery("FROM Marks").list();
            for (Iterator iterator = markslist.iterator(); iterator.hasNext(); ) {
                Marks marks = (Marks) iterator.next();
                if (id == marks.getId()) {
                    return marks;
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

    @Override
    public int updatestudentMarks(Marks marks) throws SQLException, ClassNotFoundException {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        int res = 1;
        try {
            tx = session.beginTransaction();

            session.update(marks);
            tx.commit();
        } catch (HibernateException e) {
            res=0;
            if (tx != null) tx.rollback();
            System.out.println(e);

        } finally {
            session.close();
        }
        return res;
    }

    @Override
    public int deletestudentMarks(Marks marks) throws SQLException, ClassNotFoundException {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        int res = 1;
        try {
            tx = session.beginTransaction();

            session.delete(marks);
            tx.commit();
        } catch (HibernateException e) {
            res=0;
            if (tx != null) tx.rollback();
            System.out.println(e);

        } finally {
            session.close();
        }
        return res;
    }
}
