package edu.messiah.nb1330.cis284.pg;

/** 
* @author David Owen and Noah Barrall
*/

public class Square extends Rhombus {
    
     /**
     * Create a new Rhombus.  (Use getCorners to draw it
     * later on.)
     * 
     * @param lowerLeftX       X coordinate of lower left corner.
     * @param lowerLeftY       Y coordinate of lower left corner.
     * @param sideLength   Length of left line segment.
     */
    public Square(double lowerLeftX, double lowerLeftY, double sideLength) {
        super(lowerLeftX, lowerLeftY, 90, sideLength);
    }

    /**
     * Create a new Rhombus--whose lower left corner is at 
     * the origin.  (Use getCorners to draw it later on.)
     *
     * @param sideLength   Length of left line segment.
     */
    public Square(double sideLength) {
        this(0, 0, sideLength);
    }

    /**
     * Set inside angle between left and bottom line segments.
     * 
     * @param lowerLeftAngle Inside angle, in degrees, between
     *                       left and bottom line segments.
     */
    @Override
    public void setLowerLeftAngle(double lowerLeftAngle) {
        // overide doesnt allow lower left angle to be changed
    }

     /**
     * Return a String representation of this Parallelogram object.
     * 
     * @return String representation of this Parallelogram object.
     */
    @Override
    public String toString() {
        String s = String.format(
                "Lower left corner:  %.2f, %.2f; ", getLowerLeftX(),
                getLowerLeftY());
        s += String.format(
                "Side Length:   %.2f; ", getSideLength());
        return s;
    }
}
