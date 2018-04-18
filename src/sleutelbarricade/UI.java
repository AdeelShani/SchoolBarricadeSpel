/**
 * 
 * @author Adeel Ahmad Shani Haq <17019060> & Karam Essabri <15098796>
 */
package sleutelbarricade;

import sleutelbarricade.menus.Menu;
import sleutelbarricade.menus.MenuBar;
import sleutelbarricade.velden.Veld;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author adeelhaq
 */
public class UI extends JFrame implements ActionListener {
    
    // Varaibelen
    public static final int OBJECTBREEDTE = 50;
    public static final int OBJECTHOOGTE = 50;
    private final int BREEDTE = 10 * OBJECTBREEDTE;
    private final int HOOGTE = 10 * OBJECTHOOGTE + 80;
    private Image resetImage, menuImage;
    private Veld veld;
    private JButton resetBtn, menuBtn;
    private Menu Menu;
    private MenuBar menuBar;
        
    // Frame aanmaken

    public UI() {
        setTitle("Sleutelbarricade");
        setLayout(null);
        startMenu();
        setSize(BREEDTE, HOOGTE);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    // Veld tonen op het frame
    public void plaatsVeld() {
        veld = new Veld(1, this);
        add(veld);
        remove(Menu);
        revalidate();
        repaint();
    }

    // Menu toevoegen aan het frame
    public void startMenu() {
        Menu = new Menu(this);
        add(Menu);
    }
    
    // Terug naar menu
    public void backMenu() {
        Menu = new Menu(this);
        add(Menu);
        remove(veld);
        remove(menuBtn);
        remove(resetBtn);
        remove(menuBar);
        revalidate();
        repaint();
    }
    
    // Main method

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        UI ui = new UI();
    }
    
    // Buttons plaatsen
    public void plaatsKnoppen() {
        // Reset button plaatsen
        menuBar = new MenuBar();
        resetImage = new ImageIcon(getClass().getResource("/images/buttons/resetBtn.png")).getImage();
        resetBtn = new JButton(new ImageIcon(resetImage));
        resetBtn.setPreferredSize(new Dimension(125, 35));
        resetBtn.setSize(159, 46);
        resetBtn.setLocation(BREEDTE / 6, HOOGTE - HOOGTE / 8);
        resetBtn.setFocusable(false);
        resetBtn.addActionListener(this);
        add(resetBtn);
        // Menu button plaatsen
        menuImage = new ImageIcon(getClass().getResource("/images/buttons/menuBtn.png")).getImage();
        menuBtn = new JButton(new ImageIcon(menuImage));
        menuBtn.setSize(159, 46);
        menuBtn.setLocation(BREEDTE - (BREEDTE / 6 + 150), HOOGTE - HOOGTE / 8);
        menuBtn.setFocusable(false);
        menuBtn.addActionListener(this);
        add(menuBtn);
        add(menuBar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Bepalen wat er moet gebeuren als op reset button gedrukt wordt
        if (e.getSource() == resetBtn) {
            veld.levelReset(veld.getHuidigeLevel());
        } else if (e.getSource() == menuBtn) {
            backMenu();
        }
    }
}
