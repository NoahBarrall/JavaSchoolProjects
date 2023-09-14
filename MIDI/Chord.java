import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Receiver;

/**
 * @author David Owen and Noah Barrall
 */

public class Chord {
    

    private static final int DEFAULT_TEMPO = 120;
    private static final int DEFAULT_INSTRUMENT = 12;
    private static final int[] DEFAULT_PITCH = {60};
    private static final double DEFAULT_DURATION = 1.0;

    private static Receiver receiver;
    private static int beatMs;

    // "static initializer block"
    // Like a constructor, but for (non final) class variables...
    // Code here runs just once, as opposed to code in a constructor, which runs again every time a new instance is created.


    static {
        try {
            receiver = MidiSystem.getReceiver();
            setInstrument(DEFAULT_INSTRUMENT);
            setTempo(DEFAULT_TEMPO);
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

     //instance variables
    private int[] pitches;
    private double duration;

     //constructors
    public Chord(int[] pitches, double duration) {
        this.pitches = pitches.clone();
        this.duration = duration;
        //this. looks for instance variables
    }

    public Chord(int[] pitches) {
        //change this(pitch, DEFAULT_DURATION)
        this.pitches = pitches.clone();
        this.duration = DEFAULT_DURATION;
    }

    public Chord() {
        this.pitches = DEFAULT_PITCH.clone();
        this.duration = DEFAULT_DURATION;
    }

    public int[] getPitches() {
        return pitches.clone();
    }

    public void setPitches(int[] pitch) {
        this.pitches = pitches.clone();
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void play(int velocity, boolean sendOffMessage) {
        for (int i = 0; i < pitches.length; i++) {
            try {
                int command = ShortMessage.NOTE_ON;
                int channel = 0;
                int timestamp = -1;
        
                    ShortMessage message = new ShortMessage(command, channel, pitches[i], velocity);
                    receiver.send(message, timestamp);
                    
                    // Time delay.
                    Thread.sleep((int) (duration * beatMs));
                    
                    if (sendOffMessage) {
                        command = ShortMessage.NOTE_OFF;
                    
                        message = new ShortMessage(
                                command, channel, pitches[0], velocity);
                        receiver.send(message, timestamp);
                    }
            } catch (InvalidMidiDataException e) {
                System.err.println("Invalid pitch (" + pitches +
                        ") or velocity (" + velocity + ").");
        
            } catch (InterruptedException e) {
                // Ignore this.  (Thread.sleep will not be interrupted.)
            }
        }
    }

    public void play(int velocity) {
        play(velocity, true);
    }

    //static methods (aka functions)
    public static void setInstrument(int instrument) {

        try {
            int command = ShortMessage.PROGRAM_CHANGE;
            int channel = 0;     // 1st MIDI channel (called 1 in MIDI
                                 // standard but 0 in Java).
            int timestamp = -1;  // No timestamp (execute command ASAP).
    
            ShortMessage message = new ShortMessage(
                    command, channel, instrument, 0);
            receiver.send(message, timestamp);
    
        } catch (InvalidMidiDataException e) {
            System.err.println("Invalid instrument number (" +
                    instrument + ").");
        }
    }

    public static int getTempo() {
        return 60_000 / beatMs;
    }
    
    public static void setTempo(int tempo) {
        beatMs = 60_000 / tempo;
    }

    public static void allNotesOff() {

        try {
            int command = ShortMessage.CONTROL_CHANGE;
            int channel = 0;
            int allSoundOffCode = 120;
            int timestamp = -1;
    
            ShortMessage message = new ShortMessage(
                    command, channel, allSoundOffCode, 0);
            receiver.send(message, timestamp);
    
        } catch (InvalidMidiDataException e) {
        }
    }
}

