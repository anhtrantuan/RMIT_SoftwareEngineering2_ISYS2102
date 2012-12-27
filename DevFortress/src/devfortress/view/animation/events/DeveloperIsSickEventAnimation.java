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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Sherlock
 */
public class DeveloperIsSickEventAnimation extends Game2D implements EventAnimationEngine{

    private BufferedImage FLOORS_IMAGE, BED_IMAGE, DEV_IMAGE, DOCTOR_IMAGE, DOCTOR_TALKING_IMAGE;
    private Group<GameSprite> sprites;
    private double widthScale, heightScale;
    private GameSprite dev, doctor, bed, doctor_talking, floor;
    private int DOC_TALKING_CROP1[] = new int[]{0, 0, 207, 104},
            DOC_TALKING_CROP2[] = new int[]{0, 111, 207, 88},
            DEV_SEQUENCE[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10, 10},
            DOC_TALKING_SEQUENCE[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0,
                                                1, 1, 1, 1, 1, 1, 1, 1, 1},
            DOC_MOVING_CROP[] = new int[]{48, 0, 16, 30};
    private long timestamp = 0;
    private boolean isWaiting = false;
    private boolean firstScreen = true;
    private boolean secondScreen = true;

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
        isWaiting = false;
        firstScreen = true;
        secondScreen = true;
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
        try {
            if (timestamp == 0 && dev.getFrameIndex() == DEV_SEQUENCE.length - 1 && firstScreen) {
                sprites.clear();
                g.setColor(Color.black);
                g.fillRect(0, 0, DIM.width, DIM.height);
                timestamp = System.currentTimeMillis();
                firstScreen = false;
            }

            if (timestamp != 0 && System.currentTimeMillis() >= timestamp + 1000 && isWaiting != true) {
                sprites.add(floor);
                sprites.add(bed);
                sprites.add(doctor);
                isWaiting = true;
            }

            if (timestamp != 0 && System.currentTimeMillis() >= timestamp + 1500 && secondScreen) {
                sprites.add(doctor_talking);
                secondScreen = false;
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

    }

    @Override
    public void initGame() {
        try {
            /*
             * Get resource URLs.
             */
            URL floorsURL = getClass().getResource("../../resources/imgSickFloor.png"),
                    bedURL = getClass().getResource("../../resources/imgSickBed.png"),
                    devURL = getClass().getResource("../../resources/imgSick.png"),
                    doctorURL = getClass().getResource("../../resources/imgDoctorMoving.png"),
                    doctorTalkingURL = getClass().getResource("../../resources/imgDoctorTalking.png");

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

            bed = new GameSprite(DIM, 10, 10, BED_IMAGE);
            bed.setScales(3, 3);
            doctor = new GameSprite(DIM, 108, 35, DOCTOR_IMAGE.getSubimage(
                    DOC_MOVING_CROP[0], DOC_MOVING_CROP[1], DOC_MOVING_CROP[2], DOC_MOVING_CROP[3]));
            doctor.setScales(3, 3);
            doctor_talking = new GameSprite(DIM, 200, 50, DOCTOR_TALKING_IMAGE, 207, 104);
            doctor_talking.setScales(1.5, 1.5);
            doctor_talking.setFrameIndex(0);
            doctor_talking.setAngleDegree(0);
            doctor_talking.setSpeed(0);
            doctor_talking.setFrameSequence(DOC_TALKING_SEQUENCE);

        } catch (Exception ex) {
            Logger.getLogger(DeveloperIsSickEventAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getInformation(){
        return "Employee is sick. His work drops a half";
    }
}
