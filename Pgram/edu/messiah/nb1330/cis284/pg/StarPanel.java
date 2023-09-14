// (Update the package statement with your email user name.)
package edu.messiah.nb1330.cis284.pg;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * JPanel extended to draw stars made from parallelograms. (Draw
 * a parallelogram, rotate, draw another, rotate, etc.)
 * 
 * @author David Owen
 */
@SuppressWarnings("serial")
public class StarPanel extends JPanel {

    /** Width of the panel, in pixels. */
    private int width;

    /** Height of the panel, in pixels. */
    private int height;

    /** Parallelogram object to use when drawing the star. */
    private Parallelogram parallelogram;

    /** Number of parallelograms to use when drawing the star. */
    private int numParallelograms;

    /**
     * Create a panel with a star, made from a bunch of
     * parallelograms, drawn on it.
     * 
     * @param width             Width of the panel, in pixels.
     * @param height            Height of the panel, in pixels.
     * @param parallelogram     Parallelogram object to use when
     *                          drawing the star.
     * @param numParallelograms Number of parallelograms to use
     *                          when drawing the star.
     */
    public StarPanel(int width, int height,
            Parallelogram parallelogram, int numParallelograms) {
        this.width = width;
        this.height = height;
        this.parallelogram = parallelogram;
        this.numParallelograms = numParallelograms;

        setPreferredSize(new Dimension(width, height));
    }

    /**
     * Draw star on panel (called any time window manager needs
     * to redraw the panel).
     * 
     * @param graphics Graphics context through which it's
     *                 possible to draw on the panel.
     */
    @Override
    public void paint(Graphics graphics) {

        // Since Java 2, the graphics context passed to paint is
        // a Graphics2D object.  But Graphics2D extends Graphics,
        // the old graphics context class, so the argument can be
        // passed as a Graphics (not Graphics2D) object.  This
        // means pre-Java 2 code will still work.  Since we want
        // Graphics2D-specific features added with Java 2, we
        // need to cast the parameter to Graphics2D to make those
        // features accessible.
        Graphics2D graphicsContext = (Graphics2D) graphics;

        // Turn on anti-aliasing.  (Make diagonal lines look nice.)
        graphicsContext.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Transform coordinate system so that origin is at the
        // center and y direction is up.  Default is origin at top
        // left and y direction down.
        graphicsContext.translate(width / 2, height / 2);
        graphicsContext.scale(1, -1);

        // Draw a bunch of parallelograms, rotating after each...
        for (int i = 0; i < 360; i += (360 / numParallelograms)) {
            drawParallelogram(graphicsContext, parallelogram);
            graphicsContext.rotate(
                    Math.toRadians(360 / numParallelograms));
        }
    }

    /**
     * Draw a parallelogram line-by-line.
     * 
     * @param graphicsContext Graphics context through which to
     *                        draw on the window (i.e., panel).
     * @param parallelogram   Parallelogram object to draw.
     */
    private void drawParallelogram(Graphics2D graphicsContext,
            Parallelogram parallelogram) {
        double[][] corners = parallelogram.getCorners();

        // left
        graphicsContext.drawLine(
                (int) corners[0][0], (int) corners[0][1],
                (int) corners[1][0], (int) corners[1][1]);
        // top
        graphicsContext.drawLine(
                (int) corners[1][0], (int) corners[1][1],
                (int) corners[2][0], (int) corners[2][1]);
        // right
        graphicsContext.drawLine(
                (int) corners[2][0], (int) corners[2][1],
                (int) corners[3][0], (int) corners[3][1]);
        // bottom
        graphicsContext.drawLine(
                (int) corners[3][0], (int) corners[3][1],
                (int) corners[0][0], (int) corners[0][1]);
    }
}
