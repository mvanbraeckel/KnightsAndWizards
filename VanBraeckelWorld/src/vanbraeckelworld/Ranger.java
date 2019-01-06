/*
 * Mitchell Van Braeckel
 * 27/10/2016
 * A RANGER object extends a Human object, also implementing the HumanInterface interface in the process
 */

package vanbraeckelworld;

// imports
import TurtleGraphics.*;
import java.awt.Color;

public class Ranger extends Human{
        // ATTRIBUTES
    private int numArrows;
        // CONSTRUCTORS
    /**
     * Default Constructor - instantiates a Ranger w/ default values
     */
    public Ranger() {
        super();        //activate matching constructor in abstract Human class
        numArrows = 0;
    }
    /**
     * Secondary Constructor - (chained) creates a Ranger w/ full characteristics
     * @param nom the name of the Ranger
     * @param a the age of the Ranger
     * @param hp the amount of health that the Ranger has
     * @param xLoc the x-coordinate of the Ranger's location/position
     * @param yLoc the x-coordinate of the Ranger's location/position
     * @param h the height of the Ranger (in meters)
     * @param arrows the number of arrows that a Ranger has
     */
    public Ranger(String nom, int a, int hp, int xLoc, int yLoc, double h, int arrows) {
        super(nom, a, hp, xLoc, yLoc, h);  //activate matching constructor in abstract Human class
        numArrows = arrows;
    }
        // BEHAVIOURS
    /**
     * action method - draws a green Ranger w/ a bow and quiver full of arrows
     * @param p the pen to be used to draw the green Ranger
     */
    public void draw(Pen p) {
        p.setColor(Color.GREEN);        //set colour to green
        super.draw(p);  //activate matching constructor in Human class -to draw a green human body
                //draws bow
            //draws bowstring
        p.up();
        p.move(xPos, yPos - 22);        //position @bottom-end string
        p.down();
        p.move(xPos + 6, yPos - 2);     //draws bowstring (ends @top-end string)
            //draws bow
        p.setDirection(-15);            //primes angle of pen to draw the bow
        for (int i = 0; i < 18; i++) {  //draws semi-circle-ish part of the bow
            p.move(2);
            p.turn(-11);
        } // end for loop
                //draws arrow
            //draws shaft
        p.up();
        p.move(xPos - 11, yPos - 22);   //reposition @bottom-end arrow
        p.down();
        p.move(xPos - 7, yPos - 3);     //draws arrow (ends @top-end arrow)
            //draws arrowhead
        p.move(xPos - 8.5, yPos - 4.5); //draws left side
        p.move(xPos - 5.5, yPos - 5);   //draws bottom side
        p.move(xPos - 7, yPos - 3);     //draws right side (ends @top-end arrow)
            //draws fletching
        p.move(xPos - 11, yPos - 20);   //reposition @bottom-end arrow
        p.move(xPos - 16, yPos - 23);   //draws left side
        p.move(xPos - 11, yPos - 20);   //reposition @bottom-end arrow
        p.move(xPos - 9, yPos - 25);    //draws right side
    }
    /**
     * mutator method - shooting an arrow uses up 1 arrows
     * @return false if the Ranger doesn't have enough arrows
     */
    public boolean shootArrow(){
        return setArrows(numArrows-1); //calls the method to change the numArrows value
    }
    /**
     * mutator method - sets the number of arrows that a Ranger has
     * @param arrows the new number of arrows that the Ranger has
     * @return false if value is out of range
     */
    public boolean setArrows(int arrows) {
        // checks if the Ranger's new numArrows is within range
        if (!(LOW_ARROWS <= arrows && arrows <= HIGH_ARROWS)){
            return false;
        }else{
            numArrows = arrows;    //sets #of arrows
            return true;
        } // end if
    }
    /**
     * accessor method - retrieves the number of arrows that a Ranger has
     * @return the number of arrows that the Ranger has
     */
    public int getNumArrows() {
        return numArrows;
    }
    /**
     * comparator method -- compares two Rangers to each other
     * @param other the other Ranger being compared
     * @return true if they have the same characteristics (other than coordinates)
     */
    public boolean equals(Ranger other) {
        boolean same = false;
        if(other.getName().equals(name) && other.getAge() == age && other.getHeight() == height) {
            same = true;
        } //else (stay false) //end if
        return same;
    }
    /**
     * clone method -- creates an exact copy of a Ranger
     * @return a full clone of the Ranger
     */
    public Ranger clone() {
        return new Ranger(getName(), getAge(), getHealth(), getXPos(), getYPos(), getHeight(), getNumArrows());
    }
    /**
     * retrieves all info about a Ranger
     * @return a string representation of the Ranger
     */
    public String toString() {
        return    "Class:\t\tRanger" + 
                   super.toString() +   //activate matching method in abstract Human class"Class:\tKnight\n" + 
                "\nArrows Left:\t" + numArrows;
    }
    // ATTRIBUTES - Public Class Variables:
    public final int LOW_ARROWS = 0;
    public final int HIGH_ARROWS = 200;
    // BEHAVIOURS - Public Class Methods:
    /**
     * accessor method - retrieves the arrow rules
     * @return a string representing the range that the number of arrows must be within
     */
    public String getArrowRules() {
        return getRule(LOW_ARROWS, HIGH_ARROWS);
    }
} // end RANGER class
