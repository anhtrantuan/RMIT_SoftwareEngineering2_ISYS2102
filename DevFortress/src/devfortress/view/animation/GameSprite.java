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

    private Image image;
    private int index, sequence[];

    /**
     * Constructor.
     *
     * @param dim
     * @param posX
     * @param posY
     */
    public GameSprite(Dimension dim, double posX, double posY) {
        super(dim, posX, posY);
    }

    /**
     * Draw sprite.
     *
     * @param g
     */
    @Override
    protected void ThisIsMe(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
