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
public class CardDrawer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        Deck deck = new Deck(); //Creating constructors to call
        Hand hand = new Hand(deck, 5); //Create a hand od cards with the specified number of cards
        System.out.print("Your hand: ");
        //Print hands to screen
        hand.displayCards();

        System.out.printf("You have: ");
        hand.strength();

        System.out.printf("\n");
    }
}
