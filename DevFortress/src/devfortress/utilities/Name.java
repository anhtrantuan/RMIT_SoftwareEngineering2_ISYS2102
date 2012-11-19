/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devfortress.utilities;

import java.util.Random;

/**
 *
 * @author cathoanghuy
 */
public class Name {

    private static String[] employeeName = {"Jacob", "Michael", "Ethan", "Joshua",
        "Daniel", "Alexander", "Anthony", "William", "Christopher", "Emma",
        "Isabella", "Emily", "Madison", "Ava", "Olivia", "Sophia"};
    private static String[] projectName = {"Fakebook Module", "Itube Video Sharing",
        "Re OSX", "Uphone Application",};

    public static String getEmployeeName() {
        Random random = new Random();
        return employeeName[random.nextInt(employeeName.length)];
    }

    public static String getProjectName() {
        Random random = new Random();
        return projectName[random.nextInt(projectName.length)];
    }
}