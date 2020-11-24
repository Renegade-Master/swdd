package com.company;


import java.util.List;
import java.util.Scanner;


public class MovieDB {
    private final Model model;

    public MovieDB(Model model) {
        this.model = model;
    }


    public boolean readMovie() {
        return model.addMovie(generateMovie());
    }


    public void viewMovies() {
        List<Movie> Movies = model.getMovies();
        System.out.println("** Printing All Movies **");

        for (var movie : Movies) {
            System.out.println(movie);
        }

        System.out.println("** Finished Printing All Movies **");
    }


    public void deleteMovie() {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.print("Enter the ID of the movie to delete:");
            int id = keyboard.nextInt();

            if (model.deleteMovie(id)) {
                System.out.println("\nMovie deleted");
            } else {
                System.out.println("\nMovie not deleted, check your database to see if a movie with this ID actually exists");
            }
        }
    }


    public boolean updateMovie() {
        Movie movie;

        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Enter the ID of the movie to update.");
            int movieId = keyboard.nextInt();

            System.out.println("**LEAVE BLANK TO RETAIN CURRENT VALUE**");
            movie = generateMovie();

            movie.setId(movieId);
        }

        return model.updateMovie(movie);
    }

    private Movie generateMovie() {
        Movie movie = new Movie();

        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.print("Enter title : ");
            movie.setTitle(keyboard.nextLine());

            System.out.print("Enter director : ");
            movie.setDirector(keyboard.nextLine());

            System.out.print("Enter running time : ");
            movie.setRunningTime(keyboard.nextInt());

            System.out.print("Enter age rating : ");
            movie.setAgeRating(keyboard.nextInt());

            System.out.print("Is the movie available in 3D? true or false : ");
            movie.setIs3D(keyboard.nextBoolean());

            System.out.print("Enter premiere date (YYYY/MM/DD) : ");
            movie.setPremiereDate(keyboard.nextLine());
        }

        return movie;
    }
}
