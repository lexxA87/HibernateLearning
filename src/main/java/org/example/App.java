package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            List<Person> people = session.createQuery("from Person").getResultList();
//
//            for (Person person : people) {
//                System.out.println(person);
//            }


//            List<Person> people1 = session.createQuery("from Person where name LIKE 'A%'").getResultList();
            session.createQuery("update Person set name='Test name' where age < 30").executeUpdate();

            session.createQuery("delete from Person where age < 25").executeUpdate();

//            List<Person> people = session.createQuery("from Person where age < 30").getResultList();
//            for (Person person : people) {
//                System.out.println(person);
//            }

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
