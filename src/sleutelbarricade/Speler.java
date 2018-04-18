/**
 * 
 * @author Adeel Ahmad Shani Haq <17019060> & Karam Essabri <15098796>
 */
package sleutelbarricade;

import sleutelbarricade.velden.Veld;
import sleutelbarricade.vakken.Barricade;
import sleutelbarricade.vakken.SleutelVak;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author adeelhaq
 */
public class Speler extends JLabel {
    
    private int frame;
    private SleutelVak zak;
    private final int BREEDTE = UI.OBJECTBREEDTE;
    private final int HOOGTE = UI.OBJECTHOOGTE;

    private final int[] locatie = new int[2];
    private Image image;

    private Veld veld;

    /**
     *
     * @param x
     * @param y
     * @param veld
     */
    public Speler(int x, int y, Veld veld) {
        this.veld = veld;
        image = new ImageIcon(getClass().getResource("/images/speler/speler_d1.png")).getImage();
        veld.add(this);
//        setLayout(null);
        // Locatie van het speler
        locatie[0] = x;
        locatie[1] = y;
        setSize(BREEDTE, HOOGTE);
        setLocation(x, y);

    }
    
    /**
     *
     * @param veld
     * @param k
     * @param l
     */
    public void openBarricade(Veld veld, int k, int l) {
        int x = locatie[0] / 50;
        int y = locatie[1] / 50;
        if ( x < 9 && x > 0 && y < 9 && y > 0 && veld.getVak(x + k, y + l).getSpelObject() instanceof Barricade) { // instantie van barricade
            if (getSleutelWaarde(zak) == ((Barricade)veld.getVak(x + k, y + l).getSpelObject()).getWaarde()) {      //vergelijk sleutelwaarde - barricadewaarde
                veld.toonMelding("Je hebt barricade nummer " + ((Barricade)veld.getVak(x + k, y + l).getSpelObject()).getWaarde() + " geopend");
                veld.getVak(x + k, y + l).removeSpelObject(veld.getVak(x + k, y + l).getSpelObject());
                veld.getVak(x + k, y + l).repaint();
            } else if (getSleutelWaarde(zak) == 0) {
                veld.toonMelding("Je hebt geen sleutel in zak");
            } else {
                veld.toonMelding("Verkeerde sleutel");
            }
        }
    }

    /**
     *
     * @param veld
     */
    public void pakSleutel(Veld veld) {
        int x = locatie[0] / 50;
        int y = locatie[1] / 50;
        if (veld.getVak(x, y).getSpelObject() instanceof SleutelVak) {
            veld.toonMelding("Je hebt sleutel nummer " + ((SleutelVak)veld.getVak(x, y).getSpelObject()).getWaarde() + " opgepakt");
            setZak((SleutelVak)veld.getVak(x, y).getSpelObject());
            veld.getVak(x, y).remove(veld.getVak(x, y).getSpelObject());
            veld.getVak(x, y).setSpelObject(null);
            veld.getVak(x, y).repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 5, 5, this);
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(getSleutelWaarde(zak)), 20, 15);
    }

    /**
     * Speler rechts
     */
    public void rechts() {
        openBarricade(veld, 1, 0);
        int x = locatie[0] / 50;
        int y = locatie[1] / 50;
        if (x < 9 && veld.getVak(x + 1, y).isLoopbaar()) {
            switch (frame) {
                case 0:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_r1.png")).getImage());
                    frame++;
                    break;
                case 1:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_r2.png")).getImage());
                    frame++;
                    break;
                case 2:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_r3.png")).getImage());
                    frame++;
                    break;
                default:
                    frame = 0;
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_r2.png")).getImage());
                    break;
            }
            lopen(UI.OBJECTBREEDTE, 0);
        }

    }

    /**
     * Speler links
     */
    public void links() {
        openBarricade(veld, -1, 0);
        int x = locatie[0] / 50;
        int y = locatie[1] / 50;

        if (x > 0 && veld.getVak(x - 1, y).isLoopbaar()) {
            switch (frame) {
                case 0:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_l1.png")).getImage());
                    frame++;
                    break;
                case 1:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_l2.png")).getImage());
                    frame++;
                    break;
                case 2:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_l3.png")).getImage());
                    frame++;
                    break;
                default:
                    frame = 0;
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_l2.png")).getImage());
                    break;
            }
            lopen(-UI.OBJECTBREEDTE, 0);

        }

    }

    /**
     * Speler omHoog
     */
    public void omHoog() {
        openBarricade(veld, 0, -1);
        int x = locatie[0] / 50;
        int y = locatie[1] / 50;

        if (y > 0 && veld.getVak(x, y - 1).isLoopbaar()) {
            switch (frame) {
                case 0:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_u1.png")).getImage());
                    frame++;
                    break;
                case 1:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_u2.png")).getImage());
                    frame++;
                    break;
                case 2:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_u3.png")).getImage());
                    frame++;
                    break;
                default:
                    frame = 0;
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_u2.png")).getImage());
                    break;
            }
            lopen(0, -UI.OBJECTBREEDTE);

        }
    }
  
    /**
     * Speler omlaag
     */
    public void omLaag() {
        openBarricade(veld, 0, 1);
        int x = locatie[0] / 50;
        int y = locatie[1] / 50;

        if (y < 9 && veld.getVak(x, y + 1).isLoopbaar()) {
            switch (frame) {
                case 0:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_d1.png")).getImage());
                    frame++;
                    break;
                case 1:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_d2.png")).getImage());
                    frame++;
                    break;
                case 2:
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_d3.png")).getImage());
                    frame++;
                    break;
                default:
                    frame = 0;
                    setImage(new ImageIcon(getClass().getResource("/images/speler/speler_d2.png")).getImage());
                    break;
            }

            lopen(0, UI.OBJECTBREEDTE);

        }
    }
    
    // Getters en Setter

    /**
     *
     * @return image
     */
    public Image getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     *
     * @return zak
     */ 
    public SleutelVak getZak() {
        return zak;
    }

    /**
     *
     * @param zak
     */
    public void setZak(SleutelVak zak) {
        this.zak = zak;
    }

    /**
     *
     * @return locatie
     */
    public int[] getLocatie() {
        return locatie;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setLocatie(int x, int y) {
        locatie[0] = x;
        locatie[1] = y;
        setLocation(locatie[0], locatie[1]);
        revalidate();
        repaint();
    }

    /**
     *
     * @param x
     * @param y
     */
    public void lopen(int x, int y) {
        setLocatie(locatie[0] + x, locatie[1] + y);

    }

    /**
     *
     * @return false
     */
    public boolean check() {
        return false;
    }

    /**
     *
     * @param sleutel
     */
    public int getSleutelWaarde(SleutelVak sleutel) {
        if (sleutel == null) {
            return 0;
        } else {
            return zak.getWaarde();
        }
    }
}
