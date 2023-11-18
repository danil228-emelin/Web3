package itmo.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
Row table=new Row();
session.beginTransaction();
session.save(table);
session.getTransaction().commit();
            System.out.println("ALL WORKS");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
