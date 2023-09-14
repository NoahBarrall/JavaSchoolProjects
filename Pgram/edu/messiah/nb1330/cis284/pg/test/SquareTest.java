// (Update the package statement with your email user name.)
package edu.messiah.nb1330.cis284.pg.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// (Update import statement with your email user name.)
import edu.messiah.nb1330.cis284.pg.Parallelogram;
// (Add appropriate import statements, so that your Rectangle,
// Rhombus and Square classes are accessible.)
import edu.messiah.nb1330.cis284.pg.Rectangle;
import edu.messiah.nb1330.cis284.pg.Rhombus;
import edu.messiah.nb1330.cis284.pg.Square;


public class SquareTest {
    private Square r;
    private Square s;

    @BeforeEach
    public void setUp() {
        r = new Square(-1, 0, 1);
        s = new Square(4);
    }

    @Test
    public void testInstanceOf() {
        assertTrue(r instanceof Parallelogram);
        assertTrue(((Parallelogram) r instanceof Rectangle) ||
                ((Parallelogram) r instanceof Rhombus));
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
        assertEquals(1, r.getBottomSideLength(), 1e-5);
        assertEquals(4, s.getLeftSideLength(), 1e-5);
        assertEquals(4, s.getBottomSideLength(), 1e-5);
        
        r.setSideLength(10);
        assertEquals(10, r.getSideLength(), 1e-5);
        assertEquals(10, r.getLeftSideLength(), 1e-5);
        assertEquals(10, r.getBottomSideLength(), 1e-5);
        
        r.setLeftSideLength(11);
        assertEquals(11, r.getSideLength(), 1e-5);
        assertEquals(11, r.getLeftSideLength(), 1e-5);
        assertEquals(11, r.getBottomSideLength(), 1e-5);
        
        r.setBottomSideLength(12);
        assertEquals(12, r.getSideLength(), 1e-5);
        assertEquals(12, r.getLeftSideLength(), 1e-5);
        assertEquals(12, r.getBottomSideLength(), 1e-5);
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
        assertFalse(s.contains(/* L or l */ "eft side") ||
                s.contains(/* B or b */ "ottom side"));
    }
    
    @Test
    public void testGetCorners() {
        double[][] d = {{0, 0}, {0, 4}, {4, 4}, {4, 0}};
        double[][] c = s.getCorners();
        
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                assertEquals(d[i][j], c[i][j], 1e-5);
            }
        }
    }
}

