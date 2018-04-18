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
public class SleutelVak extends SpelObject {

    private int waarde;
    private Image image;
    private static boolean loopbaar = true;

    /**
     *
     * @param vak
     * @param waarde
     */
    public SleutelVak(Vak vak, int waarde) {
        super(loopbaar);
        setImage(waarde);
        this.waarde = waarde;
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
                image = new ImageIcon(getClass().getResource("/images/sleutels/sleutel2.png")).getImage();
                break;
            case 3:
                image = new ImageIcon(getClass().getResource("/images/sleutels/sleutel3.png")).getImage();
                break;
            default:
                image = new ImageIcon(getClass().getResource("/images/sleutels/sleutel1.png")).getImage();
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(waarde), 38, 15);
    }
    
    // Getters en Setters

    /**
     *
     * @return sleutel
     */
    public SleutelVak getSleutel() {
        return this;
    }

    /**
     *
     * @return waarde
     */
    public int getWaarde() {
        return waarde;
    }

    /**
     *
     * @param waarde
     */
    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }
}
