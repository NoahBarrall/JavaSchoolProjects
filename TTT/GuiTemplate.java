import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Basic program to illustrate a possible structure for a simple
 * GUI program.
 * 
 * @author David Owen
 */
@SuppressWarnings("serial") // To get rid of spurious warning.
public class GuiTemplate extends JFrame {

    /**
     * Button on the window (an instance variable, so that it will
     * be accessible from both makeMainPanel and actionPerformed).
     */
    private JButton button;
    
    /**
     * Display a window with the title "Title" and a button
     * labeled "Click this button!"  If the button is clicked, a
     * line is printed to the console to show that the click was
     * recognized.
     */
    public GuiTemplate() {
        super("Title");  // "super" used to call superclass
                         // (i.e., JFrame) constructor.
        
        // When the window is closed (e.g., by clicking the "X"
        // in the corner), the program should exit (i.e., terminate).
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Create GUI layout, add it to the window.
        add(makeMainPanel());
        
        // Finalize layout.  (Pack components together and make
        // the window only as big as needed to fit them in.)
        pack();
        
        setVisible(true);
    }
    
    /**
     * Make the window layout and put it on a panel.  In this
     * case the default layout is used, and a single button is
     * added to the panel.
     * 
     * @return panel with button labeled "Click this button!"
     */
    private JPanel makeMainPanel() {
        
        // Create a panel with the default layout manager (called
        // "FlowLayout"--components will be arranged like words
        // in a centered paragraph).
        JPanel panel = new JPanel();
        
        button = new JButton("Click this button!");
        
        // Connect button to a Listener object so that, if the
        // button is clicked, the Listener object's
        // actionPerformed method will be called.
        button.addActionListener(new Listener());
        
        // Put button on panel (positioned based on the panel's
        // layout manager).
        panel.add(button);
        
        return panel;
    }
    
    /**
     * Inner class with methods to respond to events generated by
     * GUI components.  (The benefit of putting this code in an
     * inner class, rather than a separate file, is that it will
     * have access to the private instance variable, button.)
     */
    private class Listener implements ActionListener {
        
        /**
         * Respond to button click by printing a line in the
         * console.  Note:  you don't call this method.  It's
         * called automatically any time there's an event (e.g.,
         * a mouse click) associated with a GUI component to
         * which an instance of Listener was added (via
         * the addActionListener method).
         * 
         * @param event ActionEvent object through which to
         *              access the GUI component that generated
         *              the event.
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            
            // Check to see if the event came from a button.
            // If so print a line to the console.
            if (event.getSource() == button) {
                System.out.println("button clicked");
            }
        }
    }

    /**
     * Show the GUI.
     * 
     * @param args command-line arguments (ignored).
     */
    public static void main(String[] args) {
        new GuiTemplate();
    }
}