package org.example.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director director;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int yearOfProduction;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    public Movie() {}

    public Movie(String name, int yearOfProduction, Director director) {
        this.name = name;
        this.yearOfProduction = yearOfProduction;
        this.director = director;
    }

    public int getId() {
        return movie_id;
    }

    public void setId(int id) {
        this.movie_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    @Override
    public String toString() {
        return "'" + name + '\'' + ", " + yearOfProduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movie_id == movie.movie_id && yearOfProduction == movie.yearOfProduction && Objects.equals(director, movie.director) && Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie_id, director, name, yearOfProduction);
    }
}
