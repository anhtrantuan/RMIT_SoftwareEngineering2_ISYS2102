/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.animation.eventAnimation;

import com.tabuto.j2dgf.Game2D;
import com.tabuto.j2dgf.Group;
import devfortress.view.animation.GameAnimationEngine;
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
public class DeveloperIsSickEventAnimation extends Game2D {

    private BufferedImage FLOORS_IMAGE, BED_IMAGE, DEV_IMAGE, DOCTOR_IMAGE, DOCTOR_TALKING_IMAGE;
    private Group<GameSprite> sprites;
    private GameSprite dev, doctor, bed, doctor_talking;
//    private int FLOOR_CROP[] = new int[]{0, 0, 240, 177},
//            DEV_SPRITE[] = new int[]{480, 0, 48, 48},
//            DOC_SPRITE[] = new int[]{480, 0, 48, 48},
//            DOC_TALKING_SPRITE[] = new int[]{480, 0, 48, 48};

    public DeveloperIsSickEventAnimation(Dimension dim) {
        super(dim);
    }

    @Override
    public void drawStuff(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void initGame() {
        try {
            /*
             * Get resource URLs.
             */
            URL floorsURL = getClass().getResource("../resources/imgFloors.png"),
                    bedURL = getClass().getResource("../resources/sickbed.png"),
                    devURL = getClass().getResource("../resources/sick.png"),
                    doctorURL = getClass().getResource("../resources/doctor_moving.png"),
                    doctorTalkingURL = getClass().getResource("../resources/doctor_talking.png");
            /*
             * Load resource into place.
             */
            FLOORS_IMAGE = ImageIO.read(floorsURL);
            BED_IMAGE = ImageIO.read(bedURL);
            DEV_IMAGE = ImageIO.read(devURL);
            DOCTOR_IMAGE = ImageIO.read(doctorURL);
            DOCTOR_TALKING_IMAGE = ImageIO.read(doctorTalkingURL);
        } catch (Exception ex) {
            Logger.getLogger(GameAnimationEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
