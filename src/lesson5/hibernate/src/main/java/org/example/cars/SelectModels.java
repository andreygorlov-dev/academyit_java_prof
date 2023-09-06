package org.example.cars;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class SelectModels {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Mark.class)
                .addAnnotatedClass(Model.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Create record");

            String hql = "FROM Mark mark INNER JOIN Model model on mark.id = model.mark.id";

            List<?> listModels = session.createQuery(hql).getResultList();

            for (int i = 0; i < listModels.size(); i++) {
                Object[] row = (Object[]) listModels.get(i);
                Mark mark = (Mark) row[0];
                Model model = (Model) row[1];
                System.out.println(model.getTitleModel() + " : " + mark.getTitleMark());
            }

            session.getTransaction().commit();
        }
    }
}
