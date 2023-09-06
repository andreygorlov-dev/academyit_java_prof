package org.example.cars;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        try (SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
            Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            System.out.println("Авторизация (0) или регистрация(1)");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String type = reader.readLine();
                System.out.println("Введите логин пароль через '-'");
                String[] mas = reader.readLine().split("-");
                if (type.equalsIgnoreCase("0")) {


                    String hql = "FROM User WHERE login = '" + mas[0] + "' AND password = '" + Base64.getEncoder().encodeToString(mas[1].getBytes()) + "'";
                    List<?> listUsers = session.createQuery(hql).getResultList();
                    if (listUsers.isEmpty()) {
                        System.out.println("Ошибка авторизации");
                    } else {
                        System.out.println("Welcome");
                    }
                } else {
                    String hql = "FROM User WHERE login = '" + mas[0] + "'";
                    List<?> listUsers = session.createQuery(hql).getResultList();
                    if (listUsers.isEmpty()) {
                        session.save(new User(mas[0], Base64.getEncoder().encodeToString(mas[1].getBytes())));
                        System.out.println("Успешная регистрация");
                    } else {
                        System.out.println("Ошибка регистрации, такой пользователь существует");
                    }
                }
                session.getTransaction().commit();
            }
        }
    }
}
