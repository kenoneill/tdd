package com.ericsson.tdd.refactoring;

public class BlurayMovie extends Movie {
    public BlurayMovie(String skyfall) {
        super(skyfall);
    }

    @Override
    double getRentalAmount(int daysRented) {
        if(daysRented <= 5)
            return 5;
        else if (daysRented <= 10)
            return daysRented;
        else
            return 10 + (daysRented - 10) * 5;
    }

    @Override
    int getFrequentRenterPoints(int daysRented) {
        if(daysRented < 10)
            return daysRented;
        return 10 - (daysRented - 10);
    }
}
