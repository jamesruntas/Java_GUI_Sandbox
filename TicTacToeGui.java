import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToeGui extends JFrame{
    private JButton[][] board;
    private JLabel status;
    private boolean xTurn;
    
    public TicTacToeGui() {



    }


    private void buttonPressed(JButton button) {
        if (button.getText().equals(" ")) {
            if (xTurn) {
                button.setText("X");
                status.setText("O's turn");
            } else {
                button.setText("O");
                status.setText("X's turn");
            }
            xTurn = !xTurn;
            haveWinner();
        }
    }


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


}
