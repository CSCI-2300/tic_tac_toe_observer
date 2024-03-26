package tic_tac_toe;

import tic_tac_toe.model.*;
import tic_tac_toe.view.*;

public class TicTacToe {
   public static void main(String[] args) {
      TicTacToeBoard board = new TicTacToeBoard();
      TicTacToeTerminal terminal = new TicTacToeTerminal(board);

      TicTacToePiece[] playerTicTacToePieces = {TicTacToePiece.X, TicTacToePiece.O};

      TicTacToePiece winner = null;
      AutoPlayer autoPlayer = new AutoPlayer(TicTacToePiece.X);

      while (!board.isFull()) {
         autoPlayer.makeNextMove(board);

         winner = board.getWinner();
         if (board.isFull() || winner != null) {
            break;
         }
         System.out.println("Next Player");
         terminal.manualMove(playerTicTacToePieces[1]);

         winner = board.getWinner();
         if (board.isFull() || winner != null) {
            break;
         }
         System.out.println("Next Player");
      }

      if (winner != null) {
         System.out.println("Winner is " + winner);
      }
   }
}
