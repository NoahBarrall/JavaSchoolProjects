package edu.messiah.nb1330.cis284.pg;

/** 
* @author David Owen and Noah Barrall
*/

public class Rhombus extends Parallelogram {
    /**
     * Create a new Rhombus.  (Use getCorners to draw it
     * later on.)
     * 
     * @param lowerLeftX       X coordinate of lower left corner.
     * @param lowerLeftY       Y coordinate of lower left corner.
     * @param lowerLeftAngle   Inside angle, in degrees between
     *                         left and bottom line segments.
     * @param sideLength   Length of left line segment.
     */
    public Rhombus(double lowerLeftX, double lowerLeftY,
            double lowerLeftAngle, double sideLength) {
        super(lowerLeftX, lowerLeftY, lowerLeftAngle, sideLength, sideLength);
    }

    /**
     * Create a new Rhombus--whose lower left corner is at 
     * the origin.  (Use getCorners to draw it later on.)
     * 
     * @param lowerLeftAngle   Inside angle, in degrees between
     *                         left and bottom line segments.
     * @param sideLength   Length of left line segment.
     */
    public Rhombus(double lowerLeftAngle, double sideLength) {
        this(0, 0, lowerLeftAngle, sideLength);
    }
    
    public double getSideLength() {
        return getLeftSideLength();
    }

    public void setSideLength(double sideLength) {
        super.setLeftSideLength(sideLength);
        super.setBottomSideLength(sideLength);
    }

        /**
     * Set length of left line segment (and therefore all the others as
     * well).
     * 
     * @param leftSideLength Length of left line segment.
     */
    @Override
    public void setLeftSideLength(double leftSideLength) {
        setSideLength(leftSideLength);
    }

        /**
     * Set length of left line segment (and therefore all the others as
     * well).
     * 
     * @param bottomSideLength Length of left line segment.
     */
    @Override
    public void setBottomSideLength(double bottomSideLength) {
        setSideLength(bottomSideLength);
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
            "Lower left angle:   %.2f\u00b0; ", getLowerLeftAngle());
        s += String.format(
                "Side Length:   %.2f; ", getSideLength());
        return s;
    }
}
