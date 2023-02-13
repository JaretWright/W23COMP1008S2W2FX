package com.example.w23comp1008s2w2fx;

import javafx.scene.image.Image;

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
        setFaceName(faceName);
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

    /**
     * This validates that the facename is one of "2","3","4".
     * ...."9","10","Jack","Queen","King","Ace"
     * @param faceName
     */
    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();
        List<String> faceNameOptions = getValidFaceNames();
        if (faceNameOptions.contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName + " must be one of " +
                    faceNameOptions);
    }

    /**
     * This method returns a list of valid faceNames
     */
    public static List<String> getValidFaceNames()
    {
        return Arrays.asList("2","3","4","5","6","7","8","9","10",
                "jack","queen","king","ace");
    }

    /**
     * This method returns a String with the colour
     * of the suit
     */
    public String getColour()
    {
        if ( suit.equals("hearts") || suit.equals("diamonds"))
            return "red";
        else
            return "black";
    }

    /**
     * This method returns the value of the card
     */
    public int getValue()
    {
        List<String> faceNames = getValidFaceNames();
        int indexPosition = faceNames.indexOf(faceName);
        return indexPosition+2;
    }

    public static List<String> getValidSuitNames()
    {
        return Arrays.asList("hearts","spades","clubs","diamonds");
    }

    /**
     * This will ensure we have a valid suit before setting the instance
     * vairable
     * @param suit "hearts","spades","clubs","diamonds"
     */
    public void setSuit(String suit) {
        suit = suit.toLowerCase();

        //Create a list of valid card suit names
        List<String> validSuits = getValidSuitNames();

        //if the argument (suit) passed into the method is valid, set the instance
        //variable, otherwise throw an exception to stop the program
        if (validSuits.contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit +
                    " was received, valid options are " +validSuits);
    }

    public String getSuit() {
        return suit;
    }

    /**
     * This method returns an Image object representing the Card
     * visually
     * It will load the card image based on the filename structure
     * faceName_of_suit.png
     */
    public Image getImage()
    {
        String fileName = "images/" + faceName + "_of_" + suit + ".png";
        return new Image(Card.class.getResourceAsStream(fileName));
    }

    public Image getBackOfCardImage()
    {
        return new Image(Card.class.getResourceAsStream("images/back_of_card.png"));
    }
}
