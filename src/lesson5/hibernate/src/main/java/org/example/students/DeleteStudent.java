package org.example.students;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            System.out.println("Delete record");
            session.beginTransaction();

            if (session.createQuery("DELETE FROM Student WHERE id = 1").executeUpdate() > 0) {
                System.out.println("Данные удалены");
            } else {
                System.out.println("Данные не удалены");
            }
            session.getTransaction().commit();
        }
    }

}
