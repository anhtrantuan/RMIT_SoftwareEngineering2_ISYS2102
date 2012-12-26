/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.view.animation;

import com.tabuto.j2dgf.Sprite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author anhtran
 */
public class GameSprite extends Sprite {

    private double widthScale, heightScale;
    private Image image;
    private int frameWidth, frameHeight, rows, columns, index, sequence[];

    /**
     * Create non-animated sprite.
     *
     * @param dim
     * @param posX
     * @param posY
     * @param image
     */
    public GameSprite(Dimension dim, double posX, double posY, Image image) {
        super(dim, posX, posY);
        widthScale = 1;
        heightScale = 1;
        speed = 0;
        setAngleDegree(0);
        this.image = image;
        frameWidth = image.getWidth(null);
        frameHeight = image.getHeight(null);
        rows = 1;
        columns = 1;
        index = 0;
        sequence = null;
    }

    public GameSprite(Dimension dim, double posX, double posY, Image image,
            int frameWidth, int frameHeight) throws Exception {
        super(dim, posX, posY);

        /* Calculate number of rows and columns. */
        double numRows = (double) image.getHeight(null) / frameHeight,
                numColumns = (double) image.getWidth(null) / frameWidth;

        /* If frame width or height is invalid, throw exception. */
        if (numRows - (int) numRows != 0) {
            throw new Exception("Invalid frame height!");
        }
        if (numColumns - (int) numColumns != 0) {
            throw new Exception("Invalid frame width!");
        }

        /* Else, initialize frame. */
        widthScale = 1;
        heightScale = 1;
        speed = DefaultSpeed;
        this.image = image;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        rows = (int) numRows;
        columns = (int) numColumns;
        index = 0;
        sequence = new int[rows * columns];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = i;
        }
    }

    /**
     * Set size scales.
     *
     * @param widthScale
     * @param heightScale
     */
    public void setScales(double widthScale, double heightScale) {
        this.widthScale = widthScale;
        this.heightScale = heightScale;
    }

    /**
     * Get number of frames.
     *
     * @return
     */
    public int getFrameCount() {
        return rows * columns;
    }

    /**
     * Move sprite and update frame.
     */
    @Override
    public void move() {
        super.move();

        /* If sprite is animated, update sprite. */
        if (getFrameCount() > 1) {
            index++;
            if (index == getFrameCount()) {
                index = 0;
            }
        }
        System.out.println(index);
    }

    /**
     * Draw sprite.
     *
     * @param g
     */
    @Override
    protected void ThisIsMe(Graphics g) {
        if (getFrameCount() > 1) {
            int outputX = (int) (getX() + frameWidth * widthScale),
                    outputY = (int) (getY() + frameHeight * heightScale),
                    sourceX = (sequence[index] % columns) * frameWidth,
                    sourceY = Math.round(sequence[index] / columns) * frameHeight,
                    destinationX = sourceX + frameWidth,
                    destinationY = sourceY + frameHeight;
            g.drawImage(image, (int) getX(), (int) getY(), outputX,
                    outputY, sourceX, sourceY, destinationX, destinationY,
                    null);
        } else {
            g.drawImage(image, (int) getX(), (int) getY(),
                    (int) (frameWidth * widthScale),
                    (int) (frameHeight * heightScale), null);
        }
    }

    /**
     * Set frame index.
     *
     * @param index
     */
    public void setFrameIndex(int index) throws Exception {
        /* If index is outside frame range, throw exception. */
        if (index < 0 || index >= getFrameCount()) {
            throw new Exception("Invalid frame index!");
        }

        /* Else, set new frame index. */
        this.index = index;
    }

    /**
     * Set frame sequence.
     *
     * @param sequence
     */
    public void setFrameSequence(int sequence[]) throws Exception {
        if (getFrameCount() > 1) {
            /* Check all frame indexes in the sequence. */
            for (int i = 0; i < sequence.length; i++) {
                /* If an invalid index found, throw exception. */
                if (sequence[i] < 0 || sequence[i] >= getFrameCount()) {
                    throw new Exception("Invalid frame sequence!");
                }
            }

            /* Else, set new frame sequence and reset index. */
            this.sequence = sequence;
            index = 0;
        }
    }
}
