package tic_tac_toe.view;

import java.util.Scanner;
import tic_tac_toe.model.*;

public class TicTacToeTerminal implements Observer {
   private TicTacToeBoard board;
   private Scanner scanner;

   public TicTacToeTerminal(TicTacToeBoard board) {
      this.board = board;
      this.scanner = new Scanner(System.in);
      board.register(this);
   }

   @Override
   public void update() {
      showBoard();
   }

   public void showBoard() {
      int boardSize = board.getSize();
      for (int i = 0; i < boardSize; i++) {
         String line = "";
         for (int j = 0; j < boardSize; j++) {
            TicTacToePiece piece = board.getTicTacToePiece(i, j);
            if (piece == null) {
               line += "-";
            } else {
               line += piece;
            }
         }
         System.out.println(line);
      }
   }

   public void manualMove(TicTacToePiece piece) {
      int row = 0;
      int col = 0;
      do {
         System.out.println("Enter row: ");
         row = this.scanner.nextInt();
         System.out.println("Enter colunn: ");
         col = this.scanner.nextInt();
      } while (!this.board.placeTicTacToePiece(row, col, piece));
   }

}
