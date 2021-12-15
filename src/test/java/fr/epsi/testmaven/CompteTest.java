/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.epsi.testmaven;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author 33676
 */
public class CompteTest {
    
    public CompteTest() {
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

    @Test
	public void testCreationCompte() {
		Compte compte = new Compte();
		float solde = compte.getSolde();
		assertTrue(solde == 0);
	}
    /**
     * Test of crediter method, of class Compte.
     */
    @Test
	public void testCrediter() {
		try {
			Compte compte = new Compte();
			compte.crediter(0);
			float solde = compte.getSolde();
			assertTrue(solde == 0);
		} catch(Exception e) {				// si on a une exception... 
			fail("Erreur credit");	// ... c'est une erreur
		}		
	}
    /**
     * Test of getSolde method, of class Compte.
     */
    @Test
    public void testGetSolde() {
        System.out.println("getSolde");
        Compte instance = new Compte();
        float expResult = 0.0F;
        float result = instance.getSolde();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    @Test			// exception attendue...	
	public void testDebiter() {
		assertThrows(Exception.class, () -> {
			Compte compte = new Compte();
			float solde = compte.debiter(-10);		// ... on ne peut pas debiter -10
		  });
	}

    /**
     * Test of setSolde method, of class Compte.
     */
    @Test
    public void testSetSolde() throws Exception {
        System.out.println("setSolde");
        float solde = 0.0F;
        Compte instance = new Compte();
        instance.setSolde(solde);
        assertEquals(solde, instance.getSolde(), 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
