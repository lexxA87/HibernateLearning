package org.example;

import org.example.model.Principal;
import org.example.model.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App4OneToOne {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Principal.class).addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // 1 - Get any principal and his school
            Principal principal1 = session.get(Principal.class, 1);
            School school1 = principal1.getSchool();
            System.out.println(principal1 + "\n" + school1);

            System.out.println("* * * * * * * * * *");

            // 2 - Get any school and its principal
            School school2 = session.get(School.class, 1);
            Principal principal2 = school2.getPrincipal();
            System.out.println(school2 + "\n" + principal2);

            System.out.println("* * * * * * * * * *");

            // 3 - Create new Principal and school and link these entities
//            Principal principal3 = new Principal("Billy", 34);
//            School school3 = new School(3456, principal3);
//            principal3.setSchool(school3);
//            session.persist(principal3);

            // 4 - Change principal by school
//            Principal principal4 = new Principal("Alex", 37);
//            School school4 = session.get(School.class, 5);
//            school4.setPrincipal(principal4);
//            session.persist(principal4);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
