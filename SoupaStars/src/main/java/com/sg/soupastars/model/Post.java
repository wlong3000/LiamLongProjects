/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.soupastars.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author apprentice
 */
public class Post {

    Calendar cal = Calendar.getInstance();
    // Allows us to get current User logged in
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    @NotEmpty(message = "Please enter a Title")
    @Length(max = 50, message = " Title must be no longer than 50 characters.")
    public String title;
    public int year = LocalDate.now().getYear();
    public String month = new SimpleDateFormat("MMMM").format(cal.getTime());
    public int day = LocalDate.now().getDayOfMonth();

    public String author;
    public int postId;
    public List<Comment> commentList;
    @NotEmpty(message = "Please enter a Body")
    @Length(max = 100000, message = " Body must be no longer than 100000 characters.")
    public String body;
    @NotEmpty(message = "Please enter a Category")
    @Length(max = 50, message = " Category must be no longer than 50 characters.")
    public String Category;
    public List<String> tagList;
    public int[] tagId;

    public Post() {
        if(authentication != null){
            this.author = authentication.getName();
        }
    }

//    public Post(String author) {
//        this.author = author;
//    }

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
     * @return the year
     */
    public int getYear() {
        return LocalDate.now().getYear();
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = LocalDate.now().getYear();
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the postId
     */
    public int getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(int postId) {
        this.postId = postId;
    }

    /**
     * @return the commentIdList
     */
    public List<Comment> getCommentList() {
        return commentList;
    }

    /**
     * @param commentList the commentList to set
     */
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the Category
     */
    public String getCategory() {
        return Category;
    }

    /**
     * @param Category the Category to set
     */
    public void setCategory(String Category) {
        this.Category = Category;
    }

    /**
     * @return the tagList
     */
    public List<String> getTagList() {
        return tagList;
    }

    /**
     * @param tagList the tagList to set
     */
    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public int[] getTagId() {
        return tagId;
    }

    public void setTagId(int[] tagId) {
        this.tagId = tagId;
    }

}
