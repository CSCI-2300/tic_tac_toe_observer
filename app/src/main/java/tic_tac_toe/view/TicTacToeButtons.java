package tic_tac_toe.view;

import java.awt.GridLayout;
import javax.swing.*;

import tic_tac_toe.model.*;

public class TicTacToeButtons extends JPanel implements Observer
{
   private TicTacToeBoard board;
   private JButton []buttons;

   public TicTacToeButtons(TicTacToeBoard board)
   {
      this.board = board;
      int numButtons = this.board.getSize() * this.board.getSize();
      this.buttons = new JButton[numButtons];
      
      for (int i = 0; i < numButtons; i++)
      {
         buttons[i] = new JButton();
      }

      // position the buttons in a grid
      this.setLayout(new GridLayout(this.board.getSize(), this.board.getSize()));

      for (int i = 0; i < numButtons; i++)
      {
         this.add(buttons[i]);
      }
      board.register(this);
   }

    @Override
    public void update() {
        showBoard();
    }
   public void showBoard()
   {
      int numButtons = this.buttons.length;
      for (int i = 0; i < numButtons; i++)
      {
         int row = i / this.board.getSize();
         int col = i % this.board.getSize();
         TicTacToePiece piece = this.board.getTicTacToePiece(row, col);
         if (piece != null)
         {
            this.buttons[i].setText(piece.toString());
            this.buttons[i].setEnabled(false);
         }
      }
   }
}
