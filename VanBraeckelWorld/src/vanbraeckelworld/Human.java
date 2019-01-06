/*
 * Mitchell Van Braeckel
 * 24/10/2016
 * An abstract class which is the abstract class for all the other types of humans (Human->Knight, Wizard, RANGER)
    -> implements the HumanInterface interface class and instantiates all the neccessary characteristics of an abstract Human object
 */

package vanbraeckelworld;

// imports
import TurtleGraphics.*;

abstract public class Human implements HumanInterface {
        // ATTRIBUTES
    protected String name;
    protected int age, health, xPos, yPos;
    protected double height;
        // CONSTRUCTORS
    /**
     * Default Constructor - instantiates a Human w/ default values
     */
    public Human() {
        name = "";
        age = 0;
        health = 0;
        xPos = 0;
        yPos = 0;
        height = 0;
        setNumHumans(NUM_HUMANS+1);     //accumulate #of humans whenever a new human is instantiated
    }
    /**
     * Secondary Constructor - (chained) creates a Human w/ full characteristics
     * @param nom the name of the human
     * @param a the age of the human
     * @param hp the amount of health that the human has
     * @param xLoc the x-coordinate of the human's location/position
     * @param yLoc the x-coordinate of the human's location/position
     * @param h the height of the human (in meters)
     */
    public Human(String nom, int a, int hp, int xLoc, int yLoc, double h) {
        this();
        name = nom;
        age = a;
        health = hp;
        xPos = xLoc;
        yPos = yLoc;
        height = h;
    }
        // BEHAVIOURS
    /**
     * action method - moves a human to a new position
     * @param x the x-coordinate of the new position
     * @param y the y-coordinate of the new position
     */
    public void move(int x, int y) {
        xPos = x;
        yPos = y;
    }
    /**
     * accessor method - retrieves the x-coordinate of a human
     * @return the x-coordinate of the human
     */
    public int getXPos() {
        return xPos;
    }
    /**
     * accessor method - retrieves the y-coordinate of a human
     * @return the y-coordinate of the human
     */
    public int getYPos() {
        return yPos;
    }
    /**
     * accessor method - retrieves the amount of health of a human
     * @return the health of the human
     */
    public int getHealth() {
        return health;
    }
    /**
     * mutator method - sets the health of a human
     * @param hp the new health of a human
     * @return false if value is out of range
     */
    public boolean setHealth(int hp) {
        // checks if the human's new health is within range
        if (!(LOW_HEALTH <= hp && hp <= HIGH_HEALTH)){
            return false;
        }else{
            health = hp;    //sets hp
            return true;
        } // end if
    }
    /**
     * accessor method - retrieves the name of a human
     * @return the name of the human
     */
    public String getName() {
        return name;
    }
    /**
     * mutator method - sets the name of a human
     * @param nom the new name of the human
     */
    public void setName(String nom) {
        name = nom;
    }
    /**
     * accessor method - retrieves the age of a human
     * @return the age of the human
     */
    public int getAge() {
        return age;
    }
    /**
     * mutator method - sets the age of a human
     * @param a the new age of the human
     * @return false if value is out of range
     */
    public boolean setAge(int a) {
        // checks if the human's new age is within range
        if (!(LOW_AGE <= a && a <= HIGH_AGE)){
            return false;
        }else{
            age = a;        //sets age
            return true;
        } // end if
    }
    /**
     * accessor method - retrieves the height (in cm) of a human
     * @return the height of the human (in cm)
     */
    public double getHeight() {
        return height;
    }
    /**
     * mutator method - sets the height(in cm) of a human
     * @param h the new height of a human (in cm)
     * @return false if value is out of range
     */
    public boolean setHeight(double h) {
        // checks if the human's height is within range
        if (!(LOW_HEIGHT <= h && h <= HIGH_HEIGHT)){
            return false;
        }else{
            height = h;     //sets height
            return true;
        } // end if
    }
    /**
     * action method - draws the human body with a given pen
     * @param p the pen to be used to draw to draw the human
     */
    public void draw(Pen p) {
        p.up();                         //lift pen and move to
        p.move(xPos, yPos);             //starting position
        p.down();
        p.setDirection(30);             //primes angle of pen to draw the head
        for (int i = 0; i < 6; i++) {   //draws hexagonal head (from base of neck around)
            p.move(5);
            p.turn(60);
        } // end for loop
        p.move(xPos, yPos - 15);        //draws body torso
        p.up();
        p.move(xPos, yPos);             //reposition @top of torso
        p.down();
        p.move(xPos - 7, yPos - 12);    //draws right arm
        p.up();
        p.move(xPos, yPos);             //reposition @top of torso
        p.down();
        p.move(xPos + 7, yPos - 12);    //draws left arm
        p.up();
        p.move(xPos, yPos - 15);        //reposition @bottom of torso
        p.down();
        p.move(xPos - 3, yPos - 18);    //draws right upper leg
        p.move(xPos - 3, yPos - 33);    //draws right lower leg
        p.up();
        p.move(xPos, yPos - 15);        //goes back to bottom of torso
        p.down();
        p.move(xPos + 3, yPos - 18);    //draws left upper leg
        p.move(xPos + 3, yPos - 33);    //draws left lower leg
    }
    //abstract public boolean equals(HumanTYPE other);
    //public HumanTYPE clone();
    /**
     * retrieves all the info about a human
     * @return a string representation of the human
     */
    public String toString() {
        return  "\nName:\t\t" + name + 
                "\nAge:\t\t" + age + 
                "\nHealth:\t\t" + health +
                "\nHeight:\t\t" + height +
              "cm\nCoordinates:\t(" + xPos + ", " + yPos + ")";
    }
        // ATTRIBUTES - Private Class Variables:
    private final double LOW_HEIGHT = 120;
    private final double HIGH_HEIGHT = 240;
    private final int LOW_AGE = 0;
    private final int HIGH_AGE = 100;
    private final int LOW_HEALTH = 0;
    private final int HIGH_HEALTH = 200;
    private static int NUM_HUMANS = 0;
        // BEHAVIOURS - Public Class Methods:
    /**
     * accessor method - retrieves the #of humans that exist
     * @return the #of humans that exist
     */
    public int getNumHumans() {
        return NUM_HUMANS;
    }
    /**
     * mutator method - sets the #of humans that exist
     * @param num the new #of humans that exist
     */
    public static void setNumHumans(int num) {
        NUM_HUMANS = num;
    }
    /**
     * accessor method - retrieves the age rules
     * @return a string representing the range that the age must be within
     */
    public String getAgeRules() {
        return getRule(LOW_AGE, HIGH_AGE);
    }
    /**
     * accessor method - retrieves the height rules
     * @return a string representing the range that the height must be within
     */
    public String getHeightRules() {
        return getRule(LOW_HEIGHT, HIGH_HEIGHT);
    }
    /**
     * accessor method - retrieves the health rules
     * @return a string representing the range that the health must be within
     */
    public String getHealthRules() {
        return getRule(LOW_HEALTH, HIGH_HEALTH);
    }
    /**
     * retrieves the acceptable range of values for a user entry
     * (used to link w/ specific attribute rule)
     * @param low the minimum of the range
     * @param high the maximum of the range
     * @return a string representation the range
     */
    public static String getRule(double low, double high){        
        return "between " + low + " and  " + high + ", inclusive" ;
    }
} // end Human class
