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
import javax.swing.JLabel;
import sleutelbarricade.UI;
import sleutelbarricade.velden.Veld;

/**
 *
 * @author adeelhaq
 */
public class WinVak  extends JLabel {

    private Image image;
    private Veld veld;

    /**
     *
     * @param x
     * @param y
     * @param veld
     */
    public WinVak(int x, int y, Veld veld) {
        this.veld = veld;
        image = new ImageIcon(getClass().getResource("/images/vakken/winVak.png")).getImage();
        setLocation(x, y);
        setSize(UI.OBJECTBREEDTE, UI.OBJECTHOOGTE);
        setPreferredSize(new Dimension(UI.OBJECTBREEDTE, UI.OBJECTHOOGTE));
        veld.add(this);
    }

    /**
     * Check if win
     */
    public void checkWinvak() {
        if (veld.getSpeler().getX() == getX() && veld.getSpeler().getY() == getY()) {
            veld.toonMelding("Level voltooid!");
            
            if (veld.getHuidigeLevel() < veld.getLevels().length) {
                veld.levelReset(veld.getHuidigeLevel() + 1);
            } else {
                veld.getUi().backMenu();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 7, 10, this);
//        g.setColor(Color.WHITE);
//        g.drawString("", 8, 10);
    }
}
