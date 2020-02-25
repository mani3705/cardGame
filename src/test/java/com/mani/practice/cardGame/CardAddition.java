package com.mani.practice.cardGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CardAddition {

    List<Integer> cards;

    public void setCards(Player player) {
        cards = new ArrayList<Integer>();
        for(int j=1;j<=2;j++) {
            for (int i = 1; i <= 13; i++) {
                cards.add(i);
            }
        }
        Collections.shuffle(cards);
        player.setDeckOfCards(cards);

    }
}
