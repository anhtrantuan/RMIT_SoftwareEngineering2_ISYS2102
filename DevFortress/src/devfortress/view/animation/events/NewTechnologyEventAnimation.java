/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.animation.events;

import com.tabuto.j2dgf.Game2D;
import com.tabuto.j2dgf.Group;
import devfortress.view.animation.GameSprite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Sherlock
 */
public class NewTechnologyEventAnimation extends Game2D {

    private BufferedImage BGR_IMAGE, MC_IMAGE;
    private Group<GameSprite> sprites;
    private double widthScale, heightScale;
    private GameSprite bgr, mc;
    private int MC_SEQUENCE[] = new int[]{0, 0, 0, 1, 1, 1};
    private long timestamp = 0;

    public NewTechnologyEventAnimation(Dimension dim) {
        super(dim);
    }

    /**
     * Activate/Re-activate this engine.
     */
    @Override
    public void activate() {
        super.activate();
    }

    /**
     * Deactivate this engine and reset it to original state.
     */
    @Override
    public void deactivate() {
        super.deactivate();
        timestamp = 0;
        sprites.clear();
        sprites.add(bgr);
        sprites.add(mc);
        try {
            mc.setFrameIndex(0);
        } catch (Exception ex) {
            Logger.getLogger(NewTechnologyEventAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void drawStuff(Graphics g) {
        sprites.move();

        /* Draw sprites. */
        if (!sprites.isEmpty()) {
            sprites.draw(g);
        }
    }

    @Override
    public void initGame() {
        try {
            /* Get resource URLs. */
            URL mcURL = getClass().getResource("../../resources/imgMC.png"),
                    bgrURL = getClass().getResource("../../resources/imgNewTechnologyBackground.png");

            /* Load resource into place. */
            BGR_IMAGE = ImageIO.read(bgrURL);
            MC_IMAGE = ImageIO.read(mcURL);

            /* Calculate scale ratios. */
            widthScale = (double) DIM.width / BGR_IMAGE.getWidth(null);
            heightScale = (double) DIM.height / BGR_IMAGE.getHeight(null);

            /* Create sprite group. */
            sprites = new Group<GameSprite>();

            /* Add sprites. */
            bgr = new GameSprite(DIM, 0, 0, BGR_IMAGE);
            bgr.setScales(widthScale, heightScale);
            sprites.add(bgr);

            mc = new GameSprite(DIM, 163 * widthScale, 4 * heightScale,
                    MC_IMAGE, 26, 24);
            mc.setScales(widthScale, heightScale);
            mc.setFrameSequence(MC_SEQUENCE);
            mc.setFrameIndex(0);
            mc.setAngleDegree(0);
            mc.setSpeed(0);
            sprites.add(mc);
        } catch (Exception ex) {
            Logger.getLogger(NewTechnologyEventAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
