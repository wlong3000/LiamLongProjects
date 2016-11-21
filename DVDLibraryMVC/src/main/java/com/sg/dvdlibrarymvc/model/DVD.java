/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrarymvc.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author apprentice
 */
public class DVD {
    private int serialNumber;
    @NotEmpty (message="You must enter a title.")
    @Length (max=50, message = "Title must be no more than 50 characters in length.")
    private String title;
    @Min (value=1900, message="Year must be after 1900.")
    @Max (value=2030, message="Year must be before 2030.")
    private int releaseYear;
    @Length (max=5, message = "Rating must be no more than 5 characters in length.")
    private String rating;
    @Length (max=50, message = "Director must be no more than 50 characters in length.")
    private String director;
    @Length (max=50, message = "Studio must be no more than 50 characters in length.")
    private String studio;
    @Length (max=50, message = "Note must be no more than 50 characters in length.")
    private String note;

    public DVD() {

    }

    public DVD(int serialNumber, String title, int releaseDate, String rating, String director,
            String studio, String note) {
        DVD newDVD = new DVD();
        this.serialNumber = serialNumber;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseDate;
        this.rating = rating;
        this.studio = studio;
        this.note = note;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the releaseDate
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseYear(int releaseDate) {
        this.releaseYear = releaseDate;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * @param studio the studio to set
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the serialNumber
     */
    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
