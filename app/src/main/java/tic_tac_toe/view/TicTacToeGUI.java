package tic_tac_toe.view;

import java.awt.*;
import javax.swing.*;

import tic_tac_toe.model.*;

public class TicTacToeGUI {
   public TicTacToeGUI() {
      TicTacToeBoard board = new TicTacToeBoard();
      TicTacToeButtons buttons = new TicTacToeButtons(board);

      JFrame mainFrame = new JFrame("Tic Tac Toe");
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel mainPanel = new JPanel();

      // set the background color of the panel that contains everything
      mainPanel.setBackground(new Color(227, 206, 245));
      // align the components of the main panel vertically
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      // add some padding to the edges of the main panel
      mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

      JLabel instructions = new JLabel("Your piece is O");
      instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
      mainPanel.add(instructions);

      buttons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
      // make the buttons panel "see-through"
      buttons.setOpaque(false);
      mainPanel.add(buttons);

      mainFrame.add(mainPanel);

      mainFrame.pack();
      mainFrame.setVisible(true);

      // an example of udating a button with X or O in the GUI
      TicTacToePiece x_piece = TicTacToePiece.X;
      board.placeTicTacToePiece(1, 1, x_piece);
      buttons.showBoard();
   }
}
