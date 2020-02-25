package com.mani.practice.cardGame;

import java.util.ArrayList;
import java.util.List;

public class Play {
    static List<Integer> totalCardsInCenter = new ArrayList<Integer>();
    public static void main(String[] args) {
        CardAddition cardAddition = new CardAddition();
        Player player1 = new Player();
        Player player2 = new Player();
        cardAddition.setCards(player1);
        cardAddition.setCards(player2);
        System.out.println("Player1");
        System.out.println(player1.getDeckOfCards());

        System.out.println("Player2");
        System.out.println(player2.getDeckOfCards());
        throwCard(player1,player2);
    }

    static void throwCard(Player player1,Player player2){
        int temp1=0;
        int temp2 = 0;
        int i =0;
        while(player1.getDeckOfCards().size()>0 && player2.getDeckOfCards().size()>0 || totalCardsInCenter.size()>=30){
            if(i/2==0){
                player1.turn=false;
                player2.turn=true;
            }else{
                player1.turn=true;
                player2.turn=false;
            }
            temp1 = player1.getDeckOfCards().get(i);
            temp2 = player2.getDeckOfCards().get(i);
            totalCardsInCenter.add(temp1);
            totalCardsInCenter.add(temp2);
            if(totalCardsInCenter.size()>=4){
                if(totalCardsInCenter.get(i)==totalCardsInCenter.get(i-1) && player2.turn==false){
                    System.out.println("Hey its a tie player2 wins");
                    player2.getDeckOfCards().addAll(totalCardsInCenter);
                    System.out.println(player2.getDeckOfCards()+"  \n "+player1.getDeckOfCards());
                }
                if(totalCardsInCenter.get(i)==totalCardsInCenter.get(i-1)){
                    System.out.println("Hey its a tie player1 wins");
                    player1.getDeckOfCards().addAll(totalCardsInCenter);
                    System.out.println(player1.getDeckOfCards()+ " \n "+player2.getDeckOfCards());
                }
            }
            i++;
        }
    }

}
