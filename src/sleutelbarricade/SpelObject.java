/**
 * 
 * @author Adeel Ahmad Shani Haq <17019060> & Karam Essabri <15098796>
 */
package sleutelbarricade;

import javax.swing.JLabel;

/**
 *
 * @author adeelhaq
 */
public abstract class SpelObject extends JLabel {

    private final boolean loopbaar;
    
    /**
     *
     * @param loopbaar
     */
    public SpelObject(boolean loopbaar) {
        this.loopbaar = loopbaar;
    }
    
    // Getters en Setters

    /**
     *
     * @return loopbaar
     */
    public boolean getLoopbaar(){
        return loopbaar;
    }
}
