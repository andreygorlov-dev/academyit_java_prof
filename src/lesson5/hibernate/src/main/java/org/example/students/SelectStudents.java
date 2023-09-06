package org.example.students;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SelectStudents {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Student> students = session.createQuery("FROM Student").getResultList();
            String hql = "SELECT COUNT(id) FROM Student";
            Query query = session.createQuery(hql);
            System.out.println(query.getResultList().get(0));
            for(Student student : students) {
                System.out.println(student);
            }
            session.getTransaction().commit();

        }
    }
}
