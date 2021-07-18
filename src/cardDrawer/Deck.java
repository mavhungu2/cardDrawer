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
//Deck.java
import java.util.Random; //import Random and ArrayList which will be used in our deck.

import java.util.ArrayList;
import java.util.Collections;

public class Deck { //Creating class Deck which will hold cards from Card.

    private final ArrayList<Card> cards;

    Deck() {
        // Card deck
        cards = new ArrayList<>();
        //Create array of card deck
        for (int SuitsCounter = 0; SuitsCounter <= 3; SuitsCounter++)
        {
            for (int ranksCounter = 0; ranksCounter <= 12; ranksCounter++) {
                cards.add(new Card(SuitsCounter, ranksCounter));
            }
        }
        // Shuffle the card deck
        Collections.shuffle(cards);
    }
    
    //Used to draw a single card
    public Card drawFromDeck() 
    {
        return cards.remove(cards.size() - 1);
    }

}
