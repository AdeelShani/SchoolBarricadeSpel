/**
 * 
 * @author Adeel Ahmad Shani Haq <17019060> & Karam Essabri <15098796>
 */

package sleutelbarricade.velden;

import sleutelbarricade.vakken.Barricade;
import sleutelbarricade.vakken.WinVak;
import sleutelbarricade.vakken.VasteMuur;
import sleutelbarricade.vakken.SleutelVak;
import sleutelbarricade.vakken.Vak;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sleutelbarricade.UI;
import sleutelbarricade.Speler;

/**
 *
 * @author adeelhaq
 */
public class Veld extends JPanel implements KeyListener, ActionListener {

    private final int DIM = UI.OBJECTBREEDTE;
    private final int aantalVakken = 10;
    private final int BREEDTE = aantalVakken * UI.OBJECTBREEDTE ;
    private final int HOOGTE = aantalVakken * UI.OBJECTHOOGTE;
    private Vak[][] vak;
    private Speler speler;
    private UI ui;
    private WinVak win;
    private int huidigeLevel = 1;
    
    private String lv = "LeegVak";
    private String vm = "VasteMuur";
    private String s1 = "sleutel1";
    private String s2 = "sleutel2";
    private String s3 = "sleutel3";
    private String b1 = "barricade1";
    private String b2 = "barricade2";
    private String b3 = "barricade3";
    private String wv = "finish";
    private String sp = "speler";
    private String[][] spelMap;
    
    // Levels
    private final String[][][] levels = {
        {
        {sp, vm, b1, lv, lv, lv, lv, b3, b2, b1},
        {lv, lv, lv, lv, s1, s3, lv, b3, b2, b1},
        {lv, lv, b1, lv, lv, lv, lv, b3, b3, s1},
        {lv, vm, b1, lv, lv, lv, lv, b2, b2, b2},
        {lv, vm, b1, b1, vm, vm, vm, b2, b2, b2},
        {lv, b2, b1, lv, lv, lv, vm, b2, b3, lv},
        {lv, vm, b1, vm, vm, b3, vm, vm, lv, lv},
        {lv, vm, b1, b3, b1, b1, b2, lv, lv, lv},
        {s2, vm, b1, b3, b1, lv, b1, vm, lv, lv},
        {lv, vm, b1, b3, lv, lv, lv, vm, lv, wv}
        },
        
        {
        {vm, vm, vm, vm, vm, vm, vm, vm, vm, vm},
        {vm, lv, vm, s1, b1, lv, b2, b1, b1, vm},
        {vm, lv, vm, lv, vm, lv, b1, vm, b1, vm},
        {vm, s3, vm, lv, vm, b3, s3, vm, b1, vm},
        {vm, lv, b3, lv, vm, lv, b3, vm, b2, vm},
        {vm, lv, b1, lv, b3, b3, vm, vm, b2, vm},
        {vm, s2, vm, vm, vm, s3, vm, vm, b3, vm},
        {vm, lv, vm, b1, b2, b1, b2, vm, b3, vm},
        {vm, sp, s1, b1, s2, s2, b1, vm, wv, vm},
        {vm, vm, vm, vm, vm, vm, vm, vm, vm, vm}
        },
        
        {
        {sp, lv, lv, lv, lv, lv, lv, lv, lv, lv},
        {lv, lv, vm, lv, b1, lv, vm, b1, s1, lv},
        {lv, lv, vm, b1, vm, lv, b1, b2, b2, lv},
        {lv, lv, vm, wv, vm, lv, lv, vm, lv, lv},
        {lv, lv, vm, lv, vm, lv, b3, s3, vm, lv},
        {lv, lv, vm, lv, b3, lv, vm, lv, b3, lv},
        {lv, s1, vm, vm, vm, lv, vm, lv, b2, lv},
        {lv, lv, vm, b1, b1, b1, b2, lv, b2, lv},
        {lv, lv, b1, b1, b1, s2, b1, lv, vm, lv},
        {lv, lv, lv, lv, lv, lv, lv, lv, lv, lv}
        }
    };
    
    // Veld constructor

    /**
     *
     * @param level
     * @param ui
     */
    public Veld(int level, UI ui) {
        init();
        huidigeLevel(level);
        this.ui = ui;
        initMethodes(speler);
        setVisible(true);
    }
    
    // Initialiseer methoden
    private void initMethodes(Speler speler) {
        vak = new Vak[aantalVakken][aantalVakken];
        addSpeler(speler);
        addWinvak(win);
        addVakjes();
    }
    // Initialiseer venster
    private void init() {
        setFocusable(true);
        addKeyListener(this);
        setLayout(null);
        setSize(BREEDTE, HOOGTE);
    }
    
    // Huidige lelvel = 1
    private void huidigeLevel(int level) {
        huidigeLevel = level;
        spelMap = levels[level-1];
    }
    
    /**
     *
     * @param level
     */
    public void levelReset(int level) {
        this.spelMap = levels[level-1];
        
        huidigeLevel = level;
        removeVakken();
        remove(speler);
        remove(win);
        initMethodes(speler);
        repaint();
        setFocusable(true);

    }

    /**
     * Verwijder vakken
     */
    public void removeVakken() {
        for (int x = 0; x < aantalVakken; x++) {
            for (int y = 0; y < aantalVakken; y++) {
                remove(vak[x][y]);
                vak[x][y] = null;
            }
        }
    }

    /**
     *
     * @param message
     */
    public void toonMelding(String message) {
        JOptionPane jOptionPane = new JOptionPane(CENTER_ALIGNMENT);
        JOptionPane.showMessageDialog(this, message);
    }

    //IN FOR LOOP MB

    /**
     *
     * @param x
     * @param y
     */
    public void addSleutels(int x, int y) {
        if (spelMap[y][x].equals(s1)) {
            SleutelVak sleutel = new SleutelVak(vak[y][x], 1);
            vak[x][y].setSpelObject(sleutel);
        } else if (spelMap[y][x].equals(s2)) {
            SleutelVak sleutel = new SleutelVak(vak[y][x], 2);
            vak[x][y].setSpelObject(sleutel);
        } else if (spelMap[y][x].equals(s3)) {
            SleutelVak sleutel = new SleutelVak(vak[y][x], 3);
            vak[x][y].setSpelObject(sleutel);
        }
    }

    /**
     *
     * @param x
     * @param y
     */
    public void addBarricade(int x, int y) {
        if (spelMap[y][x].equals(b1)) {
            Barricade barricade = new Barricade(vak[y][x], 1);
            vak[x][y].setSpelObject(barricade);
        } else if (spelMap[y][x].equals(b2)) {
            Barricade barricade = new Barricade(vak[y][x], 2);
            vak[x][y].setSpelObject(barricade);
        } else if (spelMap[y][x].equals(b3)) {
            Barricade barricade = new Barricade(vak[y][x], 3);
            vak[x][y].setSpelObject(barricade);
        }
    }

    /**
     *
     * @param speler
     */
    public void addSpeler(Speler speler) {
        speler = new Speler(DIM, DIM, this);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (spelMap[y][x].equals(sp)) {
                    speler.setLocatie(x * DIM, y * DIM);
                }
            }
        }
        this.speler = speler;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void addMuren(int x, int y) {
        if (spelMap[y][x].equals(vm)) {
            VasteMuur muur = new VasteMuur(vak[y][x]);
            vak[x][y].setSpelObject(muur);
            //vak[x][y].getSpelObject().setVasteMuur(muur);
        }
    }

    /**
     *
     * @param x
     * @param y
     */
    public void addSpelObjecten(int x, int y) {
        addBarricade(x, y);
        addSleutels(x, y);
        addMuren(x, y);
    }

    /**
     * Vakjes toevoegen
     */
    public void addVakjes() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                vak[x][y] = new Vak(x * DIM, y * DIM, this);
                add(vak[x][y]);
                repaint();
                addSpelObjecten(x, y);
            }
        }
    }

    /**
     *
     * @param win
     */
    public void addWinvak(WinVak win) {
        win = new WinVak(DIM, DIM, this);
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (spelMap[y][x].equals(wv)) {
                    win.setLocation(x * DIM, y * DIM);
                }
            }
        }
        this.win = win;
    }


    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        int keyCode = ke.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                speler.rechts();
                win.checkWinvak();
                break;
            case KeyEvent.VK_LEFT:
                speler.links();
                win.checkWinvak();
                break;
            case KeyEvent.VK_UP:
                speler.omHoog();
                win.checkWinvak();
                break;
            case KeyEvent.VK_DOWN:
                speler.omLaag();
                win.checkWinvak();
                break;
            case KeyEvent.VK_SPACE:
                speler.pakSleutel(this);
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
    
    // Getters en Setters

    /**
     *
     * @return aantalVakken
     */
    public int getAantalVakken() {
        return aantalVakken;
    }

    /**
     *
     * @return ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     *
     * @param huidigeLevel
     */
    public void setHuidigeLevel(int huidigeLevel) {
        this.huidigeLevel = huidigeLevel;
    }

    /**
     *
     * @return huidigeLevel
     */
    public int getHuidigeLevel() {
        return huidigeLevel;
    }

    /**
     *
     * @return BREEDTE
     */
    public int getBREEDTE() {
        return BREEDTE;
    }

    /**
     *
     * @return HOOGTE
     */
    public int getHOOGTE() {
        return HOOGTE;
    }

    /**
     *
     * @return speler
     */
    public Speler getSpeler() {
        return speler;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Vak getVak(int x, int y) {
        return vak[x][y];
    }

    /**
     *
     * @param x
     * @param y
     * @param vak
     */
    public void setVak(int x, int y, Vak vak) {
        this.vak[x][y] = vak;
    }
    
    /**
     *
     * @return levels
     */
    public String[][][] getLevels() {
        return levels;
    }
}
