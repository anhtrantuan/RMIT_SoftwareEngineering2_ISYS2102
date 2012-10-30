/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress;

import devfortress.utilities.Skills;
import devfortress.utilities.Utilities;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/**
 *
 * @author cathoanghuy
 */
public class DevFortress {

    /**
     * @param args the command line arguments
     */
    static Map<Skills, Integer> skillList; 
    public static void main(String[] args) {
        // TODO code application logic here
        Skills skill = Skills.C;
        Skills skill1 = Skills.ALGORITHMS;
        skillList = new HashMap<Skills,Integer>();
        skillList.put(skill, 10);
        skillList.put(skill1, 10);
        for(Skills sk: skillList.keySet()){
            int point = Utilities.calculateSalaryPoint(sk.ordinal(), skillList.get(sk));
            System.out.println(sk.toString()+" skill: "+point+" : "+sk.ordinal());
        }
        
    }
}
