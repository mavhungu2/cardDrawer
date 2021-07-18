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
//hand.java
public class Hand //Creating class Hand which will contain one persons cards and evaluate.
{

    private Card[] cards; //cards represent a player’s cards.
    private int[] value; //value is used later to determine hand strength.
    private int handSize;

    Hand(Deck d, int handSize) {
        this.handSize = handSize;
        value = new int[6]; //value is used to determine what kind of hand a player has.
        cards = new Card[handSize];

        for (int x = 0; x < handSize; x++)//Draw five cards from deck and place them in cards.
        {
            cards[x] = d.drawFromDeck();
        }

        int[] ranks = new int[14];
        int[] orderedRanks = new int[5];
        boolean flush = true, straight = false; //Variables to be used to determine pairs, flush, etc.
        int sameCards = 1, sameCards2 = 1;
        int largeGroupRank = 0, smallGroupRank = 0;
        int index = 0;
        for (int x = 0; x <= 13; x++) //Clean out ranks array.
        {
            ranks[x] = 0;
        }
        for (int x = 0; x <= this.handSize-1; x++) //Assign rank to cards in hand.
        {
            ranks[cards[x].getRank()]++;
        }

        for (int x = 0; x < this.handSize-1; x++) { //Test for similar suit, for possible flush.
            if (cards[x].getSuit() != cards[x + 1].getSuit()) {
                flush = false;
            }
        }

        for (int x = 13; x >= 1; x--) //Determine the amount of multiple cards
        { //and determine the highest face value for possible full house.
            if (ranks[x] > sameCards) {
                if (sameCards != 1) {
                    sameCards2 = sameCards;
                    smallGroupRank = largeGroupRank;
                }

                sameCards = ranks[x];
                largeGroupRank = x;

            } else if (ranks[x] > sameCards2) {
                sameCards2 = ranks[x];
                smallGroupRank = x;
            }
        }
        if (ranks[1] == 1) //Run first if ace since it is the highest value.
        {
            orderedRanks[index] = 14;
            index++;
        }

        for (int x = 13; x >= 2; x--) {
            if (ranks[x] == 1) {
                orderedRanks[index] = x;
                index++;
            }
        }

        for (int x = 1; x <= 9; x++) //We set constraints to 9 because a straight can’t begin at 10.
        {
            if (ranks[x] == 1 && ranks[x + 1] == 1 && ranks[x + 2] == 1 && ranks[x + 3] == 1 && ranks[x + 4] == 1) //If ranks ascend = straight.
            {
                straight = true;
                break;
            }
        }

        if (ranks[10] == 1 && ranks[11] == 1 && ranks[12] == 1 && ranks[13] == 1 && ranks[1] == 1) //If straight.
        {
            straight = true;
        }

        for (int x = 0; x <= 5; x++) {
            value[x] = 0; //Clean array value[]
        }

        if (sameCards == 1) //Evaluation of hands.
        {
            value[0] = 1;
            value[1] = orderedRanks[0];
            value[2] = orderedRanks[1];
            value[3] = orderedRanks[2];
            value[4] = orderedRanks[3];
            value[5] = orderedRanks[4];
        }

        if (sameCards == 2 && sameCards2 == 1) {
            value[0] = 2;
            value[1] = largeGroupRank; //Rank of pair
            value[2] = orderedRanks[0];
            value[3] = orderedRanks[1];
            value[4] = orderedRanks[2];
        }

        if (sameCards == 2 && sameCards2 == 2) //Two pair
        {
            value[0] = 3;
            value[1] = largeGroupRank > smallGroupRank ? largeGroupRank : smallGroupRank;
            value[2] = largeGroupRank < smallGroupRank ? largeGroupRank : smallGroupRank;
            value[3] = orderedRanks[0];
        }

        if (sameCards == 3 && sameCards2 != 2) {
            value[0] = 4;
            value[1] = largeGroupRank;
            value[2] = orderedRanks[0];
            value[3] = orderedRanks[1];
        }

        if (straight) {
            value[0] = 5;
            value[1] = orderedRanks[0];
        }

        if (flush) {
            value[0] = 6;
            value[1] = orderedRanks[0]; //Tie determined by ranks of cards
            value[2] = orderedRanks[1];
            value[3] = orderedRanks[2];
            value[4] = orderedRanks[3];
            value[5] = orderedRanks[4];
        }

        if (sameCards == 3 && sameCards2 == 2) {
            value[0] = 7;
            value[1] = largeGroupRank;
            value[2] = smallGroupRank;
        }

        if (sameCards == 4) {
            value[0] = 8;
            value[1] = largeGroupRank;
            value[2] = orderedRanks[0];
        }

    }

    String strength() //Display method is used to determine and print the strength of a hand.
    {
        String result;
        switch (value[0]) //The higher the value[] , the stronger the hand.
        {

            case 1:
                result = "High cards";
                break;
            case 2:
                result = "Pair of " + Card.rankAsString(value[1]) + "\'s";
                break;
            case 3:
                result = "Pair of " + Card.rankAsString(value[1]) + " " + Card.rankAsString(value[2]);
                break;

            case 4:
                result = "Three of a kind " + Card.rankAsString(value[1]) + "\'s";
                break;

            case 5:
                result = Card.rankAsString(value[1]) + " high straight";
                break;

            case 6:
                result = "Flush";
                break;

            case 7:
                result = "Full house " + Card.rankAsString(value[1]) + " over "
                        + Card.rankAsString(value[2]);
                break;

            case 8:
                result = "Full house " + Card.rankAsString(value[1]);
                break;

            default:
                result = "Error, check coding";
        }

        System.out.print(result); //Strength of hand, “pair, three of a kind etc” is printed.
        return result;
    }

    void displayCards() //This method prints the hands that a player has in their hand.
    {
        for (int x = 0; x < this.handSize; x++) //Print all 5 cards in hand.
        {
            System.out.print(cards[x] + " ");
        }

        System.out.printf("\n");
    }
}
