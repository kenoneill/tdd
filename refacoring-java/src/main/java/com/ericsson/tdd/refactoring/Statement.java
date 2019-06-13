package com.ericsson.tdd.refactoring;

import java.util.ArrayList;
import java.util.List;

class Statement {
    private final String customerName;
    private final List<Rental> rentals = new ArrayList<>();
    private double totalAmount;
    private int frequentRenterPoints;

    Statement(String customerName) {
        this.customerName = customerName;
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    String generateStatement() {
        resetTotals();
        String result = generateHeader();
        result += getRentalLines();
        result += generateFooter();
        return result;
    }

    private void resetTotals() {
        totalAmount = 0;
        frequentRenterPoints = 0;
    }

    private String generateHeader() {
        return String.format("Rental Record for %s\n", customerName);
    }

    private String getRentalLines() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            totalAmount += rental.getRentalAmount();
            frequentRenterPoints += rental.getFrequentRenterPoints();
            result.append(String.format("\t%s\t%s\n", rental.getMovie().getTitle(), rental.getRentalAmount()));
        }
        return result.toString();
    }

    private String generateFooter() {
        return String.format("You owed %.1f\nYou earned %d frequent renter points\n", totalAmount, frequentRenterPoints);
    }


    double getTotalOwed() {
        return totalAmount;
    }

    int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}