// (Update the package statement with your email user name.)
package edu.messiah.nb1330.cis284.pg;

/**
 * Class to represent a parallelogram.  The getCorners method can
 * be used to get the x and y coordinates of the four corners,
 * which can then be used to draw the parallelogram one line
 * segment at a time.
 * 
 * @author David Owen
 */
public class Parallelogram implements ThingWithCorners { //class to represent a data type

    /** X coordinate of lower left corner. */
    private double lowerLeftX;

    /** Y coordinate of lower left corner. */
    private double lowerLeftY;

    /**
     * Inside angle, in degrees, between left and bottom line
     * segments (same as top right angle).
     */
    private double lowerLeftAngle;

    /** Length of left line segment (same as right). */
    private double leftSideLength;

    /** Length of bottom line segment (same as top). */
    private double bottomSideLength;

    /**
     * Create a new Parallelogram.  (Use getCorners to draw it
     * later on.)
     * 
     * @param lowerLeftX       X coordinate of lower left corner.
     * @param lowerLeftY       Y coordinate of lower left corner.
     * @param lowerLeftAngle   Inside angle, in degrees between
     *                         left and bottom line segments.
     * @param leftSideLength   Length of left line segment.
     * @param bottomSideLength Length of bottom line segment.
     */
    public Parallelogram(double lowerLeftX, double lowerLeftY,
            double lowerLeftAngle, double leftSideLength,
            double bottomSideLength) {
        this.lowerLeftX = lowerLeftX;
        this.lowerLeftY = lowerLeftY;
        this.lowerLeftAngle = lowerLeftAngle;
        this.leftSideLength = leftSideLength;
        this.bottomSideLength = bottomSideLength;
    }

    /**
     * Create a new Parallelogram--whose lower left corner is at 
     * the origin.  (Use getCorners to draw it later on.)
     * 
     * @param lowerLeftAngle   Inside angle, in degrees between
     *                         left and bottom line segments.
     * @param leftSideLength   Length of left line segment.
     * @param bottomSideLength Length of bottom line segment.
     */
    public Parallelogram(double lowerLeftAngle,
            double leftSideLength, double bottomSideLength) {
        this(0, 0, lowerLeftAngle, leftSideLength,
                bottomSideLength);
    }

    

    /**
     * Get x coordinate of lower left corner.
     * 
     * @return X coordinate of lower left corner.
     */
    public double getLowerLeftX() {
        return lowerLeftX;
    }

    /**
     * Set x coordinate of lower left corner.
     * 
     * @param lowerLeftX X coordinate of lower left corner.
     */
    public void setLowerLeftX(double lowerLeftX) {
        this.lowerLeftX = lowerLeftX;
    }

    /**
     * Get y coordinate of lower left corner.
     * 
     * @return Y coordinate of lower left corner.
     */
    public double getLowerLeftY() {
        return lowerLeftY;
    }

    /**
     * Set y coordinate of lower left corner.
     * 
     * @param lowerLeftY Y coordinate of lower left corner.
     */
    public void setLowerLeftY(double lowerLeftY) {
        this.lowerLeftY = lowerLeftY;
    }

    /**
     * Get inside angle between left and bottom line segments.
     * 
     * @return Inside angle, in degrees, between left and bottom
     *         line segments.
     */
    public double getLowerLeftAngle() {
        return lowerLeftAngle;
    }

    /**
     * Set inside angle between left and bottom line segments.
     * 
     * @param lowerLeftAngle Inside angle, in degrees, between
     *                       left and bottom line segments.
     */
    public void setLowerLeftAngle(double lowerLeftAngle) {
        this.lowerLeftAngle = lowerLeftAngle;
    }

    /**
     * Get length of left line segment (same as length of right
     * line segment).
     * 
     * @return Length of left line segment.
     */
    public double getLeftSideLength() {
        return leftSideLength;
    }

    /**
     * Set length of left line segment (and therefore right as
     * well).
     * 
     * @param leftSideLength Length of left line segment.
     */
    public void setLeftSideLength(double leftSideLength) {
        this.leftSideLength = leftSideLength;
    }

    /**
     * Get length of bottom line segment (same as length of top
     * line segment).
     * 
     * @return Length of bottom line segment.
     */
    public double getBottomSideLength() {
        return bottomSideLength;
    }

    /**
     * Set length of bottom line segment (and therefore top as
     * well).
     * 
     * @param bottomSideLength Length of bottom line segment.
     */
    public void setBottomSideLength(double bottomSideLength) {
        this.bottomSideLength = bottomSideLength;
    }

    /**
     * Return a String representation of this Parallelogram object.
     * 
     * @return String representation of this Parallelogram object.
     */
    @Override
    public String toString() {
        String s = String.format(
                "Lower left corner:  %.2f, %.2f; ", lowerLeftX,
                lowerLeftY);
        s += String.format(
                "Lower left angle:   %.2f\u00b0; ", lowerLeftAngle);
        s += String.format(
                "Left side length:   %.2f; ", leftSideLength);
        s += String.format(
                "Bottom side length: %.2f", bottomSideLength);

        return s;
    }

    /**
     * Calculate and return the x and y coordinates of the four
     * corners of the parallelogram, as a two dimensional array.
     * The order of elements is...
     * 
     *     ([1][0], [1][1])------------([2][0], [2][1])
     *            /                       /
     *           /                       /
     *   ([0][0], [0][1])------------([3][0], [3][1])
     * 
     * @return X an y coordinates of parallelogram's four corners,
     *         as a two-dimensional array.
     */
    public double[][] getCorners() {
        double[][] corners = new double[4][2];

        // lower left
        corners[0][0] = lowerLeftX;
        corners[0][1] = lowerLeftY;

        // upper left
        corners[1][0] = lowerLeftX + leftSideLength *
                Math.cos(Math.toRadians(lowerLeftAngle));
        corners[1][1] = lowerLeftY + leftSideLength *
                Math.sin(Math.toRadians(lowerLeftAngle));

        // upper right
        corners[2][0] = corners[1][0] + bottomSideLength;
        corners[2][1] = corners[1][1];

        // lower right
        corners[3][0] = lowerLeftX + bottomSideLength;
        corners[3][1] = lowerLeftY;

        return corners;
    }
}
