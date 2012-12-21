/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.animation;

import com.tabuto.j2dgf.Game2D;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
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

    private BufferedImage FLOORS_IMAGE, OBJECTS_IMAGE, CHARACTERS_IMAGE;
    private double widthRatio, heightRatio;
    private int SPRITE_CHARACTER = 1, SPRITE_OBJECT = 2;
//    private int spriteConfigurations[][] = new int[][]{
//        {SPRITE_OBJECT, 50, 36, 65, 63, 17, 2, 32, 29},
//        {SPRITE_CHARACTER, 53, 35, 66, 48, 17, 62, 30, 75}, // Head
//        {SPRITE_CHARACTER, 53, 46, 70, 58, 67, 265, 83, 277}, // Body
//        {SPRITE_OBJECT, 47, 46, 97, 85, 209, 12, 259, 51},
//        {SPRITE_OBJECT, 118, 59, 133, 88, 17, 2, 32, 29},
//        {SPRITE_CHARACTER, 0, 0, 0, 0, 0, 0, 0, 0}, // Head
//        {SPRITE_CHARACTER, 119, 71, 135, 83, 406, 343, 422, 355}, // Body
//        {SPRITE_OBJECT, 114, 63, 164, 109, 107, 5, 157, 51},
//        {SPRITE_OBJECT, 81, 77, 98, 106, 17, 2, 32, 29},
//        {SPRITE_CHARACTER, 0, 0, 0, 0, 0, 0, 0, 0}, // Head
//        {SPRITE_CHARACTER, 0, 0, 0, 0, 0, 0, 0, 0}, // Body
//        {SPRITE_OBJECT, 78, 81, 128, 127, 107, 5, 157, 51},
//        {SPRITE_OBJECT, 130, 71, 180, 117, 158, 5, 208, 51},
//        {SPRITE_OBJECT, 158, 93, 172, 116, 2, 6, 16, 29},
//        {SPRITE_CHARACTER, 0, 0, 0, 0, 0, 0, 0, 0}, // Head
//        {SPRITE_CHARACTER, 0, 0, 0, 0, 0, 0, 0, 0}, // Body
//        {SPRITE_OBJECT, 162, 92, 173, 109, 48, 1, 59, 18},
//        {SPRITE_OBJECT, 94, 89, 144, 135, 158, 5, 208, 51},
//        {SPRITE_OBJECT, 121, 112, 135, 134, 2, 6, 16, 29},
//        {SPRITE_CHARACTER, 0, 0, 0, 0, 0, 0, 0, 0}, // Head
//        {SPRITE_CHARACTER, 0, 0, 0, 0, 0, 0, 0, 0}, // Body
//        {SPRITE_OBJECT, 125, 111, 136, 128, 48, 1, 59, 18}
    private int spriteConfigurations[][] = new int[][]{
        {SPRITE_OBJECT, 0},
        {SPRITE_CHARACTER, 0, 1},
        {SPRITE_OBJECT, 1},
        {SPRITE_OBJECT, 2},
        {SPRITE_CHARACTER, 1, 1},
        {SPRITE_OBJECT, 3},
        {SPRITE_OBJECT, 4},
        {SPRITE_CHARACTER, 2, 1},
        {SPRITE_OBJECT, 5},
        {SPRITE_OBJECT, 6},
        {SPRITE_CHARACTER, 3, 1},
        {SPRITE_OBJECT, 7},
        {SPRITE_OBJECT, 8},
        {SPRITE_OBJECT, 9},
        {SPRITE_CHARACTER, 4, 1},
        {SPRITE_OBJECT, 10},
        {SPRITE_OBJECT, 11}
    }, objectSprites[][] = new int[][]{
        {50, 36, 65, 63, 17, 2, 32, 29},
        {47, 46, 97, 85, 209, 12, 259, 51},
        {118, 59, 133, 88, 17, 2, 32, 29},
        {114, 63, 164, 109, 107, 5, 157, 51},
        {81, 77, 98, 106, 17, 2, 32, 29},
        {78, 81, 128, 127, 107, 5, 157, 51},
        {130, 71, 180, 117, 158, 5, 208, 51},
        {158, 93, 172, 116, 2, 6, 16, 29},
        {162, 92, 173, 109, 48, 1, 59, 18},
        {94, 89, 144, 135, 158, 5, 208, 51},
        {121, 112, 135, 134, 2, 6, 16, 29},
        {125, 111, 136, 128, 48, 1, 59, 18}
    }, characterSprites[][][] = new int[][][]{
        {{53, 35, 66, 48, 17, 62, 30, 75}, {53, 46, 70, 58, 67, 265, 83, 277}},
        {{0, 0, 0, 0, 0, 0, 0, 0}, {119, 71, 135, 83, 406, 343, 422, 355}},
        {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}},
        {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}},
        {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}}
    };

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
        Image image = FLOORS_IMAGE.getScaledInstance(FLOORS_IMAGE.getWidth() * 2, FLOORS_IMAGE.getHeight() * 2, Image.SCALE_SMOOTH);
        g.drawImage(image, 0, 0, null);
//        /* Draw FLOORS_IMAGE. */
//        g.drawImage(FLOORS_IMAGE, 0, 0, DIM.width, DIM.height, 2, 2, 240, 177, null);
//
//        /* Draw OBJECTS_IMAGE. */
//        for (int i = 0; i < spriteConfigurations.length; i++) {
//            int index = spriteConfigurations[i][1];
//            if (spriteConfigurations[i][0] == SPRITE_OBJECT) {
//                g.drawImage(OBJECTS_IMAGE, objectSprites[index][0],
//                        objectSprites[index][1], objectSprites[index][2],
//                        objectSprites[index][3], objectSprites[index][4],
//                        objectSprites[index][5], objectSprites[index][6],
//                        objectSprites[index][7], null);
//            } else {
//                int spriteIndex = spriteConfigurations[i][2];
//                g.drawImage(CHARACTERS_IMAGE, characterSprites[index][0][0],
//                        characterSprites[index][0][1],
//                        characterSprites[index][0][2],
//                        characterSprites[index][0][3],
//                        characterSprites[index][0][4],
//                        characterSprites[index][0][5],
//                        characterSprites[index][0][6],
//                        characterSprites[index][0][7], null);
//                g.drawImage(CHARACTERS_IMAGE,
//                        characterSprites[index][spriteIndex][0],
//                        characterSprites[index][spriteIndex][1],
//                        characterSprites[index][spriteIndex][2],
//                        characterSprites[index][spriteIndex][3],
//                        characterSprites[index][spriteIndex][4],
//                        characterSprites[index][spriteIndex][5],
//                        characterSprites[index][spriteIndex][6],
//                        characterSprites[index][spriteIndex][7], null);
//            }
//        }
    }

    /**
     * Initialize game elements
     */
    @Override
    public void initGame() {
        URL floorsURL = getClass().getResource("../resources/imgFloors.png"),
                objectsURL = getClass().getResource("../resources/imgObjects.png"),
                charactersURL = getClass().getResource("../resources/imgCharacters.png");
        try {
            FLOORS_IMAGE = ImageIO.read(floorsURL);
            OBJECTS_IMAGE = ImageIO.read(objectsURL);
            CHARACTERS_IMAGE = ImageIO.read(charactersURL);
        } catch (Exception ex) {
            Logger.getLogger(GameAnimationEngine.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Calculate scale ratios. */
        widthRatio = (double) DIM.width / 238;
        heightRatio = (double) DIM.height / 175;

        /* Re-calculate sprite sizes. */
        for (int i = 0; i < objectSprites.length; i++) {
            objectSprites[i][0] *= widthRatio;
            objectSprites[i][1] *= heightRatio;
            objectSprites[i][2] *= widthRatio;
            objectSprites[i][3] *= heightRatio;
        }
        for (int i = 0; i < characterSprites.length; i++) {
            for (int j = 0; j < characterSprites[i].length; j++) {
                characterSprites[i][j][0] *= widthRatio;
                characterSprites[i][j][1] *= heightRatio;
                characterSprites[i][j][2] *= widthRatio;
                characterSprites[i][j][3] *= heightRatio;
            }
        }
    }
}
