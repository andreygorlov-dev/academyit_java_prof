package org.example.students;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            System.out.println("Update record");
            session.beginTransaction();

            if (session.createQuery("UPDATE Student SET email = 'demo@bk.ru' WHERE id = 1").executeUpdate() > 0) {
                System.out.println("Данные обновлены");
            } else {
                System.out.println("Данные не обновлены");
            }
            session.getTransaction().commit();
        }
    }

}
