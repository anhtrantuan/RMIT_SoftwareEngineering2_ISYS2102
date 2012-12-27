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
public class Holiday extends Game2D {

    private BufferedImage BGR_IMAGE, DANCER_IMAGE;
    private Group<GameSprite> sprites;
    private double widthScale, heightScale;
    private GameSprite bgr, dancer1, dancer2;
    private int DANCER_SEQUENCE[] = new int[]{0, 1, 2};
    private int[] dancerSize = {28, 62};
    private long timestamp = 0;

    public Holiday(Dimension dim) {
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
        sprites.add(dancer1);
        sprites.add(dancer2);

        try {
            dancer1.setFrameIndex(0);
            dancer2.setFrameIndex(0);
        } catch (Exception ex) {
            Logger.getLogger(Holiday.class.getName()).log(Level.SEVERE, null, ex);
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
            URL bgrURL = getClass().getResource("../../resources/imgoliday.png"),
                    dancerURL = getClass().getResource("../../resources/imgDancer.png");

            BGR_IMAGE = ImageIO.read(bgrURL);
            DANCER_IMAGE = ImageIO.read(dancerURL);
            widthScale = (double) DIM.width / BGR_IMAGE.getWidth(null);
            heightScale = (double) DIM.height / BGR_IMAGE.getHeight(null);
            sprites = new Group<GameSprite>();

            /* Add sprites. */
            bgr = new GameSprite(DIM, 0, 0, BGR_IMAGE);
            bgr.setScales(widthScale, heightScale);
            sprites.add(bgr);

            dancer1 = new GameSprite(DIM, 223 * widthScale, 90 * heightScale, DANCER_IMAGE, dancerSize[0], dancerSize[1]);
            dancer1.setScales(widthScale, heightScale);
            dancer1.setFrameSequence(DANCER_SEQUENCE);
            dancer1.setFrameIndex(0);
            dancer1.setAngleDegree(0);
            dancer1.setSpeed(0);
            sprites.add(dancer1);

            dancer2 = new GameSprite(DIM, 332 * widthScale, 98 * heightScale, DANCER_IMAGE, dancerSize[0], dancerSize[1]);
            dancer2.setScales(widthScale, heightScale);
            dancer2.setFrameSequence(DANCER_SEQUENCE);
            dancer2.setFrameIndex(0);
            dancer2.setAngleDegree(0);
            dancer2.setSpeed(0);
            sprites.add(dancer2);
        } catch (Exception ex) {
            Logger.getLogger(Holiday.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
