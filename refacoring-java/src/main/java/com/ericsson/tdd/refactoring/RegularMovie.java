package com.ericsson.tdd.refactoring;

class RegularMovie extends Movie {
    RegularMovie(String title) {
        super(title);
    }

    @Override
    double getRentalAmount(int daysRented) {
        if (daysRented > 2)
            return 2 +  (daysRented - 2) * 1.5;
        return 2;
    }

    @Override
    int getFrequentRenterPoints() {
        return 1;
    }
}
