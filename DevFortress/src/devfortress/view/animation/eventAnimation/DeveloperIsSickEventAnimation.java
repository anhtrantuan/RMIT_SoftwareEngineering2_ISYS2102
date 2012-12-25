/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.animation.eventAnimation;

import com.tabuto.j2dgf.Game2D;
import com.tabuto.j2dgf.Group;
import com.tabuto.j2dgf.Sprite;
import devfortress.view.animation.GameAnimationEngine;
import devfortress.view.animation.GameSprite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;
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
    private double widthScale, heightScale;
    private GameSprite dev, doctor, bed, doctor_talking, floor;
    private int FLOOR_CROP[] = new int[]{0, 0, 569, 219},
            DEV_SPRITE[] = new int[]{0, 0, 220, 30},
            DOC_SPRITE[] = new int[]{0, 0, 16, 30},
            DOC_TALKING_SPRITE1[] = new int[]{0, 0, 207, 104},
            DOC_TALKING_SPRITE2[] = new int[]{0, 111, 207, 88},
            DEV_SEQUENCE[] = new int[]{0, 1,2,3,4,5,6,7,8,9,10};

    /**
     * Constructor to create new game sick event animation.
     *
     * @param dim
     */
    public DeveloperIsSickEventAnimation(Dimension dim) {
        super(dim);
    }

    @Override
    public void drawStuff(Graphics g) {
        /*
         * Update sprites.
         */
        sprites.move();

        /*
         * Draw sprites.
         */
        sprites.draw(g);
        System.out.println("Draw sprite");
    }

    @Override
    public void initGame() {
        try {
            /*
             * Get resource URLs.
             */

            URL floorsURL = getClass().getResource("../../resources/sick_floor.png"),
                    bedURL = getClass().getResource("../../resources/sickbed.png"),
                    devURL = getClass().getResource("../../resources/sick.png"),
                    doctorURL = getClass().getResource("../../resources/doctor_moving.png"),
                    doctorTalkingURL = getClass().getResource("../../resources/doctor_talking.png");
            /*
             * Load resource into place.
             */
            //FLOORS_IMAGE = ImageIO.read(getClass().getResourceAsStream("../../resources/sick_floor.png"));
            FLOORS_IMAGE = ImageIO.read(floorsURL);
            BED_IMAGE = ImageIO.read(bedURL);
            DEV_IMAGE = ImageIO.read(devURL);
            DOCTOR_IMAGE = ImageIO.read(doctorURL);
            DOCTOR_TALKING_IMAGE = ImageIO.read(doctorTalkingURL);

            /*
             * Calculate scale ratios.
             */
            widthScale = (double) DIM.width / (FLOORS_IMAGE.getWidth(null));
            heightScale = (double) DIM.height / FLOORS_IMAGE.getHeight(null);

            /*
             * Create sprite group.
             */
            sprites = new Group<GameSprite>();

            Random random = new Random();

            /*
             * Add sprites.
             */
            floor = new GameSprite(DIM, 0, 0, FLOORS_IMAGE.getSubimage(
                    FLOOR_CROP[0], FLOOR_CROP[1], FLOOR_CROP[2], FLOOR_CROP[3]));
            floor.setScales(widthScale, heightScale);
            sprites.add(floor);

            dev = new GameSprite(DIM, 50, 50, DEV_IMAGE.getSubimage(DEV_SPRITE[0], DEV_SPRITE[1],
                    DEV_SPRITE[2], DEV_SPRITE[3]),20,30);
            dev.setScales(3, 3);
            dev.setFrameSequence(DEV_SEQUENCE);
            dev.setFrameIndex(DEV_SEQUENCE[0]);
            dev.setAngleDegree(0);
            dev.setSpeed(0);
            sprites.add(dev);

//            chair1 = new GameSprite(DIM, 133, 90, CHAIRS_IMAGE.getSubimage(
//                    CHAIR_FRONT_RIGHT_CROP[0], CHAIR_FRONT_RIGHT_CROP[1],
//                    CHAIR_FRONT_RIGHT_CROP[2], CHAIR_FRONT_RIGHT_CROP[3]));
//            chair1.setScales(widthScale, heightScale);
//            sprites.add(chair1);
        } catch (Exception ex) {
            Logger.getLogger(GameAnimationEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
