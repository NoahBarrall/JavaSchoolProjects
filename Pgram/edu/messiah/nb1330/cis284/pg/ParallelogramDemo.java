// (Update the package statement with your email user name.)
package edu.messiah.nb1330.cis284.pg;

import javax.swing.JFrame;
import java.awt.GridLayout;

/**
 * Demonstrate Parallelogram class by drawing a pretty star.
 * 
 * @author David Owen and Noah Barrall
 */
@SuppressWarnings("serial")
public class ParallelogramDemo extends JFrame {

    /** Width of star panel, in pixels. */
    private static final int WIDTH = 320;

    /** Height of star panel, in pixels. */
    private static final int HEIGHT = 240;

    /**
     * Demonstrate Parallelogram class by drawing a star made from
     * a bunch of parallelograms.
     */
    public ParallelogramDemo() {
        super("Parallelogram Activity");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(2, 2));

        // Create star panel with star made of 18 parallelograms.
        // (Draw one, rotate, draw another, rotate...until you go
        // around the whole circle.)
        add(new StarPanel(WIDTH, HEIGHT,
            new Parallelogram(10, 15, 20, 40, 60), 18));

        add(new StarPanel(WIDTH, HEIGHT,
            new Rectangle(10, 15, 80, 60), 18));

        add(new StarPanel(WIDTH, HEIGHT,
            new Rhombus(10, 15, 20, 50), 18));

        add(new StarPanel(WIDTH, HEIGHT,
            new Square(10, 15, 50), 18));

        pack();
        setVisible(true);
    }

    /**
     * Call constructor to display window with parallelogram star.
     * 
     * @param args Command line arguments (ignored).
     */
    public static void main(String[] args) {
        new ParallelogramDemo();
    }
}
