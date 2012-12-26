/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.animation.events;

import com.tabuto.j2dgf.Game2D;
import com.tabuto.j2dgf.Group;
import devfortress.view.animation.GameAnimationEngine;
import devfortress.view.animation.GameSprite;
import java.awt.Color;
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
    private int DOC_TALKING_SPRITE1[] = new int[]{0, 0, 207, 104},
            DOC_TALKING_SPRITE2[] = new int[]{0, 111, 207, 88},
            DEV_SEQUENCE[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10},
            DOC_SEQUENCE[] = new int[]{3, 2, 1, 0};
    private long timestamp = 0;

    /**
     * Constructor to create new game sick event animation.
     *
     * @param dim
     */
    public DeveloperIsSickEventAnimation(Dimension dim) {
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
        sprites.add(floor);
        sprites.add(dev);
        try {
            dev.setFrameIndex(0);
        } catch (Exception ex) {
            Logger.getLogger(DeveloperIsSickEventAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void drawStuff(Graphics g) {
        /*
         * Update sprites.
         */
        sprites.move();

        if (timestamp == 0 && dev.getFrameIndex() == DEV_SEQUENCE.length - 1) {
            sprites.clear();
            g.setColor(Color.black);
            g.fillRect(0, 0, DIM.width, DIM.height);
            timestamp = System.currentTimeMillis();
        }

        if (timestamp != 0 && System.currentTimeMillis() >= timestamp + 1000) {
//            g.clearRect(0, 0, DIM.width, DIM.height);
            try {
                sprites.add(floor);
                bed = new GameSprite(DIM, 10, 10, BED_IMAGE);
                bed.setScales(3, 3);
                sprites.add(bed);

                doctor = new GameSprite(DIM, 496, 20, DOCTOR_IMAGE, 16, 30);
                doctor.setScales(3, 3);
                doctor.setFrameSequence(DOC_SEQUENCE);
                doctor.setFrameIndex(3);
                doctor.setAngleDegree(0);
                doctor.setSpeed(30);
                sprites.add(doctor);
            } catch (Exception ex) {
                Logger.getLogger(DeveloperIsSickEventAnimation.class.getName()).log(Level.SEVERE, null, ex);
            }
            timestamp = -1;
        }
//        if (doctor!=null) {
//            System.out.println("move");
//            doctor.moveTo(bed);
//            doctor.move();
//        }
//        System.out.println("after moving");
        /*
         * Draw sprites.
         */
        if (!sprites.isEmpty()) {
            System.out.println("draw");
            sprites.draw(g);
        }
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
            FLOORS_IMAGE = ImageIO.read(floorsURL);
            BED_IMAGE = ImageIO.read(bedURL);
            DEV_IMAGE = ImageIO.read(devURL);
            DOCTOR_IMAGE = ImageIO.read(doctorURL);
            DOCTOR_TALKING_IMAGE = ImageIO.read(doctorTalkingURL);

            /*
             * Calculate scale ratios.
             */
            widthScale = (double) DIM.width / FLOORS_IMAGE.getWidth(null);
            heightScale = (double) DIM.height / FLOORS_IMAGE.getHeight(null);

            /*
             * Create sprite group.
             */
            sprites = new Group<GameSprite>();

            Random random = new Random();

            /*
             * Add sprites.
             */
            floor = new GameSprite(DIM, 0, 0, FLOORS_IMAGE);
            floor.setScales(widthScale, heightScale);
            sprites.add(floor);

            dev = new GameSprite(DIM, 100, 100, DEV_IMAGE, 24, 30);
            dev.setScales(3, 3);
            dev.setFrameSequence(DEV_SEQUENCE);
            dev.setFrameIndex(0);
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
