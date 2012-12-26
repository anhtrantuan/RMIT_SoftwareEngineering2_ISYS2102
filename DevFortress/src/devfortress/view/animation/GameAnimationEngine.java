/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.animation;

import com.tabuto.j2dgf.Game2D;
import com.tabuto.j2dgf.Group;
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
 * @author anhtran
 */
public class GameAnimationEngine extends Game2D {

    private BufferedImage FLOORS_IMAGE, TABLES_IMAGE, CHAIRS_IMAGE, CHARACTERS_IMAGE;
    private double widthScale, heightScale;
    private Group<GameSprite> sprites;
    private GameSprite floor, table1, table2, table3, table4, table5, chair1,
            chair2, chair3, chair4, chair5, chair4Lean, chair5Lean,
            employee1, employee2, employee3, employee4, employee5;
    private int FLOOR_CROP[] = new int[]{0, 0, 240, 177},
            TABLE_SIZES[] = new int[]{48, 48},
            TABLE_EMPTY_CROP[] = new int[]{480, 0, 48, 48},
            TABLE_BACK_CROP[] = new int[]{0, 0, 48, 48},
            TABLE_FRONT_CROP[] = new int[]{48, 0, 432, 48},
            TABLE_FRONT_SEQUENCE[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8},
            CHAIR_BACK_CROP[] = new int[]{0, 0, 15, 27},
            CHAIR_FRONT_RIGHT_CROP[] = new int[]{15, 0, 15, 27},
            CHAIR_LEAN_CROP[] = new int[]{45, 0, 15, 27},
            EMPLOYEE_SIZES[] = new int[]{20, 30},
            EMPLOYEE1_CROP[] = new int[]{120, 0, 20, 30},
            EMPLOYEE2_CROP[] = new int[]{120, 30, 40, 30},
            EMPLOYEE3_CROP[] = new int[]{120, 60, 40, 30},
            EMPLOYEE4_CROP[] = new int[]{400, 90, 40, 30},
            EMPLOYEE5_CROP[] = new int[]{400, 120, 40, 30},
            EMPLOYEE2_SEQUENCE[] = new int[]{0, 1},
            EMPLOYEE3_SEQUENCE[] = new int[]{0, 1},
            EMPLOYEE4_SEQUENCE[] = new int[]{0, 1},
            EMPLOYEE5_SEQUENCE[] = new int[]{0, 1};

    /**
     * Constructor to create new game animation engine.
     *
     * @param dim
     */
    public GameAnimationEngine(Dimension dim) {
        super(dim);
    }

    /**
     * Draw game canvas.
     *
     * @param g
     */
    @Override
    public void drawStuff(Graphics g) {
        /* Update sprites. */
        sprites.move();

        /* Draw sprites. */
        sprites.draw(g);
    }

    /**
     * Initialize game elements.
     */
    @Override
    public void initGame() {
        try {
            /* Get resource URLs. */
            URL floorsURL = getClass().getResource("../resources/imgFloors.png"),
                    tablesURL = getClass().getResource("../resources/imgTables.png"),
                    chairsURL = getClass().getResource("../resources/imgChairs.png"),
                    charactersURL = getClass().getResource("../resources/imgCharacters.png");

            /* Load resource into place. */
            FLOORS_IMAGE = ImageIO.read(floorsURL);
            TABLES_IMAGE = ImageIO.read(tablesURL);
            CHAIRS_IMAGE = ImageIO.read(chairsURL);
            CHARACTERS_IMAGE = ImageIO.read(charactersURL);

            /* Calculate scale ratios. */
            widthScale = (double) DIM.width / (FLOORS_IMAGE.getWidth(null) / 3);
            heightScale = (double) DIM.height / FLOORS_IMAGE.getHeight(null);

            /* Create sprite group. */
            sprites = new Group<GameSprite>();

            Random random = new Random();

            /* Add sprites. */
            floor = new GameSprite(DIM, 0, 0, FLOORS_IMAGE.getSubimage(
                    FLOOR_CROP[0], FLOOR_CROP[1], FLOOR_CROP[2], FLOOR_CROP[3]));
            floor.setScales(widthScale, heightScale);
            sprites.add(floor);
            chair1 = new GameSprite(DIM, 133, 90, CHAIRS_IMAGE.getSubimage(
                    CHAIR_FRONT_RIGHT_CROP[0], CHAIR_FRONT_RIGHT_CROP[1],
                    CHAIR_FRONT_RIGHT_CROP[2], CHAIR_FRONT_RIGHT_CROP[3]));
            chair1.setScales(widthScale, heightScale);
            sprites.add(chair1);
            employee1 = new GameSprite(DIM, 135, 82, CHARACTERS_IMAGE.getSubimage(
                    EMPLOYEE1_CROP[0], EMPLOYEE1_CROP[1], EMPLOYEE1_CROP[2],
                    EMPLOYEE1_CROP[3]));
            employee1.setScales(widthScale, heightScale);
            sprites.add(employee1);
            table1 = new GameSprite(DIM, 122, 92, TABLES_IMAGE.getSubimage(
                    TABLE_EMPTY_CROP[0], TABLE_EMPTY_CROP[1],
                    TABLE_EMPTY_CROP[2], TABLE_EMPTY_CROP[3]));
            table1.setScales(widthScale, heightScale);
            sprites.add(table1);
            chair2 = new GameSprite(DIM, 295, 146, CHAIRS_IMAGE.getSubimage(
                    CHAIR_FRONT_RIGHT_CROP[0], CHAIR_FRONT_RIGHT_CROP[1],
                    CHAIR_FRONT_RIGHT_CROP[2], CHAIR_FRONT_RIGHT_CROP[3]));
            chair2.setScales(widthScale, heightScale);
            sprites.add(chair2);
            employee2 = new GameSprite(DIM, 293, 141, CHARACTERS_IMAGE.getSubimage(
                    EMPLOYEE2_CROP[0], EMPLOYEE2_CROP[1], EMPLOYEE2_CROP[2],
                    EMPLOYEE2_CROP[3]), EMPLOYEE_SIZES[0], EMPLOYEE_SIZES[1]);
            employee2.setScales(widthScale, heightScale);
            employee2.setFrameSequence(EMPLOYEE2_SEQUENCE);
            employee2.setFrameIndex(random.nextInt(EMPLOYEE2_SEQUENCE.length));
            employee2.setAngleDegree(0);
            employee2.setSpeed(0);
            sprites.add(employee2);
            table2 = new GameSprite(DIM, 280, 150, TABLES_IMAGE.getSubimage(
                    TABLE_BACK_CROP[0], TABLE_BACK_CROP[1], TABLE_BACK_CROP[2],
                    TABLE_BACK_CROP[3]));
            table2.setScales(widthScale, heightScale);
            sprites.add(table2);
            chair3 = new GameSprite(DIM, 202, 194, CHAIRS_IMAGE.getSubimage(
                    CHAIR_FRONT_RIGHT_CROP[0], CHAIR_FRONT_RIGHT_CROP[1],
                    CHAIR_FRONT_RIGHT_CROP[2], CHAIR_FRONT_RIGHT_CROP[3]));
            chair3.setScales(widthScale, heightScale);
            sprites.add(chair3);
            employee3 = new GameSprite(DIM, 202, 189, CHARACTERS_IMAGE.getSubimage(
                    EMPLOYEE3_CROP[0], EMPLOYEE3_CROP[1], EMPLOYEE3_CROP[2],
                    EMPLOYEE3_CROP[3]), EMPLOYEE_SIZES[0], EMPLOYEE_SIZES[1]);
            employee3.setScales(widthScale, heightScale);
            employee3.setFrameSequence(EMPLOYEE3_SEQUENCE);
            employee3.setFrameIndex(random.nextInt(EMPLOYEE3_SEQUENCE.length));
            employee3.setAngleDegree(0);
            employee3.setSpeed(0);
            sprites.add(employee3);
            table3 = new GameSprite(DIM, 187, 198, TABLES_IMAGE.getSubimage(
                    TABLE_BACK_CROP[0], TABLE_BACK_CROP[1], TABLE_BACK_CROP[2],
                    TABLE_BACK_CROP[3]));
            table3.setScales(widthScale, heightScale);
            sprites.add(table3);
            table4 = new GameSprite(DIM, 320, 171, TABLES_IMAGE.getSubimage(
                    TABLE_FRONT_CROP[0], TABLE_FRONT_CROP[1],
                    TABLE_FRONT_CROP[2], TABLE_FRONT_CROP[3]), TABLE_SIZES[0],
                    TABLE_SIZES[1]);
            table4.setScales(widthScale, heightScale);
            table4.setFrameSequence(TABLE_FRONT_SEQUENCE);
            table4.setFrameIndex(random.nextInt(TABLE_FRONT_SEQUENCE.length));
            table4.setAngleDegree(0);
            table4.setSpeed(0);
            sprites.add(table4);
            chair4 = new GameSprite(DIM, 382, 218, CHAIRS_IMAGE.getSubimage(
                    CHAIR_BACK_CROP[0], CHAIR_BACK_CROP[1], CHAIR_BACK_CROP[2],
                    CHAIR_BACK_CROP[3]));
            chair4.setScales(widthScale, heightScale);
            sprites.add(chair4);
            employee4 = new GameSprite(DIM, 369, 195, CHARACTERS_IMAGE.getSubimage(
                    EMPLOYEE4_CROP[0], EMPLOYEE4_CROP[1], EMPLOYEE4_CROP[2],
                    EMPLOYEE4_CROP[3]), EMPLOYEE_SIZES[0], EMPLOYEE_SIZES[1]);
            employee4.setScales(widthScale, heightScale);
            employee4.setFrameSequence(EMPLOYEE4_SEQUENCE);
            employee4.setFrameIndex(random.nextInt(EMPLOYEE4_SEQUENCE.length));
            employee4.setAngleDegree(0);
            employee4.setSpeed(0);
            sprites.add(employee4);
            chair4Lean = new GameSprite(DIM, 382, 218, CHAIRS_IMAGE.getSubimage(
                    CHAIR_LEAN_CROP[0], CHAIR_LEAN_CROP[1], CHAIR_LEAN_CROP[2],
                    CHAIR_LEAN_CROP[3]));
            chair4Lean.setScales(widthScale, heightScale);
            sprites.add(chair4Lean);
            table5 = new GameSprite(DIM, 230, 216, TABLES_IMAGE.getSubimage(
                    TABLE_FRONT_CROP[0], TABLE_FRONT_CROP[1],
                    TABLE_FRONT_CROP[2], TABLE_FRONT_CROP[3]), TABLE_SIZES[0],
                    TABLE_SIZES[1]);
            table5.setScales(widthScale, heightScale);
            table5.setFrameSequence(TABLE_FRONT_SEQUENCE);
            table5.setFrameIndex(random.nextInt(TABLE_FRONT_SEQUENCE.length));
            table5.setAngleDegree(0);
            table5.setSpeed(0);
            sprites.add(table5);
            chair5 = new GameSprite(DIM, 292, 263, CHAIRS_IMAGE.getSubimage(
                    CHAIR_BACK_CROP[0], CHAIR_BACK_CROP[1], CHAIR_BACK_CROP[2],
                    CHAIR_BACK_CROP[3]));
            chair5.setScales(widthScale, heightScale);
            sprites.add(chair5);
            employee5 = new GameSprite(DIM, 279, 240, CHARACTERS_IMAGE.getSubimage(
                    EMPLOYEE5_CROP[0], EMPLOYEE5_CROP[1], EMPLOYEE5_CROP[2],
                    EMPLOYEE5_CROP[3]), EMPLOYEE_SIZES[0], EMPLOYEE_SIZES[1]);
            employee5.setScales(widthScale, heightScale);
            employee5.setFrameSequence(EMPLOYEE5_SEQUENCE);
            employee5.setFrameIndex(random.nextInt(EMPLOYEE5_SEQUENCE.length));
            employee5.setAngleDegree(0);
            employee5.setSpeed(0);
            sprites.add(employee5);
            chair5Lean = new GameSprite(DIM, 292, 263, CHAIRS_IMAGE.getSubimage(
                    CHAIR_LEAN_CROP[0], CHAIR_LEAN_CROP[1], CHAIR_LEAN_CROP[2],
                    CHAIR_LEAN_CROP[3]));
            chair5Lean.setScales(widthScale, heightScale);
            sprites.add(chair5Lean);
        } catch (Exception ex) {
            Logger.getLogger(GameAnimationEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
