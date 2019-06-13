package com.ericsson.tdd.refactoring;

class NewReleaseMovie extends Movie {
    NewReleaseMovie(String movieTitle) {
        super(movieTitle);
    }

    @Override
    double getRentalAmount(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentRenterPoints() {
            return 2;
    }
}
