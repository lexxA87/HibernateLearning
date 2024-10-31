package org.example;

import org.example.model.Actor;
import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App5ManyToMany {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class).addAnnotatedClass(Actor.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Movie movie = session.get(Movie.class, 2);
//            Actor actor1 = new Actor("Harvey Keitel", 81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//
//            movie.setActors(new ArrayList<>(Arrays.asList(actor1, actor2)));
//
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//
//            session.persist(actor1);
//            session.persist(actor2);

//            Movie movie = session.get(Movie.class, 1);
//            Actor actor = session.get(Actor.class, 1);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);

            Actor actor = session.get(Actor.class, 1);
            System.out.println(actor.getMovies());

            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
