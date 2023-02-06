package com.example.w23comp1008s2w2fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HandViewController {

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;

    @FXML
    private ImageView imageView5;


    @FXML
    void dealHand(ActionEvent event) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        imageView1.setImage(deck.dealTopCard().getImage());
        imageView2.setImage(deck.dealTopCard().getImage());
        imageView3.setImage(deck.dealTopCard().getImage());
        imageView4.setImage(deck.dealTopCard().getImage());
        imageView5.setImage(deck.dealTopCard().getImage());
    }

}
