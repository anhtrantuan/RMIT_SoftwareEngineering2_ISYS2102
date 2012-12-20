
import devfortress.view.dialogs.BuyItemPanel;
import java.io.IOException;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sherlock
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        JFrame f = new JFrame();
        BuyItemPanel panel = new BuyItemPanel();
        panel.setSize(600, 300);
        panel.setVisible(true);
        f.add(panel);
        f.setSize(600, 300);
        f.setVisible(true);
    }
}
