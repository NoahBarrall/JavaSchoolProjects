import java.util.Random;

/**
 * @author David Owen and Noah Barrall
 */
public class ChordFun {
    
    public static void main(String[] args) {
        Random random = new Random();
        Chord.setTempo(100);
        int instrument = 0;
            
        int[][] pitches = { { 67, 79 },     // G, high G
                            { 60, 69 },     // C, A
                            { 64, 72 },     // E, high C
                            { 65, 72 },     // F, high C
                            { 60, 72, 84 }, // C, high C, higher C
                            { } };          // silence

        Chord[] chords = new Chord[pitches.length];
                        
        for (int i = 0; i < chords.length; i++) {
            chords[i] = new Chord(pitches[i], 0.25);  // 16th notes.
        }
                        
        for (int j = 0; true; j++) {            
            int i = random.nextInt(chords.length);
            int v = random.nextInt(10) + 30;
                
            if (j % 2 == 0) {
                v = v + random.nextInt(20);
            }
                
            if (j % 3 == 0) {
                v = v + random.nextInt(20);
            }
            
            if (j % 16 == 0) {
                Chord.setInstrument(instrument++);
            }

            chords[i].play(v);
        }
    }
}