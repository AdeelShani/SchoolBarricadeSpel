/**
 * 
 * @author Adeel Ahmad Shani Haq <17019060> & Karam Essabri <15098796>
 */

package sleutelbarricade.vakken;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import javax.swing.JLabel;
import sleutelbarricade.UI;
import sleutelbarricade.SpelObject;
import sleutelbarricade.velden.Veld;

/**
 *
 * @author adeelhaq
 */
public class Vak extends JLabel {

    private final int BREEDTE = UI.OBJECTBREEDTE;
    private final int HOOGTE = UI.OBJECTHOOGTE;

    private int locatieX, locatieY;
    private Image image;
    private SpelObject spelObject;
    
  
    private Veld veld;
    private boolean loopbaar = true;

    /**
     *
     * @param x
     * @param y
     * @param veld
     */
    public Vak(int x, int y, Veld veld) {
        this.veld = veld;
        image = new ImageIcon(getClass().getResource("/images/vakken/leegVak.png")).getImage();
        this.locatieX = x;
        this.locatieY = y;
        setSize(BREEDTE, HOOGTE);
        setPreferredSize(new Dimension(BREEDTE, HOOGTE));
        setLocation(x, y);
    }

    /**
     *
     * @return veld
     */
    public Veld getVeld() {
        return veld;
    }

    /**
     *
     * @param veld
     */
    public void setVeld(Veld veld) {
        this.veld = veld;
    }

    /**
     *
     * @param spel
     */
    public void removeSpelObject(SpelObject spel) {
        this.remove(spel);
        setSpelObject(null);
        this.loopbaar = true;
        repaint();
    }

    /**
     *
     * @return spelobject
     */
    public SpelObject getSpelObject() {
        return spelObject;
    }

    /**
     *
     * @param spelObject
     */
    public void setSpelObject(SpelObject spelObject) {
        this.spelObject = spelObject;

        if (spelObject != null) {
            this.loopbaar = spelObject.getLoopbaar();
            add(spelObject);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
    
    /**
     *
     * @return loopbaar
     */
    public boolean isLoopbaar() {
        return loopbaar;
    }

}
