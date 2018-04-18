/**
 * 
 * @author Adeel Ahmad Shani Haq <17019060> & Karam Essabri <15098796>
 */

package sleutelbarricade.vakken;

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
public class VasteMuur extends SpelObject {

    private static boolean loopbaar = false;
    private Image image;

    /**
     *
     * @param vak
     */
    public VasteMuur(Vak vak) {
        super(loopbaar);
        image = new ImageIcon(getClass().getResource("/images/vakken/vasteMuur.png")).getImage();
        setLocation(0, 0);
        setSize(UI.OBJECTBREEDTE, UI.OBJECTBREEDTE);
        setPreferredSize(new Dimension(UI.OBJECTHOOGTE, UI.OBJECTBREEDTE));
        setVisible(true);
    }
    
    /**
     *
     * @return loopbaar
     */
    public boolean getLoopbaar(){
        return loopbaar;
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
