package com.example.w23comp1008s2w2fx;

import java.util.ArrayList;
import java.util.Collections;
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
        //loop over all the suits and all the facenames
        for (String suit : suits) {
            for (String faceName : faceNames) {
                deck.add(new Card(faceName,suit));
            }
        }
    }

    /**
     * This method will deal the top card from the deck
     */
    public Card dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        return null;
    }

    /**
     * This will shuffle the Deck
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
}
