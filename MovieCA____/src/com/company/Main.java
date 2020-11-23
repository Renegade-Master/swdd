

package com.company;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner keyboard;
    static Model model;

    public Main() {
    }

    public static void main(String[] args) {
        int opt;
        do {
            System.out.println("\n\n** MAIN MENU **");
            System.out.println("1. Create new Movie");
            System.out.println("2. View all Movies");
            System.out.println("3. Delete a Movie.");
            System.out.println("4. Update a Movie.");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("** Enter option: **\n\n");
            String line = keyboard.nextLine();
            opt = Integer.parseInt(line);
            switch(opt) {
                case 1:
                    Movie m = readMovie();
                    boolean created = model.addMovie(m);
                    if (created) {
                        System.out.println("** Movie Added to the Database **");
                    } else {
                        System.out.println("** Movie NOT Added to the Database **");
                    }
                    break;
                case 2:
                    viewMovies();
                    break;
                case 3:
                    deleteMovie();
                case 4:
                    updateMovie();
            }

        } while(opt != 5);

        System.out.println("Goodbye!");
    }

    private static Movie readMovie() {
        System.out.print("Enter title : ");
        String title = keyboard.nextLine();
        System.out.print("Enter director : ");
        String director = keyboard.nextLine();
        System.out.print("Enter running time : ");
        int runningTime = keyboard.nextInt();
        System.out.print("Enter age rating : ");
        int ageRating = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Is the movie available in 3D? true or false : ");
        boolean is3d = keyboard.nextBoolean();
        keyboard.nextLine();
        System.out.print("Enter premiere date (YYYY/MM/DD) : ");
        String dateString = keyboard.nextLine();
        return new Movie(runningTime, title, director, ageRating, dateString, is3d);
    }

    private static void viewMovies() {
        List<Movie> Movies = model.getMovies();
        System.out.println("** Printing All Movies **");
        Iterator var1 = Movies.iterator();

        while(var1.hasNext()) {
            Movie mo = (Movie)var1.next();
            System.out.println(mo);
        }

        System.out.println("** Finished Printing All Movies **");
    }

    private static void deleteMovie() {
        System.out.print("Enter the ID of the movie to delete:");
        int id = Integer.parseInt(keyboard.nextLine());
        if (model.deleteMovie(id)) {
            System.out.println("\nMovie deleted");
        } else {
            System.out.println("\nMovie not deleted, check your database to see if a movie with this ID actually exists");
        }

    }
    private static void updateMovie(){
        System.out.println("Enter the ID of the movie to update.");
        int id = Integer.parseInt(keyboard.nextLine());

        System.out.println("**LEAVE BLANK TO RETAIN CURRENT VALUE**");

        System.out.print("Enter title : ");
        String title = keyboard.nextLine();

        System.out.print("Enter director : ");
        String director = keyboard.nextLine();

        System.out.print("Enter running time : ");
        int runningTime = Integer.parseInt(keyboard.next());
        keyboard.nextLine();

        System.out.print("Enter age rating : ");
        int ageRating = Integer.parseInt(keyboard.nextLine());
        keyboard.nextLine();

        System.out.print("Is the movie available in 3D? true or false : ");
        boolean is3d = keyboard.nextBoolean();

        keyboard.nextLine();
        System.out.print("Enter premiere date (YYYY/MM/DD) : ");
        String dateString = keyboard.nextLine();


        if(model.updateMovie(id,runningTime, title, director, ageRating, dateString, is3d)){
            System.out.println("\nMovie updated.");
        }else{
            System.out.println("\nMovie not updated, check your database to see if a movie with this ID actually exists");
        }
    }

    static {
        keyboard = new Scanner(System.in);
        model = Model.getInstance();
    }
}
