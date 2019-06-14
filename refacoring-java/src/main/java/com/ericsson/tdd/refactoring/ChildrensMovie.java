package com.ericsson.tdd.refactoring;

class ChildrensMovie extends Movie {
    ChildrensMovie(String title) {
        super(title);
    }

    @Override
    double getRentalAmount(int daysRented) {
        if (daysRented > 3)
            return  1.5 +  (daysRented - 3) * 1.5;
        return 1.5;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
