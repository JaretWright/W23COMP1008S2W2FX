package com.example.w23comp1008s2w2fx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Card {
    //faceName and suit are private instance variables
    //private means that they are only accessible inside of the class
    private String faceName;
    private String suit;

    /**
     * This is called a constructor.  This is a special "method" that
     * does not have a return type and must have the exact same name as
     * the class
     * @param faceName "2","3","4"....."9","10","Jack","Queen","King","Ace"
     * @param suit "hearts","spades","clubs","diamonds"
     */
    public Card(String faceName, String suit) {
        this.faceName = faceName;
        setSuit(suit);
    }

    /**
     * This will return the String with the card name and suit
     */
    public String toString()
    {
        return faceName + " of " + suit;
    }

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) {
        this.faceName = faceName;
    }

    public String getSuit() {
        return suit;
    }

    /**
     * This will ensure we have a valid suit before setting the instance
     * vairable
     * @param suit "hearts","spades","clubs","diamonds"
     */
    public void setSuit(String suit) {
        //Create a list of valid card suit names
        List<String> validSuits =
                            Arrays.asList("hearts","spades","clubs","diamonds");

        //if the argument (suit) passed into the method is valid, set the instance
        //variable, otherwise throw an exception to stop the program
        if (validSuits.contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit +
                    " was received, valid options are " +validSuits);
    }
}
