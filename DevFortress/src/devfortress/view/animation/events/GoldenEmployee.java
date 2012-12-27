/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.animation.events;

import com.tabuto.j2dgf.Game2D;
import com.tabuto.j2dgf.Group;
import devfortress.view.animation.GameSprite;
import java.awt.Color;
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
public class GoldenEmployee extends Game2D implements EventAnimationEngine {

    private BufferedImage GOLDEN_ANNOUNCEMENT_IMAGE, SATAN_IMAGE;
    private Group<GameSprite> sprites;
    private double widthScale, heightScale;
    private GameSprite announcement, satan;
    private long timestamp = 0;
    private boolean firstScreen = true;

    public GoldenEmployee(Dimension dim) {
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
        sprites.clear();
        sprites.add(announcement);
        timestamp = 0;
        firstScreen = true;
    }

    @Override
    public void drawStuff(Graphics g) {
        sprites.move();
        try {
            if (firstScreen) {
                timestamp = System.currentTimeMillis();
                firstScreen = false;
            }
            if (System.currentTimeMillis() >= timestamp + 2000 && timestamp != 0) {
                sprites.clear();
                sprites.add(satan);
                timestamp = 0;
            }
            if (!sprites.isEmpty()) {
                sprites.draw(g);
            }
        } catch (Exception ex) {
            Logger.getLogger(DeveloperIsSickEventAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
         * Draw sprites.
         */
        if (!sprites.isEmpty()) {
            sprites.draw(g);
        }
    }

    @Override
    public void initGame() {
        URL announcementURL = getClass().getResource("../../resources/imgGoldenEmpAnnouncement.png"),
                satanURL = getClass().getResource("../../resources/imgSatan.png");
        try {
            GOLDEN_ANNOUNCEMENT_IMAGE = ImageIO.read(announcementURL);
            SATAN_IMAGE = ImageIO.read(satanURL);
            widthScale = (double) DIM.width / GOLDEN_ANNOUNCEMENT_IMAGE.getWidth(null);
            heightScale = (double) DIM.height / GOLDEN_ANNOUNCEMENT_IMAGE.getHeight(null);
            sprites = new Group<GameSprite>();

            /*
             * Add sprites.
             */
            announcement = new GameSprite(DIM, 0, 0, GOLDEN_ANNOUNCEMENT_IMAGE);
            satan = new GameSprite(DIM, 0, 0, SATAN_IMAGE);
            announcement.setScales(widthScale, heightScale);
            satan.setScales(widthScale, heightScale);
            sprites.add(announcement);
            timestamp = 0;
        } catch (Exception ex) {
            Logger.getLogger(FeatureCut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getInformation() {
        return "One golden employee with nearly maximum skill is available to hire";
    }
}
