/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardDrawer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isaac
 */
public class CardTest {

    private final Card instance;
    
    public CardTest() {
        this.instance = new Card(1, 1);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of rankAsString method, of class Card.
     */
    @Test
    public void testRankAsString() {
        // TODO review the generated test code and remove the default call to fail.
        String expResult = "Ace";
        String result = Card.rankAsString(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        String expResult = "2♠";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getRank method, of class Card.
     */
    @Test
    public void testGetRank() {
        int expResult = 1;
        int result = instance.getRank();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuit() {
        int expResult = 1;
        int result = instance.getSuit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
