package com.example.jordan.beautifulbulldog;

public class Vote {
    private Bulldog bulldog;
    private User owner;
    private int rating;

    public Bulldog getBulldog() {
        return bulldog;
    }

    public void setBulldog(Bulldog bulldog) {
        this.bulldog = bulldog;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
