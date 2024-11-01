package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App6EagerAndLazyLoad {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 7);
            System.out.println(person);

            session.getTransaction().commit();

            System.out.println("2nd session created");
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            person = session.merge(person);
            Hibernate.initialize(person.getItems());

            session.getTransaction().commit();

            System.out.println("2nd session closed");

            System.out.println(person.getItems());
        }
        finally {
            sessionFactory.close();
        }
    }
}
