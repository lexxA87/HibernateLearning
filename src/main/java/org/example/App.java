package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // Get person and his items
//            Person person = session.get(Person.class, 1);
//            System.out.println(person);
//
//            List<Item> items = person.getItems();
//            System.out.println(items);

            // Get Item with its owner
//            Item item = session.get(Item.class, 5);
//            System.out.println(item);
//
//            Person person = item.getOwner();
//            System.out.println(person);

            // Add Item to Person
//            Person person = session.get(Person.class, 2);
//            Item item = new Item("Some Item", person);
//            person.getItems().add(item); // good practise for cash of Hibernate
//            session.persist(item);

            // Add new Person and new Item for him
//            Person person = new Person("Luee", 34);
//            Item item = new Item("Lorem ipsum", person);
//
//            person.setItems(new ArrayList<>(Collections.singletonList(item)));
//            session.persist(person);
//            session.persist(item);

            // Remove all items from Person
//            Person person = session.get(Person.class, 1);
//            List<Item> items = person.getItems();
//
//            for (Item item : items) {
//                session.remove(item);
//            }
//            person.getItems().clear();

            // Remove Person
//            Person person = session.get(Person.class, 2);
//            session.remove(person);
//            person.getItems().forEach(i -> i.setOwner(null));

            // Change owner of Item
            Person person = session.get(Person.class, 4);
            Item item = session.get(Item.class, 8);

            item.getOwner().getItems().remove(item);
            item.setOwner(person);
            person.getItems().add(item);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
