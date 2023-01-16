package com.example.w23comp1008s2w2fx;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //this will create an instance of a Card object
        //it holds the Ace of Spades
        Card aceOfSpades = new Card("Ace","Spades");
        Card queenOfHearts = new Card("Queen","Hearts");
        System.out.println("Value of "+aceOfSpades + ": "+aceOfSpades.getValue());
        System.out.println("colour: "+aceOfSpades.getColour());
        System.out.println(queenOfHearts.toString());


        List<String> faceNames = Card.getValidFaceNames();
        List<String> suits = Card.getValidSuitNames();

        //in each position of the collection (suits) is a String
        for (int i=0; i<suits.size(); i++)
        {
            System.out.println(suits.get(i));
        }

        for (String suit : suits)
        {
            for (String faceName : faceNames)
                System.out.println(faceName + " of " +suit);
        }
    }
}
