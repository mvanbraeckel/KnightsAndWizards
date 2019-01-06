/*
 * Mitchell Van Braeckel
 * 24/10/2016
 * A Wizard object extends a Human object, also implementing the HumanInterface interface in the process
 */

package vanbraeckelworld;

// imports
import TurtleGraphics.*;
import java.awt.Color;

public class Wizard extends Human{
        // ATTRIBUTES
    private int magicka;
        // CONSTRUCTORS
    /**
     * Default Constructor - instantiates a Wizard w/ default values
     */
    public Wizard() {
        super();        //activate matching constructor in abstract Human class
        magicka = 0;
    }
    /**
     * Secondary Constructor - (chained) creates a Wizard w/ full characteristics
     * @param nom the name of the Wizard
     * @param a the age of the Wizard
     * @param hp the amount of health that the Wizard has
     * @param xLoc the x-coordinate of the Wizard's location/position
     * @param yLoc the x-coordinate of the Wizard's location/position
     * @param h the height of the Wizard (in meters)
     * @param mp the amount of mana that a Wizard has
     */
    public Wizard(String nom, int a, int hp, int xLoc, int yLoc, double h, int mp) {
        super(nom, a, hp, xLoc, yLoc, h);  //activate matching constructor in abstract Human class
        magicka = mp;
    }
        // BEHAVIOURS
    /**
     * action method - draws a blue Wizard w/ a hat and staff
     * @param p the pen to be used to draw the blue Wizard
     */
    public void draw(Pen p) {
        p.setColor(Color.BLUE);         //set colour to blue
        super.draw(p);  //activate matching constructor in Human class -to draw a blue human body
            //draws wizard hat
        p.up();
        p.move(xPos - 7, yPos + 7);     //reposition @bottom left corner of hat
        p.down();
        p.move(xPos + 7, yPos + 7);     //draws base
        p.move(xPos, yPos + 20);        //draws right side
        p.move(xPos - 7, yPos + 7);     //draws left side (ends @bottom-left corner of hat)
            //draws magic staff
        p.up();
        p.move(xPos - 8, yPos - 33);    //reposition @bottom of staff
        p.down();
        p.move(xPos - 8, yPos - 5);     //draws the length of the staff (ends @top of staff)
            //draws staff's magic orb
        p.setDirection(30);             //primes angle of pen to draw the head
        for (int i = 0; i < 6; i++) {   //draws hexagonal head (from base of neck around)
            p.move(3);
            p.turn(60);
        } // end for loop
    }
    /**
     * mutator method - casting a spell uses 10 magicka
     * @return false if the wizard doesn't have enough magicka
     */
    public boolean castSpell(){
        return setMagicka(magicka-10); //calls the method to change the magicka value
    }
    /**
     * mutator method - sets the magicka of a wizard
     * @param mp the new magicka of the wizard
     * @return false if value is out of range
     */
    public boolean setMagicka(int mp) {
        // checks if the wizard's new magicka is within range
        if (!(LOW_MAGICKA <= mp && mp <= HIGH_MAGICKA)){
            return false;
        }else{
            magicka = mp;    //sets mp
            return true;
        } // end if
    }
    /**
     * accessor method - retrieves the magicka of a wizard
     * @return the magicka of the wizard
     */
    public int getMagicka() {
        return magicka;
    }
    /**
     * comparator method -- compares two Wizards to each other
     * @param other the other Wizard being compared
     * @return true if they have the same characteristics (other than coordinates)
     */
    public boolean equals(Wizard other) {
        boolean same = false;
        if(other.getName().equals(name) && other.getAge() == age && other.getHeight() == height) {
            same = true;
        } //else (stay false) //end if
        return same;
    }
    /**
     * clone method -- creates an exact copy of a Wizard
     * @return a full clone of the Wizard
     */
    public Wizard clone() {
        return new Wizard(getName(), getAge(), getHealth(), getXPos(), getYPos(), getHeight(), getMagicka());
    }
    /**
     * retrieves all info about a Wizard
     * @return a string representation of the Wizard
     */
    public String toString() {
        return    "Class:\t\tWizard" + 
                   super.toString() +   //activate matching method in abstract Human class
                "\nMagicka:\t" + magicka;
    }
    // ATTRIBUTES - Public Class Variables:
    public final int LOW_MAGICKA = 0;
    public final int HIGH_MAGICKA = 200;
    // BEHAVIOURS - Public Class Methods:
    /**
     * accessor method - retrieves the magicka rules
     * @return a string representing the range that the magicka must be within
     */
    public String getMagickaRules() {
        return getRule(LOW_MAGICKA, HIGH_MAGICKA);
    }
} // end Wizard class
