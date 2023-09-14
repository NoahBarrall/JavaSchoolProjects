import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Program that takes user input in a command line argument 
 * and creates a TicTacToe based off of that number
 * 
 * @author David Owen and Noah Barrall
 */


public class BigTicTacToe extends JFrame {

    private JButton[][] buttons;
    private JLabel statsLabel;
    private Player whoseTurn;
    private boolean gameOver;
    private int N;

    /* 
     * Allows a command line argument to expand the board
     */
    public BigTicTacToe(int N) {
        super("Title");       
        setDefaultCloseOperation(EXIT_ON_CLOSE);    
        this.N = N; 
        add(makeMainPanel());
        pack();

        
        whoseTurn = Player.X;
        gameOver = false;
        updateStats();
        
        setVisible(true);

    }

    // Makes main panel and sets everything up
    private JPanel makeMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Sets buttons for whatever N is
        buttons = new JButton[N][N];
        JPanel buttonPanel = new JPanel(new GridLayout(N, N));
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        Listener listener = new Listener();

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++){
                buttons[i][j] = new JButton(" ");
                buttonPanel.add(buttons[i][j]);
                buttons[i][j].setPreferredSize(new Dimension(
                    80, 80));
                buttons[i][j].addActionListener(listener);
            }
        }

        statsLabel = new JLabel(" ");
        JPanel statsPanel = new JPanel();
        statsPanel.add(statsLabel);
        mainPanel.add(statsPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

    private class Listener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {

            if (!gameOver) {
                JButton button = (JButton) event.getSource();
            
                if (button.getText().equals(" ")){
                    if (whoseTurn.equals(Player.X)) {
                        button.setText("X");
                        whoseTurn = Player.O;
                        updateStats();
                    } else {
                        button.setText("O");
                        whoseTurn = Player.X;
                        updateStats();
                    }
                }
            }    
        }
    }

    private String checkWin() {

        boolean stalemateCounter = true;
        
        // Check rows
        for (int row = 0; row < N; row++) {
            int xs = 0;
            int os = 0;

            for (int col = 0; col < N; col++) {
                String t = buttons[row][col].getText();

                if (t.equals("X")) {
                    xs++;
                } else if (t.equals("O")) {
                    os++;
                }
            }
            
            if (xs == N) {
                return "X Wins!";
            } else if (os == N) {
                return "O wins!";
            } else if (xs == 0 || os == 0) {
                stalemateCounter = false;
            }
        }
        //check columns
        for (int col = 0; col < N; col++) {
            int xs = 0;
            int os = 0;

            for (int row = 0; row < N; row++) {
                String t = buttons[row][col].getText();

                if (t.equals("X")) {
                    xs++;
                } else if (t.equals("O")) {
                    os++;
                }
            }
            
            if (xs == N) {
                return "X Wins!";
            } else if (os == N) {
                return "O wins!";
            } else if (xs == 0 || os == 0) {
                stalemateCounter = false;
            }
        }

        //check diagonals
        int xs = 0;
        int os = 0;

        for (int i = 0; i < N; i++) {
            String t = buttons[i][i].getText();

            if (t.equals("X")) {
                xs++;
            } else if (t.equals("O")) {
                os++;
            }
        }

        if (xs == N) {
            return "X Wins!";
        } else if (os == N) {
            return "O wins!";
        } else if (xs == 0 || os == 0) {
            stalemateCounter = false;
        }
    
        //check other diagonals
        xs = 0;
        os = 0;

        for (int i = 0; i < N; i++) {
            String t = buttons[i][N - 1 - i].getText();

            if (t.equals("X")) {
                xs++;
            } else if (t.equals("O")) {
                os++;
            }
        }

        if (xs == N) {
            return "X Wins!";
        } else if (os == N) {
            return "O wins!";
        } else if (xs == 0 || os == 0) {
            stalemateCounter = false;
        }
        
        if (stalemateCounter == true) {
            return "Stalemate!";
        }

        return null;
    }

    // Updates stats
    private void updateStats() {
        String result = checkWin();

        if (result == null) {
            if (whoseTurn.equals(Player.X)) {
                statsLabel.setText("X's Turn");
            } else {
                statsLabel.setText("O's Turn");
            }
        } else {
            statsLabel.setText(result);
            gameOver = true;
        }
    }
    
    /* 
    * Main that allows for an arg to be specified and assigns
    * that number to the size of the board
    */

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        new BigTicTacToe(N);
    }
}
