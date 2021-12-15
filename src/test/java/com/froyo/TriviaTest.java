/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.froyo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erwan.legoff
 */
public class TriviaTest {
    
    public TriviaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createRockQuestion method, of class Trivia.
     */
    @Test
    public void testCreateRockQuestion() {
        System.out.println("createRockQuestion");
        int index = 0;
        Trivia object = new Trivia();
        String expResult = "Rock Question 0";
        String result = object.createRockQuestion(index);
        assertEquals(expResult, result);


    }

    /**
     * Test of isPlayable method, of class Trivia.
     */
    @Test
    public void testIsPlayable() {
        System.out.println("isPlayable");
        Trivia object = new Trivia();
        boolean expResult = false;
        boolean result = object.isPlayable();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class Trivia.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String playerName = "test";
        Trivia object = new Trivia();
        boolean expResult = true;
        object.add(playerName);
        boolean result = object.players.contains(playerName);
        assertEquals(expResult, result);

    }

    /**
     * Test of howManyPlayers method, of class Trivia.
     */
    @Test
    public void testHowManyPlayers() {
        System.out.println("howManyPlayers");
        Trivia object = new Trivia();
        object.add("test");
        int expResult = 1;
        int result = object.howManyPlayers();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of roll method, of class Trivia.
     */
    @Test
    public void testRoll() {
        System.out.println("roll");
        int roll = 1;
        int expected = 1;
        Trivia object = new Trivia();
        object.add("test");
        object.roll(roll);
        assertEquals(expected, object.places[0]);
        // // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of wasCorrectlyAnswered method, of class Trivia.
     */
    @Test
    public void testWasCorrectlyAnswered() {
        System.out.println("wasCorrectlyAnswered");
        Trivia object = new Trivia();
        int roll = 1;
        object.add("test");
        object.roll(roll);
        boolean expResult = true;
        boolean result = object.wasCorrectlyAnswered();
        assertEquals(expResult, result);
    }

    /**
     * Test of wrongAnswer method, of class Trivia.
     */
    @Test
    public void testWrongAnswer() {
        System.out.println("wrongAnswer");
        Trivia object = new Trivia();
        boolean expResult = true;
        boolean result = object.wrongAnswer();
        assertEquals(expResult, result);

    }
    
}
