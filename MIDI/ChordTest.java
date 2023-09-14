import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author David Owen and Noah Barrall
 */
public class ChordTest {
    private Chord a, b, c;
    private int[] aNotes = { 69, 72, 76 };
    private int[] bNotes = { 59, 62, 65 };

    @BeforeEach
    public void setUp() {
        a = new Chord(aNotes, 2.0);
        b = new Chord(bNotes);
        c = new Chord();
    }

    @Test
    public void testTempo() {
        Chord.setTempo(140);
        assertEquals(140, Chord.getTempo());
    }
    
    @Test
    public void testPitches() {
        // assertArrayEquals checks for equal values
        assertArrayEquals(aNotes, a.getPitches());
        // assertNotEquals checks to make sure there
        // are two separate arrays
        assertNotEquals(aNotes, a.getPitches());
        assertArrayEquals(bNotes, b.getPitches());
        assertNotEquals(bNotes, b.getPitches());
        
        int[] defaultNotes = { 60 };
        assertArrayEquals(defaultNotes, c.getPitches());
        
        int[] aNotes = { 69, 72, 76 };
        a.setPitches(aNotes);
        assertArrayEquals(aNotes, a.getPitches());
        assertNotEquals(aNotes, a.getPitches());
    }
    
    @Test
    public void testDuration() {
        assertEquals(2.0, a.getDuration(), 1e-5);
        assertEquals(1.0, b.getDuration(), 1e-5);
        assertEquals(1.0, c.getDuration(), 1e-5);
        
        a.setDuration(1.5);
        assertEquals(1.5, a.getDuration(), 1e-5);
    }

    @Test
    public void testPlay() {
        Chord.setTempo(200);
        
        for (int v = 60; v >= 20; v -= 10) {
            a.play(v);
            b.play(v);
            c.play(v);
            
            int[] p = a.getPitches();
            
            for (int i = 0; i < p.length; i++) {
                p[i]--;
            }
            
            a.setPitches(p);
        }
        
        a.play(30);
        a.play(45);
        
        Chord.setInstrument(1);
        
        for (int v = 60; v >= 20; v -= 10) {
            a.play(v, false);
            b.play(v, false);
            c.play(v, false);
            
            int[] p = a.getPitches();
            
            for (int i = 0; i < p.length; i++) {
                p[i]++;
            }
            
            a.setPitches(p);
        }
        
        a.setDuration(4.0);
        a.play(30, false);
        
        Chord.allNotesOff();
    }
}
