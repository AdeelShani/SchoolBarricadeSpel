/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import sleutelbarricade.velden.Veld;
import sleutelbarricade.vakken.WinVak;
import sleutelbarricade.vakken.SleutelVak;
import sleutelbarricade.vakken.Vak;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adeel haq
 */
public class SpelerTest {

    UI ui;
    Veld veld;
    Vak[][] vak;
    WinVak win;
    Speler speler;
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {

    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        ui = new UI();
        veld = new Veld(1, ui);
        vak = new Vak[10][10];
        speler = new Speler(0, 0, veld);
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of getSleutelWaarde method, of class Speler.
     */
    @Test
    public void testGetSleutelWaarde() {
        System.out.println("getSleutelWaarde");

        SleutelVak sleutel = new SleutelVak(vak[0][1], 1);
        speler.setZak(sleutel);
        int expResult = 1;
        int result = speler.getSleutelWaarde(sleutel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
