package com.ericsson.tdd.refactoring;

class Rental {
    private final Movie movie;
    private final int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    double getRentalAmount(){
        return movie.getRentalAmount(daysRented);
    }

    int getFrequentRenterPoints(){
        return movie.getFrequentRenterPoints();
    }

}