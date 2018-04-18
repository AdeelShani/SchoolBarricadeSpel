/**
 * 
 * @author Adeel Ahmad Shani Haq <17019060> & Karam Essabri <15098796>
 */

package sleutelbarricade.menus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import sleutelbarricade.UI;
import static sleutelbarricade.UI.OBJECTBREEDTE;
import static sleutelbarricade.UI.OBJECTHOOGTE;

/**
 *
 * @author adeelhaq
 */
public class Menu extends JPanel implements ActionListener {
    // Variabelen
    private int breedte = 10 * OBJECTBREEDTE + 5;
    private int hoogte = 10 * OBJECTHOOGTE + 80;
    private Image achtergrond, level1;
    private UI ui;

    // Menu constructor

    /**
     *
     * @param ui
     */
    public Menu(UI ui) {
        achtergrond = new ImageIcon(getClass().getResource("/images/startscherm.png")).getImage();
        level1 = new ImageIcon(getClass().getResource("/images/buttons/level1.png")).getImage();
        this.ui = ui;
        setLayout(null);
        setSize(breedte, hoogte);
        JButton start = new JButton(new ImageIcon(level1));
        start.setSize(160, 55);
        // Plaats het button in het midden
        start.setLocation(breedte/2-(start.getWidth()/2), hoogte/2-(start.getHeight()/2));
        start.addActionListener(this);
        add(start);
    }
    
    // Render/Paint de achtergrond
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(achtergrond, 0, 0, this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ui.plaatsVeld();
        ui.plaatsKnoppen();
    }
}
