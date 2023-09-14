import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author David Owen and Noah Barrall
 */
public class NoteTest {
    private Note a, b, c;
        
    @BeforeEach
    public void setUp() {
        a = new Note(57, 2.0);
        b = new Note(59);
        c = new Note();
    }

    @Test
    public void testTempo() {
        Note.setTempo(140);
        assertEquals(140, Note.getTempo());
    }
    
    @Test
    public void testPitch() {
        assertEquals(57, a.getPitch());
        assertEquals(59, b.getPitch());
        assertEquals(60, c.getPitch());
        
        a.setPitch(69);
        assertEquals(69, a.getPitch());
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
        Note.setTempo(200);
        
        for (int v = 80; v >= 40; v -= 10) {
            a.play(v);
            b.play(v);
            c.play(v);
            a.setPitch(a.getPitch() - 1);
        }
        
        a.play(30);
        a.play(45);
        
        // Second series of notes should sound like a different
        // instrument, and should be sustained indefinitely.
        Note.setInstrument(0);
        
        for (int v = 70; v >= 30; v -= 10) {
            a.play(v, false);
            b.play(v, false);
            c.play(v, false);
            a.setPitch(a.getPitch() + 1);
        }
        
        a.setDuration(4.0);
        a.play(30, false);
        
        Note.allNotesOff();
    }
}
