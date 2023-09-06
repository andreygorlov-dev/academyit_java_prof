package org.example.cars;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCars {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Mark.class)
                .addAnnotatedClass(Model.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Create record");

            Mark[] marks = {
                    new Mark("Audi"),
                    new Mark("BMV")
            };

            for (Mark mark : marks) {
                session.save(mark);
            }

            Model[] models = {
                    new Model("A6", marks[0]),
                    new Model("X6", marks[1]),
                    new Model("Q8", marks[0]),
                    new Model("X4", marks[1]),
                    new Model("A4", marks[0])
            };

            for (Model model : models) {
                session.save(model);
            }


            session.getTransaction().commit();
        }
    }

}
