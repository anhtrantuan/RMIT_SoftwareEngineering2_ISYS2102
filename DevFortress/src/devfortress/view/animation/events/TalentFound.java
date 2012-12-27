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
public class TalentFound extends Game2D {

    private BufferedImage FLOORS_IMAGE, DEV_IMAGE, TABLES_IMAGE, CHAIRS_IMAGE, PROS_SPRITE_IMAGE, PROS_TALKING_IMAGE;
    private Group<GameSprite> sprites;
    private double widthScale, heightScale;
    private GameSprite floor, dev, table, chair, pros_talking, pros;
    private int TABLE_SIZES[] = new int[]{48, 48},
            TABLE_BACK_CROP[] = new int[]{0, 0, 48, 48},
            TABLE_SEQUENCE[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8},
            EMPLOYEE_SIZES[] = new int[]{20, 30},
            EMPLOYEE2_CROP[] = new int[]{120, 30, 40, 30},
            EMPLOYEE3_SEQUENCE[] = new int[]{0, 1},
            CHAIR_FRONT_RIGHT_CROP[] = new int[]{15, 0, 15, 27},
            PROS_TALKING_SEQUENCE[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    /**
     * Constructor to create new game sick event animation.
     *
     * @param dim
     */
    public TalentFound(Dimension dim) {
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

        try {
            sprites.clear();
            dev.setFrameIndex(0);
            sprites.add(floor);
            sprites.add(chair);
            sprites.add(dev);
            sprites.add(table);
            sprites.add(pros);
            sprites.add(pros_talking);

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
        /*
         * Draw sprites.
         */
        sprites.draw(g);

    }

    @Override
    public void initGame() {
        try {
            /*
             * Get resource URLs.
             */
            URL floorURL = getClass().getResource("../../resources/imgSickFloor.png"),
                    tableURL = getClass().getResource("../../resources/imgTables.png"),
                    chairURL = getClass().getResource("../../resources/imgChairs.png"),
                    devURL = getClass().getResource("../../resources/imgCharacters.png"),
                    prosURL = getClass().getResource("../../resources/imgProsSprite.png"),
                    prosTalkingURL = getClass().getResource("../../resources/imgProsTalking.png");

            /*
             * Load resource into place.
             */

            FLOORS_IMAGE = ImageIO.read(floorURL);
            DEV_IMAGE = ImageIO.read(devURL);
            TABLES_IMAGE = ImageIO.read(tableURL);
            CHAIRS_IMAGE = ImageIO.read(chairURL);
            PROS_SPRITE_IMAGE = ImageIO.read(prosURL);
            PROS_TALKING_IMAGE = ImageIO.read(prosTalkingURL);

            sprites = new Group<GameSprite>();

            widthScale = (double) DIM.width / FLOORS_IMAGE.getWidth(null);
            heightScale = (double) DIM.height / FLOORS_IMAGE.getHeight(null);

            floor = new GameSprite(DIM, 0, 0, FLOORS_IMAGE);
            floor.setScales(widthScale, heightScale);
            sprites.add(floor);

            chair = new GameSprite(DIM, 370, 50, CHAIRS_IMAGE.getSubimage(
                    CHAIR_FRONT_RIGHT_CROP[0], CHAIR_FRONT_RIGHT_CROP[1],
                    CHAIR_FRONT_RIGHT_CROP[2], CHAIR_FRONT_RIGHT_CROP[3]));
            chair.setScales(widthScale * 2.5, heightScale * 2.5);
            sprites.add(chair);

            dev = new GameSprite(DIM, 368, 45, DEV_IMAGE.getSubimage(
                    EMPLOYEE2_CROP[0], EMPLOYEE2_CROP[1], EMPLOYEE2_CROP[2],
                    EMPLOYEE2_CROP[3]), EMPLOYEE_SIZES[0], EMPLOYEE_SIZES[1]);
            dev.setScales(widthScale * 2.5, heightScale * 2.5);
            dev.setFrameSequence(EMPLOYEE3_SEQUENCE);
            dev.setAngleDegree(0);
            dev.setSpeed(0);
            sprites.add(dev);

            table = new GameSprite(DIM, 355, 54, TABLES_IMAGE.getSubimage(
                    TABLE_BACK_CROP[0], TABLE_BACK_CROP[1], TABLE_BACK_CROP[2],
                    TABLE_BACK_CROP[3]));
            table.setScales(widthScale * 2.5, heightScale * 2.5);
            sprites.add(table);

            pros = new GameSprite(DIM, 328, 45, PROS_SPRITE_IMAGE);
            pros.setScales(widthScale * 2.5, heightScale * 2.5);
            sprites.add(pros);

            pros_talking = new GameSprite(DIM, 2, 2, PROS_TALKING_IMAGE, 287, 110);
            pros_talking.setScales(widthScale * 1.2, heightScale * 1.2);
            pros_talking.setFrameSequence(PROS_TALKING_SEQUENCE);
            pros_talking.setAngleDegree(0);
            pros_talking.setSpeed(0);
            sprites.add(pros_talking);

        } catch (Exception ex) {
            Logger.getLogger(DeveloperIsSickEventAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
