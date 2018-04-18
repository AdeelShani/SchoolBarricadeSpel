/**
 * 
 * @author Adeel Ahmad Shani Haq <17019060> & Karam Essabri <15098796>
 */

package sleutelbarricade.menus;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author adeelhaq
 */
public class MenuBar extends JLabel {

    private Image image;
    
    // Menu bar constructor
    public MenuBar() {
        image = new ImageIcon(getClass().getResource("/images/menuAchtergrond.png")).getImage();
        setSize(500, 200);
        setPreferredSize(new Dimension(500, 200));
        setLocation(0, 460);

    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
