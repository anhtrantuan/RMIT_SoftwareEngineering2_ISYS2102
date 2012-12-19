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

    private BufferedImage background, objects;
    private double widthRatio, heightRatio;
    private int objectConfigurations[][] = new int[][]{
        {50, 35, 67, 64, 16, 1, 33, 30}, // Sprite goes here
        {45, 45, 97, 86, 208, 11, 260, 52},
        {116, 60, 133, 89, 16, 1, 33, 30}, // Sprite goes here
        {111, 62, 163, 110, 106, 4, 158, 52},
        {80, 78, 97, 107, 16, 1, 33, 30}, // Sprite goes here
        {75, 80, 127, 128, 106, 4, 158, 52},
        {127, 70, 179, 118, 157, 4, 209, 52},
        {156, 92, 172, 117, 1, 5, 17, 30}, // Sprite goes here
        {161, 92, 172, 109, 48, 1, 59, 18},
        {91, 88, 143, 136, 157, 4, 209, 52},
        {120, 110, 136, 135, 1, 5, 17, 30}, // Sprite goes here
        {125, 110, 136, 127, 48, 1, 59, 18}
    };

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

        /* Draw objects. */
        for (int i = 0; i < objectConfigurations.length; i++) {
            g.drawImage(objects, objectConfigurations[i][0],
                    objectConfigurations[i][1], objectConfigurations[i][2],
                    objectConfigurations[i][3], objectConfigurations[i][4],
                    objectConfigurations[i][5], objectConfigurations[i][6],
                    objectConfigurations[i][7], null);
        }
    }

    @Override
    public void initGame() {
        URL backgroundURL = getClass().getResource("../resources/imgBackground.png"),
                objectsURL = getClass().getResource("../resources/imgObjects.png");
        try {
            background = ImageIO.read(backgroundURL);
            objects = ImageIO.read(objectsURL);
        } catch (Exception ex) {
            Logger.getLogger(GameAnimationEngine.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Calculate scale ratios. */
        widthRatio = (double) DIM.width / background.getWidth();
        heightRatio = (double) DIM.height / background.getHeight();

        /* Re-calculate objects' sizes. */
        for (int i = 0; i < objectConfigurations.length; i++) {
            objectConfigurations[i][0] *= widthRatio;
            objectConfigurations[i][1] *= heightRatio;
            objectConfigurations[i][2] *= widthRatio;
            objectConfigurations[i][3] *= heightRatio;
        }
    }
}
