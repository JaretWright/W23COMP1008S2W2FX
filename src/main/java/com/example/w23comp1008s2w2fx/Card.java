package com.example.w23comp1008s2w2fx;

import java.util.Scanner;

public class Card {
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
        this.suit = suit;
    }

    /**
     * This will return the String with the card name and suit
     */
    public String toString()
    {
        return faceName + " of " + suit;
    }
}
