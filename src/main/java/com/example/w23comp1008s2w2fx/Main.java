package com.example.w23comp1008s2w2fx;

public class Main {
    public static void main(String[] args) {
        //this will create an instance of a Card object
        //it holds the Ace of Spades
        Card aceOfSpades = new Card("Queen","Hearts");
        System.out.println("Value of "+aceOfSpades + ": "+aceOfSpades.getValue());
        System.out.println("colour: "+aceOfSpades.getColour());
    }
}
