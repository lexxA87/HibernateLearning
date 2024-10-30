package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App3 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Test Cascade", 23);
            person.addItem(new Item("TV smart"));
            person.addItem(new Item("Collection toys"));
            person.addItem(new Item("Book"));
            session.persist(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
