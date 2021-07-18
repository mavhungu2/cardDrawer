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
public class DeckTest {
    
    public DeckTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of drawFromDeck method, of class Deck.
     */
    @Test
    public void testDrawFromDeck() {
        Deck instance = new Deck();
        Card result = instance.drawFromDeck();
        assertTrue(result instanceof  Card);
    }
    
}
