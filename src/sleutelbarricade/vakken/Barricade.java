/**
 * 
 * @author Adeel Ahmad Shani Haq <17019060> & Karam Essabri <15098796>
 */

package sleutelbarricade.vakken;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import sleutelbarricade.UI;
import sleutelbarricade.SpelObject;

/**
 *
 * @author adeelhaq
 */
public class Barricade extends SpelObject {

    private int waarde;
    private Image image;
    private static boolean loopbaar = false;

    /**
     *
     * @param vak
     * @param waarde
     */
    public Barricade(Vak vak, int waarde) {
        super(loopbaar);
        setImage(waarde);
        this.waarde = waarde;
        setText(Integer.toString(waarde));
        setSize(UI.OBJECTBREEDTE, UI.OBJECTHOOGTE);
        setPreferredSize(new Dimension(UI.OBJECTBREEDTE, UI.OBJECTHOOGTE));
    }

    /**
     *
     * @param waarde
     */
    public void setImage(int waarde) {
        switch (waarde) {
            case 2:
                image = new ImageIcon(getClass().getResource("/images/barricades/barricade2.png")).getImage();
                break;
            case 3:
                image = new ImageIcon(getClass().getResource("/images/barricades/barricade3.png")).getImage();
                break;
            default:
                image = new ImageIcon(getClass().getResource("/images/barricades/barricade1.png")).getImage();
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
        g.setColor(Color.BLUE);
        g.drawString(Integer.toString(waarde), 38, 15);
    }
    
    // Getters en Setters

    /**
     *
     * @return waarde
     */
    public int getWaarde() {
        return waarde;
    }
    
    /**
     *
     * @return loopbaar
     */
    @Override
    public boolean getLoopbaar(){
        return loopbaar;
    }

    /**
     *
     * @param waarde
     */
    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }
}
