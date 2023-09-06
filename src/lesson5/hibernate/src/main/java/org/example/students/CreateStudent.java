package org.example.students;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            System.out.println("Create record");

            Student student = new Student("Ivan", "Ivanov", "test@mail.ru");

            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }
    }

}
