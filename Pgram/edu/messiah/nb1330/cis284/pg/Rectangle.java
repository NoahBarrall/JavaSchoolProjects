package edu.messiah.nb1330.cis284.pg;

/**
 * Class to represent a rectangle.  Inherits from Parallelogram
 * class a getCorners method, which can be used to get the x and y
 * coordinates of the four corners, which can then be used to
 * draw the rectangle one line segment at a time.
 * 
 * @author David Owen and Noah Barrall
 */
public class Rectangle extends Parallelogram {
    
    /**
     * Create a new Rectangle.  (Use getCorners to draw it
     * later on.)
     * 
     * @param lowerLeftX       X coordinate of lower left corner.
     * @param lowerLeftY       Y coordinate of lower left corner.
     * @param leftSideLength   Length of left line segment.
     * @param bottomSideLength Length of bottom line segment.
     */
    public Rectangle(double lowerLeftX, double lowerLeftY,
        double leftSideLength, double bottomSideLength) {
        
        super(lowerLeftX, lowerLeftY, 90, leftSideLength, bottomSideLength);
    }

    /**
     * Create a new Rectangle.  (Use getCorners to draw it
     * later on.)
     * 
     * @param leftSideLength   Length of left line segment.
     * @param bottomSideLength Length of bottom line segment.
     */

    public Rectangle(double leftSideLength, double bottomSideLength) {
        // super(0, 0, 90, leftSideLength, bottomSideLength)
        this(0, 0, leftSideLength, bottomSideLength);
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
                "Left side length:   %.2f; ", getLeftSideLength());
        s += String.format(
                "Bottom side length: %.2f", getBottomSideLength());

        return s;
    }
}
