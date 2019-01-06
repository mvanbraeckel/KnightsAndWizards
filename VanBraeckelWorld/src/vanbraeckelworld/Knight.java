/*
 * Mitchell Van Braeckel
 * 26/10/2016
 * A Knight object extends a Human object, also implementing the HumanInterface interface in the process
 */

package vanbraeckelworld;

// imports
import TurtleGraphics.*;
import java.awt.Color;

public class Knight extends Human{
        // ATTRIBUTES
    private String horseName;
        // CONSTRUCTORS
    /**
     * Default Constructor - instantiates a Knight w/ default values
     */
    public Knight() {
        super();        //activate matching constructor in abstract Human class
        horseName = "";
    }
    /**
     * Secondary Constructor - (chained) creates a Knight w/ full characteristics
     * @param nom the name of the Knight
     * @param a the age of the Knight
     * @param hp the amount of health that the Knight has
     * @param xLoc the x-coordinate of the Knight's location/position
     * @param yLoc the x-coordinate of the Knight's location/position
     * @param h the height of the Knight (in meters)
     * @param horse the name of the Knight's horse
     */
    public Knight(String nom, int a, int hp, int xLoc, int yLoc, double h, String horse) {
        super(nom, a, hp, xLoc, yLoc, h);  //activate matching constructor in abstract Human class
        horseName = horse;
    }
        // BEHAVIOURS
    /**
     * action method - draws a red Knight w/ sword, shield, and horse
     * @param p the pen to be used to draw the red Knight
     */
    public void draw(Pen p) {
        p.setColor(Color.RED);          //set colour to red
        super.draw(p);  //activate matching constructor in Human class -to draw a red human body
            //draws kite shield
        p.up();
        p.move(xPos + 8, yPos - 5);     //reposition @top-left corner of shield
        p.down();
        p.move(xPos + 8, yPos - 28);    //draws left side
        p.move(xPos + 16, yPos - 33);   //draws bottom-left edge
        p.move(xPos + 24, yPos - 28);   //draws bottom-right edge
        p.move(xPos + 24, yPos - 5);    //draws right side
        p.move(xPos + 16, yPos - 2);    //draws top-right edge
        p.move(xPos + 8, yPos - 5);     //draws top-left edge (ends @top-left corner of shield)
            //draws falchion sword
        p.up();
        p.move(xPos - 5, yPos - 14);    //reposition @right hand
        p.down();
        p.move(xPos - 12, yPos - 9);    //draws handle
        p.up();
        p.move(xPos - 15, yPos - 13);   //reposition @left hilt end
        p.down();
        p.move(xPos - 9, yPos - 5);     //draws hilt (from left to right)
        p.move(xPos - 13.5, yPos - 11); //position on hilt (LS)
        p.move(xPos - 30, yPos - 1);    //draws left sword edge
        p.move(xPos - 32, yPos + 5);    //draws sword edge tip
        p.move(xPos - 10.5, yPos - 7);  //position on hilt (RS)
                //draws Knight's horse
            //draws horse head
        p.up();
        p.move(xPos + 63, yPos + 4);    //position @horse head base
        p.down();
        p.move(xPos + 43, yPos - 1);    //draws bottom
        p.move(xPos + 40, yPos + 10);   //draws front
        p.move(xPos + 60, yPos + 15);   //draws top
        p.move(xPos + 63, yPos + 4);    //draws back (ends @horse neck)
            //draws horse neck & body & legs
        p.move(xPos + 70, yPos - 10);   //draws neck
        p.move(xPos + 60, yPos - 33);   //draws front-left leg
        p.move(xPos + 70, yPos - 10);   //reposition @base of neck
        p.move(xPos + 75, yPos - 33);   //draws front-right leg
        p.move(xPos + 70, yPos - 10);   //reposition @base of neck
        p.move(xPos + 100, yPos - 10);  //draws body length
        p.move(xPos + 90, yPos - 33);   //draws back-left leg
        p.move(xPos + 100, yPos - 10);  //reposition @base of tail
        p.move(xPos + 105, yPos - 33);  //draws back-right leg
            //draws horse tail
        p.move(xPos + 100, yPos - 10);  //reposition @base of tail
        p.move(xPos + 110, yPos - 20);  //draws tail length #1
        p.move(xPos + 100, yPos - 10);  //reposition @base of tail
        p.move(xPos + 112, yPos - 19);  //draws tail length #2
    }
    /**
     * mutator method - sets the name of a Knight's horse
     * @param horse the new name of the Knight's horse
     */
    public void setHorse(String horse) {
        horseName = horse; 
    }
    /**
     * accessor method - retrieves the name of a Knight's horse
     * @return the name of the Knight's horse
     */
    public String getHorse() {
        return horseName;
    }
    /**
     * comparator method -- compares two Knights to each other
     * @param other the other Knight being compared
     * @return true if they have the same characteristics (other than coordinates)
     */
    public boolean equals(Knight other) {
        boolean same = false;
        if(other.getName().equals(name) && other.getAge() == age && other.getHeight() == height && other.getHorse().equals(horseName)) {
            same = true;
        } //else (stay false) //end if
        return same;
    }
    /**
     * clone method -- creates an exact copy of a Knight
     * @return a full clone of the Knight
     */
    public Knight clone() {
        return new Knight(getName(), getAge(), getHealth(), getXPos(), getYPos(), getHeight(), getHorse());
    }
    /**
     * retrieves all info about a Knight
     * @return a string representation of the Knight
     */
    public String toString() {
        return    "Class:\t\tKnight" + 
                   super.toString() + 
                "\nHorse Name:\t" + horseName;
    }
} // end Knight class
