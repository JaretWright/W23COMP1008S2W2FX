package com.example.w23comp1008s2w2fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class MatchingGameController implements Initializable {

    @FXML
    private FlowPane flowPane;

    @FXML
    private Label correctLabel;

    @FXML
    private Label guessNumLabel;

    @FXML
    private Label percentCorrectLabel;

    private ArrayList<MemoryCard> cardsDealt;
    private MemoryCard card1, card2;

    private int numOfGuesses, numOfMatches;

    @FXML
    void playAgain(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        card1 = null;
        card2 = null;

        //Show the back of cards
        //This is the "long" way that calls each ImageView object directly
        Image backOfCard = new Image(Card.class.getResourceAsStream("images/back_of_card.png"));

        //We can also achieve this by looping over all the "Node's" in the HBox container
        //add a "listener" to each ImageView so that we can display the card selected
        for (int i=0; i<flowPane.getChildren().size(); i++)
        {
            //Cast the Node to be an ImageView object.  This is sort of like saying
            //It's a car versus it's a BMW
            Node node = flowPane.getChildren().get(i);
            ImageView imageView = (ImageView) node;
            imageView.setImage(backOfCard);
            imageView.setUserData(i);

            //the -> {} is a "lambda expression", not required for this course, but can make things easier
            imageView.setOnMouseClicked(event -> {
                flipCard((int)imageView.getUserData());
            });
        }

        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        cardsDealt = new ArrayList<>();

        //deal 1/2 the number of imageView objects and duplicate them
        for (int i=1; i<=flowPane.getChildren().size()/2 ; i++)
        {
            Card card = deck.dealTopCard();
            MemoryCard memoryCard = new MemoryCard(card.getFaceName(),card.getSuit());
            cardsDealt.add(memoryCard);
            cardsDealt.add(memoryCard);
        }

        Collections.shuffle(cardsDealt);
        displayCardsDealt();
    }

    private void displayCardsDealt()
    {
        for (int i=0; i<cardsDealt.size(); i++)
        {
            System.out.printf("Index %2d: %s %n",i, cardsDealt.get(i));
        }
    }

    /**
     * This method will use the index position to read from the cards dealt and update the imageview
     * with that card's image
     */
    private void flipCard(int indexPositionOfCard)
    {
        ImageView imageView = (ImageView) flowPane.getChildren().get(indexPositionOfCard);

        //if both cards are null, then show the backs of all the unmatched cards
        if (card1==null && card2==null)
            flipAllCards();

        //if card1 = null, this is the first card to be flipped
        if (card1==null)
        {
            card1 = cardsDealt.get(indexPositionOfCard);
            imageView.setImage(card1.getImage());
        }
        //if card2 = null and card1 is not null, this is the second card to be flipped
        else if (card2==null)
        {
            numOfGuesses++;
            card2 = cardsDealt.get(indexPositionOfCard);
            imageView.setImage(card2.getImage());
            checkForMatch();
        }
        updateLabels();
    }

    /**
     * This method will check to see if the 2 cards (card1 and card2) are the same object
     */
    private void checkForMatch()
    {
        if (card1==card2)
        {
            card1.setMatched(true);
            card2.setMatched(true);
            numOfMatches++;
        }
        card1=null;
        card2=null;
    }

    /**
     * This method will loop through the cards that are dealt and check if a card is matched.  If it is matched, it will
     * display the card image.  If it is not matched, show the back of the card
     */
    private void flipAllCards()
    {
        for (int i=0; i<cardsDealt.size(); i++)
        {
            ImageView imageView = (ImageView) flowPane.getChildren().get(i);
            MemoryCard card = cardsDealt.get(i);
            if (card.isMatched())
                imageView.setImage(card.getImage());
            else
                imageView.setImage(card.getBackOfCardImage());
        }
    }

    /**
     * This method updates the labels with the game statistics
     */
    private void updateLabels()
    {
        double percentCorrect = (double) numOfMatches/numOfGuesses*100;
        guessNumLabel.setText("Guesses: "+numOfGuesses);
        correctLabel.setText("Correct Matches: " +numOfMatches);
        if (numOfGuesses!=0)
            percentCorrectLabel.setText(String.format("Percent Correct: %.0f%%",percentCorrect));
    }
}
