package com.example.w23comp1008s2w2fx;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    private ArrayList<Card> deck;

    /**
     * This is the constructor, it will allocate memory for a deck of card objects
     */
    public DeckOfCards()
    {
        deck = new ArrayList<>();
        List<String> faceNames = Card.getValidFaceNames();
        List<String> suits = Card.getValidSuitNames();

        //in each position of the collection (suits) is a String
        for (String suit : suits) {
            for (String faceName : faceNames) {
                deck.add(new Card(faceName,suit));
            }
        }
    }
}
