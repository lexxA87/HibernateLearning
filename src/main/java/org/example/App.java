package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person1 = new Person("Alex", 23);
            Person person2 = new Person("Tim", 34);
            Person person3 = new Person("Lolly", 45);
            Person person4 = new Person("Trevor", 56);

            session.persist(person1);
            session.persist(person2);
            session.persist(person3);
            session.persist(person4);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
