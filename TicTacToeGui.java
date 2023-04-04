import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToeGui extends JFrame{
    private JButton[][] board;
    private JLabel status;
    private boolean xTurn;
    
    public TicTacToeGui() {
        super("Tic Tac Toe");
        board = new JButton[3][3];
        xTurn = true;

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                JButton button = new JButton(" ");
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        buttonPressed(button);
                    }
                });
                board[i][j] = button;
                boardPanel.add(button);
            }
        }

        JPanel statusPanel = new JPanel(new FlowLayout());
        status = new JLabel("X's turn");
        statusPanel.add(status);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(boardPanel, BorderLayout.CENTER);
        contentPane.add(statusPanel, BorderLayout.SOUTH);


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


    public static void main(String[] args){
       TicTacToeGui game = new TicTacToeGui();
       
        
    }

}
