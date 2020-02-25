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
        System.out.print("Player1 Cards : ");
        System.out.print(player1.getDeckOfCards());
        System.out.println();
        System.out.print("Player2 Cards : ");
        System.out.print(player2.getDeckOfCards());
        System.out.println();
        throwCard(player1,player2);
    }

    static void throwCard(Player player1,Player player2){
        int t=0;
        int turn = 0;
        int p1=0,p2=0;
        totalCardsInCenter.add(player1.getDeckOfCards().get(t));
        totalCardsInCenter.add(player2.getDeckOfCards().get(t));
        player1.getDeckOfCards().remove(t);
        player2.getDeckOfCards().remove(t);
        if(totalCardsInCenter.get(t)==totalCardsInCenter.get(t+1)){
            System.out.println("Bingo its a first tie in the first draw itself And the winner is Player 2");
            player1.getDeckOfCards().remove(t);
            player2.getDeckOfCards().remove(t);
            player2.getDeckOfCards().addAll(totalCardsInCenter);
            totalCardsInCenter.removeAll(totalCardsInCenter);
        }else{
            goToWhile(player1,player2,t,turn);
        }
        System.out.println("Player 1 Final "+player1.getDeckOfCards()+" "+player1.getDeckOfCards().size());
        System.out.println("Player 2 Final "+player2.getDeckOfCards()+" "+player2.getDeckOfCards().size());
        System.out.println("Total cards in center "+totalCardsInCenter+"  "+totalCardsInCenter.size());
    }

    private static void goToWhile(Player player1, Player player2 , int t,int turn) {
        int p1=0,p2=0;
        while(totalCardsInCenter.size()<52 || player1.getDeckOfCards().size()==52 || player2.getDeckOfCards().size()==52) {
            if (totalCardsInCenter.get(t) == totalCardsInCenter.get(t + 1)) {
                whenItsATie(player1,player2,t,turn);
            } else {
                if (turn == 0) {
                    totalCardsInCenter.add(player1.getDeckOfCards().get(p1));
                    player1.getDeckOfCards().remove(p1);
                    turn = 1;
                    t++;
                } else {
                    totalCardsInCenter.add(player2.getDeckOfCards().get(p2));
                    player2.getDeckOfCards().remove(p2);
                    turn = 0;
                    t++;
                }
            }
        }
    }

    private static void whenItsATie(Player player1, Player player2,int t,int turn) {
        System.out.println("Tie " + totalCardsInCenter.size());
        System.out.println(totalCardsInCenter + " " + t);
        if (turn == 1) {
            player1.getDeckOfCards().addAll(totalCardsInCenter);
            totalCardsInCenter.removeAll(totalCardsInCenter);
            System.out.println("Winner Player1 ");
            totalCardsInCenter.add(player1.getDeckOfCards().get(0));
            t=0;
            goToWhile(player1,player2,t,turn);
        } else {
            player2.getDeckOfCards().addAll(totalCardsInCenter);
            totalCardsInCenter.removeAll(totalCardsInCenter);
            System.out.println("Winner Player2 ");
            totalCardsInCenter.add(player1.getDeckOfCards().get(0));
            t=0;
            goToWhile(player1,player2,t,turn);
        }
    }
}
