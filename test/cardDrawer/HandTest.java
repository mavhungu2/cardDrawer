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
public class HandTest {
    Hand instance;
    
    public HandTest() {
        instance = new Hand(new Deck(), 5);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of strength method, of class Hand.
     */
    @Test
    public void testStrength() {
        String[] strengths = {
            "High cards",
            "Pair of",
            "Pair of",
            "Three of a kind",
            "high straight",
            "Flush",
            "Full house ",
            "Full house "
        };
        Boolean foundMatch = false;
        for (String strength : strengths) {
            if (instance.strength().contains(strength)) {
                foundMatch = true;
            }
        }
        assertTrue(foundMatch);
    }
    
}
