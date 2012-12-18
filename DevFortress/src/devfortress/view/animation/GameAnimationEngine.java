/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.animation;

import com.tabuto.j2dgf.Game2D;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author anhtran
 */
public class GameAnimationEngine extends Game2D {

    private BufferedImage background;

    /**
     * Constructor to create new game animation engine.
     *
     * @param dim
     */
    public GameAnimationEngine(Dimension dim) {
        super(dim);
    }

    @Override
    public void drawStuff(Graphics g) {
        /* Draw background. */
        g.drawImage(background, 0, 0, DIM.width, DIM.height, null);
    }

    @Override
    public void initGame() {
        URL backgroundURL = getClass().getResource("../resources/floors.png");
        try {
            background = ImageIO.read(backgroundURL);
        } catch (Exception ex) {
            Logger.getLogger(GameAnimationEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
