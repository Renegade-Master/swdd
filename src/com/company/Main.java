package com.company;


import java.util.Scanner;


public class Main {
    static Scanner keyboard;
    static MovieDB movieDB;


    public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        movieDB = new MovieDB(Model.getInstance());

        System.out.print("\n\n** MAIN MENU **\n"
                + "1. Create new Movie\n"
                + "2. View all Movies\n"
                + "3. Delete a Movie\n"
                + "4. Update a Movie\n"
                + "5. Exit\n\n"
                + "** Enter option: **\n\n"
        );

        String opt = keyboard.nextLine();
        while (!opt.equals("5")) {
            switch (opt) {
                case "1" -> {
                    if (movieDB.readMovie()) {
                        System.out.println("** Movie Added to the Database **");
                    } else {
                        System.out.println("** Movie NOT Added to the Database **");
                    }
                }
                case "2" -> movieDB.viewMovies();
                case "3" -> movieDB.deleteMovie();
                case "4" -> {
                    if (movieDB.updateMovie()) {
                        System.out.println("\nMovie updated.");
                    } else {
                        System.out.println("\nMovie not updated, check your database to see if a movie with this ID actually exists");
                    }
                }
                default -> { // Always have a Default Case
                    System.out.print("Incorrect option.  Please enter a valid selection.");
                }
            }
        }

        System.out.println("Goodbye!");
    }
}
