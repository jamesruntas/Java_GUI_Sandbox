import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  TicTacToe game using Java Swing.
 * 
 * 
 * @author James Runtas
 * @version April 4th 2023
 * * Student Number 101109175
 */
public class TicTacToeGui extends JFrame{
    private JButton[][] board;  // 2D array to represent the board
    private JLabel status;      // Label to display the current status of the game
    private boolean xTurn;      // Boolean to keep track of whose turn it is
    private JFrame frame;       // The main frame of the GUI
    


    //initializes the GUI and event listeners
    public void start() {

        //Main Frame
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        //Board as a 2d array of buttons
        board = new JButton[3][3];
        xTurn = true;

        //Panel to hold the board
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        
        //Loop through each row and column to create the buttons
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                JButton button = new JButton(" ");//Initialize each button with empty text
                button.addActionListener(new ActionListener() {// Add an ActionListener to each button that calls buttonPressed() method
                    public void actionPerformed(ActionEvent e) {
                        buttonPressed(button);
                    }
                });
                board[i][j] = button;  // Add the button to the board 2D array
                boardPanel.add(button);  // Add the button to the board panel
            }
        }

        // Create the panel to hold the status label
        JPanel statusPanel = new JPanel(new FlowLayout());
        status = new JLabel("X's turn");  // Initialize the status label with default text
        statusPanel.add(status);  // Add the status label to the status panel
        status.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));  // Add an empty border to the status label

        // Add the board panel and status panel to the main frame
        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(statusPanel, BorderLayout.SOUTH);

        frame.setVisible(true);  // Make the main frame visible


    }

    // Method to handle button press events
    private void buttonPressed(JButton button) {
        if (button.getText().equals(" ")) {  // Check if the button has not already been pressed
            if (xTurn) {  // Check whose turn it is
                button.setText("X");  // Set the text of the button to X
                status.setText("O's turn");  // Update the status label
            } else {
                button.setText("O");  // Set the text of the button to O
                status.setText("X's turn");  // Update the status label
            }
            xTurn = !xTurn;  // Switch the turn to the other player
            haveWinner();  // Check if there is a winner
        }
    }

    // Method to check if there is a winner
    private void haveWinner() {
 
        String[] moves = {"X", "O"};
        for (String move : moves) {
        if ((board[0][0].getText().equals(move) && board[0][1].getText().equals(move) && board[0][2].getText().equals(move)) ||
            (board[1][0].getText().equals(move) && board[1][1].getText().equals(move) && board[1][2].getText().equals(move)) ||
            (board[2][0].getText().equals(move) && board[2][1].getText().equals(move) && board[2][2].getText().equals(move)) ||
            (board[0][0].getText().equals(move) && board[1][0].getText().equals(move) && board[2][0].getText().equals(move)) ||
            (board[0][1].getText().equals(move) && board[1][1].getText().equals(move) && board[2][1].getText().equals(move)) ||
            (board[0][2].getText().equals(move) && board[1][2].getText().equals(move) && board[2][2].getText().equals(move)) ||
            (board[0][0].getText().equals(move) && board[1][1].getText().equals(move) && board[2][2].getText().equals(move)) ||
            (board[0][2].getText().equals(move) && board[1][1].getText().equals(move) && board[2][0].getText().equals(move))) {
            status.setText(move + " wins!");
            break;
        }
    }
    }


    public static void main(String[] args){
       TicTacToeGui game = new TicTacToeGui();
       game.start();
        
    }

}
