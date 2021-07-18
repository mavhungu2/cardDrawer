/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardDrawer;

/**
 *
 * @author Isaac
 */
//card.java
public class Card
{

    private final int rank;
    private final int suit;

    private static final String[] suits = {"♥", "♠", "♦", "♣"};
    private static final String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public static String rankAsString(int __rank)
    {
        return ranks[__rank];
    }

    Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public @Override
    String toString() {
        return ranks[rank] + suits[suit];
    }

    public int getRank() { 
        return rank;
    }

    public int getSuit() {
        return suit;
    }
}
