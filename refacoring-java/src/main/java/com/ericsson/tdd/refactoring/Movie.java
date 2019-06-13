package com.ericsson.tdd.refactoring;

abstract class Movie {
    private final String title;

    Movie(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    abstract double getRentalAmount(int daysRented);

    abstract int getFrequentRenterPoints();
}