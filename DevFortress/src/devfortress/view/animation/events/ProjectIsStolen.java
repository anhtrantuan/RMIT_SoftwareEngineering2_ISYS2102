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
public class ProjectIsStolen extends Game2D{
    
    private BufferedImage STEAL_IMAGE, STOLEN_ANNOUNCEMENT_IMAGE;
    private Group<GameSprite> sprites;
    private double widthScale, heightScale;
    private GameSprite steal, announcement;
    private long timestamp = 0;
    private boolean firstScreen=true;

    public ProjectIsStolen(Dimension dim) {
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
        sprites.add(steal);
        timestamp = 0;
        firstScreen = true;
    }

    @Override
    public void drawStuff(Graphics g) {
        sprites.move();
        try {
            if(firstScreen){
                timestamp = System.currentTimeMillis();
                firstScreen = false;
            }
            if (System.currentTimeMillis() >= timestamp + 2000  && timestamp !=0) {
                sprites.clear();
                sprites.add(announcement);
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
        URL announcementURL = getClass().getResource("../../resources/imgStolen1.png"),
                satanURL = getClass().getResource("../../resources/imgStolen2.png");
        try {
            STEAL_IMAGE = ImageIO.read(announcementURL);
            STOLEN_ANNOUNCEMENT_IMAGE = ImageIO.read(satanURL);
            widthScale = (double) DIM.width / STEAL_IMAGE.getWidth(null);
            heightScale = (double) DIM.height / STEAL_IMAGE.getHeight(null);
            sprites = new Group<GameSprite>();

            /*
             * Add sprites.
             */
            steal = new GameSprite(DIM, 0, 0, STEAL_IMAGE);
            announcement = new GameSprite(DIM, 0, 0, STOLEN_ANNOUNCEMENT_IMAGE);
            steal.setScales(widthScale, heightScale);
            announcement.setScales(widthScale, heightScale);
            sprites.add(steal);
            timestamp = 0;
        } catch (Exception ex) {
            Logger.getLogger(FeatureCut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getInformation(){
        return "An employee stole the project, deleted all backup,"
                + " the project has failed, the employee has left company";
    }
}
