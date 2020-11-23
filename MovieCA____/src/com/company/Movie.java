
package com.company;

import java.sql.Date;

public class Movie {
    private int id;
    private int runningTime;
    private String title;
    private String director;
    private int ageRating;
    private Date premiereDate;
    private boolean is3D;

    public Movie(int rt, String t, String d, int a, String dt, boolean is3dTemp) {
        this.runningTime = rt;
        this.title = t;
        this.director = d;
        this.ageRating = a;
        this.premiereDate = Date.valueOf(dt);
        this.is3D = is3dTemp;
    }

    public Movie(int id, int rt, String t, String d, int a, String dt, boolean is3dTemp) {
        this.id = id;
        this.runningTime = rt;
        this.title = t;
        this.director = d;
        this.ageRating = a;
        this.premiereDate = Date.valueOf(dt);
        this.is3D = is3dTemp;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRunningTime() {
        return this.runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAgeRating() {
        return this.ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public void setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
    }

    public Date getPremiereDate() {
        return this.premiereDate;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public boolean getIs3D() {
        return this.is3D;
    }

    public String toString() {
        return "Movie id=" + this.id + ", runningTime= " + this.runningTime + ", title= '" + this.title + "', director= '" + this.director + "', ageRating= " + this.ageRating + ", premiereDate= " + this.premiereDate + ", is3D= " + this.is3D;
    }
}
