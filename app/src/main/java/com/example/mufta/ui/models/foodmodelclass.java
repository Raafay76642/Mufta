package com.example.mufta.ui.models;

public class foodmodelclass {
    String Title;
    String Description;
    String Category;
    String StartingDate;
    String EndingDate;
    String Discount;
    String Location;
    String Upvote;
    String Link;
    String Id;
    String Contact;
    String Image;

    public foodmodelclass(String title, String description, String category, String startingDate, String endingDate, String discount, String location, String upvote, String link, String id, String contact, int image) {
        Title = title;
        Description = description;
        Category = category;
        StartingDate = startingDate;
        EndingDate = endingDate;
        Discount = discount;
        Location = location;
        Upvote = upvote;
        Link = link;
        Id = id;
        Contact = contact;
        Image = String.valueOf(image);
    }

    public foodmodelclass() {
    }

    public foodmodelclass(String st1, String st2, String st3, String st4, String st5, String st6, String st7, String st8, String st9) {
    }

    public String getUpvote() {
        return Upvote;
    }

    public void setUpvote(String upvote) {
        Upvote = upvote;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getStartingDate() {
        return StartingDate;
    }

    public void setStartingDate(String startingDate) {
        StartingDate = startingDate;
    }

    public String getEndingDate() {
        return EndingDate;
    }

    public void setEndingDate(String endingDate) {
        EndingDate = endingDate;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

}
