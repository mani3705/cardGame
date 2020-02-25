package com.mani.practice.cardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> deckOfCards = new ArrayList<Integer>();
    boolean turn = true;

    public void setDeckOfCards(List<Integer> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public List<Integer> getDeckOfCards() {
        return deckOfCards;
    }
}
