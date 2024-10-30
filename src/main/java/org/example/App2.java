package org.example;

import org.example.model.Director;
import org.example.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App2 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // 1 - Get a director and his movies
            Director director1 = session.get(Director.class, 1);
            List<Movie> movies = director1.getMovies();
            System.out.println(director1);
            System.out.println(movies);

            System.out.println("***************");

            // 2 - Get a movie and its director
            Movie movie2 = session.get(Movie.class, 9);
            Director director2 = movie2.getDirector();
            System.out.println(movie2 + " from " + director2);

            System.out.println("***************");

            // 3 - Create new movie and add it some director
//            Director director3 = session.get(Director.class, 2);
//            Movie movie3 = new Movie("Some cool film", 1990, director3);
//            director3.getMovies().add(movie3);
//            session.persist(movie3);

            System.out.println("***************");

            // 4 - Create new director and movie and add each other
//            Director director4 = new Director("Bikov", 45);
//            Movie movie4 = new Movie("To live", 2015, director4);
//            director4.setMovies(new ArrayList<>(Collections.singletonList(movie4)));
//            session.persist(director4);
//            session.persist(movie4);

            System.out.println("***************");

            // 5 - Change director by movie
//            Movie movie5 = session.get(Movie.class, 13);
//            Director director5 = session.get(Director.class, 7);
//            movie5.getDirector().getMovies().remove(movie5);
//            movie5.setDirector(director5);
//            director5.getMovies().add(movie5);

            // 6 - Remove movie from some director
            Director director6 = session.get(Director.class, 2);
            Movie movie6 = session.get(Movie.class, 12);
            director6.getMovies().remove(movie6);
            System.out.println(director6);
            System.out.println(director6.getMovies());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
