/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import sleutelbarricade.velden.Veld;
import sleutelbarricade.vakken.WinVak;
import sleutelbarricade.vakken.Vak;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adeel Haq
 */
public class VeldTest {

    UI ui;
    Veld veld;
    Vak[][] vak;
    WinVak win;
    Speler speler;

    /**
     *
     */
    public VeldTest() {
    }

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
         win = new WinVak(0, 0, veld);
         speler = new Speler(0, 0, veld);
        veld.addVakjes();
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of levelReset method, of class Veld.
     */
    @Test
    public void testLevelreset() {
        System.out.println("levelreset");
        int level = 1;
        veld.levelReset(level);
        boolean expectedSpeler = speler == null;
        boolean expectedFinish = win == null;
        boolean expectedVak = veld.getVak(0, 0) == null;
        int resultBlokken = veld.getAantalVakken();
        int expectedBlokken = 10;
        assertEquals(expectedSpeler, false);
        assertEquals(expectedFinish, false);
        assertEquals(expectedVak, false);
        assertEquals(expectedBlokken, resultBlokken);
    }

    /**
     * Test of removeVakken method, of class Veld.
     */
    @Test
    public void testRemoveVakken() {
        System.out.println("removeVakken");
        veld.removeVakken();
        int expResult = 0;
        int result=0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
              
               if(veld.getVak(i,j) != null){
                   result++;
               }
            }
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of setHuidigeLevel method, of class Veld.
     */
    @Test
    public void testSetHuidigeLevel() {
        System.out.println("setHuidigeLevel");
        int huidigeLevel = 1;
        veld.setHuidigeLevel(huidigeLevel);
        int expResult = 1;
        int result = veld.getHuidigeLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
