// (Update the package statement with your email user name.)
package edu.messiah.nb1330.cis284.pg.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// (Update import statement with your email user name.)
import edu.messiah.nb1330.cis284.pg.Parallelogram;
import edu.messiah.nb1330.cis284.pg.Rectangle;
// (Add another import statement for your Rectangle class.)

/**
 * @author David Owen
 */
public class RectangleTest {
    private Rectangle r;
    private Rectangle s;

    @BeforeEach
    public void setUp() {
        r = new Rectangle(-1, 0, 1, 2);
        s = new Rectangle(3, 4);
    }

    @Test
    public void testInstanceOf() {
        assertTrue(r instanceof Parallelogram);
    }

    @Test
    public void testPosition() {
        assertEquals(-1, r.getLowerLeftX(), 1e-5);
        assertEquals(0, r.getLowerLeftY(), 1e-5);
        assertEquals(0, s.getLowerLeftX(), 1e-5);
        assertEquals(0, s.getLowerLeftY(), 1e-5);
        
        r.setLowerLeftX(-2);
        r.setLowerLeftY(-1);
        
        assertEquals(-2, r.getLowerLeftX(), 1e-5);
        assertEquals(-1, r.getLowerLeftY(), 1e-5);
    }
    
    @Test
    public void testSideLengths() {
        assertEquals(1, r.getLeftSideLength(), 1e-5);
        assertEquals(2, r.getBottomSideLength(), 1e-5);
        assertEquals(3, s.getLeftSideLength(), 1e-5);
        assertEquals(4, s.getBottomSideLength(), 1e-5);
        
        r.setLeftSideLength(2);
        r.setBottomSideLength(3);
        
        assertEquals(2, r.getLeftSideLength(), 1e-5);
        assertEquals(3, r.getBottomSideLength(), 1e-5);
    }
    
    @Test
    public void testAngle() {
        assertEquals(90, r.getLowerLeftAngle(), 1e-5);
        assertEquals(90, s.getLowerLeftAngle(), 1e-5);
        
        r.setLowerLeftAngle(0);
        assertEquals(90, r.getLowerLeftAngle(), 1e-5);
    }
    
    @Test
    public void testToString() {
        String s = r.toString();
        assertFalse(s.contains(/* A or a */ "ngle"));
    }
    
    @Test
    public void testGetCorners() {
        double[][] d = {{0, 0}, {0, 3}, {4, 3}, {4, 0}};
        double[][] c = s.getCorners();
        
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                assertEquals(d[i][j], c[i][j], 1e-5);
            }
        }
    }
}
