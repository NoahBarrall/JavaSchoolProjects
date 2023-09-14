// (Update the package statement with your email user name.)
package edu.messiah.nb1330.cis284.pg.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// (Update import statement with your email user name.)
import edu.messiah.nb1330.cis284.pg.Parallelogram;
// (Add another import statement for your Rhombus class.)
import edu.messiah.nb1330.cis284.pg.Rhombus;
/**
 * @author David Owen
 */
public class RhombusTest {
    private Rhombus r;
    private Rhombus s;

    @BeforeEach
    public void setUp() {
        r = new Rhombus(-1, 0, 60, 5);
        s = new Rhombus(90, 5);
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
        assertEquals(5, r.getSideLength(), 1e-5);
        assertEquals(5, r.getLeftSideLength(), 1e-5);
        assertEquals(5, r.getBottomSideLength(), 1e-5);
        assertEquals(5, s.getSideLength(), 1e-5);
        assertEquals(5, s.getLeftSideLength(), 1e-5);
        assertEquals(5, s.getBottomSideLength(), 1e-5);
        
        r.setSideLength(10);
        assertEquals(10, r.getSideLength(), 1e-5);
        assertEquals(10, r.getLeftSideLength(), 1e-5);
        assertEquals(10, r.getBottomSideLength(), 1e-5);
        
        //checks to see if override of leftSide
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
        assertEquals(60, r.getLowerLeftAngle(), 1e-5);
        assertEquals(90, s.getLowerLeftAngle(), 1e-5);
        
        r.setLowerLeftAngle(65);
        assertEquals(65, r.getLowerLeftAngle(), 1e-5);
    }
    
    @Test
    public void testToString() {
        String s = r.toString();
        assertFalse(s.contains(/* L or l */ "eft side") ||
                s.contains(/* B or b */ "ottom side"));
    }
    
    @Test
    public void testGetCorners() {
        double[][] d = {{0, 0}, {0, 5}, {5, 5}, {5, 0}};
        double[][] c = s.getCorners();
        
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                assertEquals(d[i][j], c[i][j], 1e-5);
            }
        }
    }
}
