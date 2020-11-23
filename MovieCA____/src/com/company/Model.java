

package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {
    private static Model instance = null;
    private List<Movie> Movies;
    private MovieTableGateway gateway;

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }

        return instance;
    }

    private Model() {
        try {
            Connection conn = DBConnection.getInstance();
            this.gateway = new MovieTableGateway(conn);
        } catch (ClassNotFoundException var2) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "Problem Connecting to the Database, have you added your JDBC Driver .jar file?", var2);
        } catch (SQLException var3) {
            var3.printStackTrace();
        }

    }

    public List<Movie> getMovies() {
        return this.gateway.getMovies();
    }

    public boolean addMovie(Movie m) {
        return this.gateway.insertMovie(m);
    }

    public boolean deleteMovie(int id) {
        return this.gateway.deleteMovie(id);
    }

    public boolean updateMovie(int id,int runningTime,String title,String director, int ageRating, String dateString,boolean is3d){
        return this.gateway.updateMovie(id,runningTime, title, director, ageRating, dateString, is3d);
    }
}
