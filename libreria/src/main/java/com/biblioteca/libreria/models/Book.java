package com.biblioteca.libreria.models;

public class Book {

    private int coverId;
    private String title;

    private String author;
    private String[] subjects;

    public Book(int coverId, String title, String author, int numberSubjects) {
        setCoverId(coverId);
        setTitle(title);
        setAuthor(author);
        this.subjects = new String[numberSubjects];
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getCoverId() {
        return coverId;
    }

    public void setCoverId(int coverId) {
        this.coverId = coverId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}
