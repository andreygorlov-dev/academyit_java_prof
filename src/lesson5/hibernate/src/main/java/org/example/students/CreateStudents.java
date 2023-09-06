package org.example.students;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudents {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            System.out.println("Create record");

            Student student = new Student("Nikolay", "Ivanov", "test@mail.ru");
            Student student2 = new Student("Anna", "Petrova", "Petrova@mail.ru");
            Student student3 = new Student("Igor", "Romanov", "Romanov@mail.ru");

            Student[] students = {
                    student,
                    student2,
                    student3
            };

            session.beginTransaction();
            for (Student item : students) {
                session.save(item);
            }
            session.getTransaction().commit();
        }
    }

}
