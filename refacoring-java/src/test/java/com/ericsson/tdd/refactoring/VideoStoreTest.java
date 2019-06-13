package com.ericsson.tdd.refactoring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest
{
    private final Movie newReleaseMovie1 = new NewReleaseMovie("The Cell");
    private final Movie newReleaseMovie2 = new NewReleaseMovie("The Tigger Movie");
    private final Movie kidsMovie = new ChildrensMovie("The Tigger Movie");
    private final Movie regularMovie2 = new RegularMovie("8 1/2");
    private final Movie regularMovie3 = new RegularMovie("Eraserhead");
    private final Movie regularMovie1 = new RegularMovie("Plan 9 from Outer Space");
    private Statement statement;

    @Before
    public void setUp ()  {
        statement = new Statement("Customer");
    }

    @Test
    public void testSingleNewReleaseStatement () {
        statement.addRental (new Rental (newReleaseMovie1, 3));
        statement.generateStatement();
        assertEquals(9.0, statement.getTotalOwed(), 0.001);
        assertEquals(2, statement.getFrequentRenterPoints());
    }

    @Test
    public void testDualNewReleaseStatement () {
        statement.addRental (new Rental (newReleaseMovie1, 3));
        statement.addRental (new Rental (newReleaseMovie2, 3));
        statement.generateStatement();
        assertEquals(18.0, statement.getTotalOwed(), 0.001);
        assertEquals(4, statement.getFrequentRenterPoints());
    }

    @Test
    public void testSingleChildrensStatement () {
        statement.addRental (new Rental (kidsMovie, 3));
        statement.generateStatement();
        assertEquals(1.50, statement.getTotalOwed(), 0.001);
        assertEquals(1, statement.getFrequentRenterPoints());
    }

    @Test
    public void testMultipleChildrensStatement () {
        statement.addRental (new Rental (kidsMovie, 3));
        statement.addRental (new Rental (kidsMovie, 5));
        statement.generateStatement();
        assertEquals(6, statement.getTotalOwed(), 0.001);
        assertEquals(2, statement.getFrequentRenterPoints());
    }

    @Test
    public void testMultipleRegularStatementTotals () {
        statement.addRental (new Rental (regularMovie1, 1));
        statement.addRental (new Rental (regularMovie2, 2));
        statement.addRental (new Rental (regularMovie3, 3));

        statement.generateStatement();
        assertEquals(7.5, statement.getTotalOwed(), 0.001);
        assertEquals(3, statement.getFrequentRenterPoints());
    }

    @Test
    public void testMultipleRegularStatementStatement () {
        statement.addRental (new Rental (regularMovie1, 1));
        statement.addRental (new Rental (regularMovie2, 2));
        statement.addRental (new Rental (regularMovie3, 3));

        assertEquals ("Rental Record for Customer\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", statement.generateStatement());
    }

}