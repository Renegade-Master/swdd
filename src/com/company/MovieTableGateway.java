package com.company;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MovieTableGateway {
    private static final String TABLE_NAME = "movies";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_RUNNINGTIME = "runningTime";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DIRECTOR = "director";
    private static final String COLUMN_AGERATING = "ageRating";
    private static final String COLUMN_PREMIERE = "premiereDate";
    private static final String COLUMN_3D = "is3D";
    private final Connection mConnection;


    public MovieTableGateway(Connection connection) {
        this.mConnection = connection;
    }


    public boolean insertMovie(Movie m) {
        String query = "INSERT INTO movies (runningTime, title, director, ageRating, premiereDate, is3D) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.mConnection.prepareStatement(query, 1);
            stmt.setInt(1, m.getRunningTime());
            stmt.setString(2, m.getTitle());
            stmt.setString(3, m.getDirector());
            stmt.setInt(4, m.getAgeRating());
            stmt.setDate(5, m.getPremiereDate());
            stmt.setBoolean(6, m.getIs3D());
            int numRowsAffected = stmt.executeUpdate();
            if (numRowsAffected == 1) {
                return true;
            }
        } catch (SQLException var6) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception in ProgrammerTableGateway : insertProgrammer(), Check the SQL you have created to see where your error is", var6);
        }

        return false;
    }


    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        String query = "SELECT * FROM movies";

        try {
            Statement stmt = this.mConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String director = rs.getString("director");
                String premiereDate = rs.getString("premiereDate");
                int runningTime = rs.getInt("runningTime");
                int ageRating = rs.getInt("ageRating");
                boolean is3d = rs.getBoolean("is3D");
                Movie m = new Movie(id, runningTime, title, director, ageRating, premiereDate, is3d);
                movies.add(m);
            }
        } catch (SQLException var13) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception in ProgrammerTableGateway : getProgrammers(), Check the SQL you have created to see where your error is", var13);
        }

        return movies;
    }


    public boolean deleteMovie(int id) {
        String query = "DELETE FROM movies WHERE id= ?";

        try {
            PreparedStatement stmt = this.mConnection.prepareStatement(query);
            stmt.setInt(1, id);
            System.out.println("\n\nTHE SQL LOOKS LIKE THIS " + stmt.toString() + "\n\n");
            int numRowsAffected = stmt.executeUpdate();
            if (numRowsAffected == 1) {
                return true;
            }
        } catch (SQLException var5) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception in ProgrammerTableGateway : deleteMovie(), Check the SQL you have created to see where your error is", var5);
        }

        return false;
    }


    public boolean updateMovie(int id, int runningTime, String title, String director, int ageRating, String dateString, boolean is3d) {

        String query = "UPDATE movies SET runningTime = COALESCE(?, runningTime), title = COALESCE(?,title),director = COALESCE(?,director),ageRating = COALESCE(?,ageRating),premiereDate = COALESCE(?,premiereDate),is3D = COALESCE(?,is3D) WHERE id = ?";
        try {
            PreparedStatement stmt = this.mConnection.prepareStatement(query);

            stmt.setInt(1, runningTime);
            stmt.setString(2, title);
            stmt.setString(3, director);
            stmt.setInt(4, ageRating);
            stmt.setDate(5, Date.valueOf(dateString));
            stmt.setBoolean(6, is3d);
            stmt.setInt(7, id);

            System.out.println("\n\nTHE SQL LOOKS LIKE THIS " + stmt.toString() + "\n\n");
            int numRowsAffected = stmt.executeUpdate();
            if (numRowsAffected == 1) {
                return true;
            }
        } catch (SQLException var5) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, "SQL Exception in ProgrammerTableGateway : updateMovie(), Check the SQL you have created to see where your error is", var5);
        }

        return false;
    }

    public boolean updateMovie(Movie movie) {
        return updateMovie(movie.getId(), movie.getRunningTime(), movie.getTitle(), movie.getDirector(), movie.getAgeRating(), movie.getPremiereDate().toString(), movie.getIs3D());
    }
}
