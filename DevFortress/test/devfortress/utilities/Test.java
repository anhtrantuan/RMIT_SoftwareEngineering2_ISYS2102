/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import devfortress.model.dificulity.GameLevel;
import devfortress.model.dificulity.MediumLevel;
import java.util.List;

/**
 *
 * @author cathoanghuy
 */
public class Test {
    public static void main(String[] args) {
        GameLevel level = new MediumLevel();
        int numberOfProject = 4;
        List result = Utilities.generateProjectList(level, numberOfProject);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        
    }
}
