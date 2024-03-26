package tic_tac_toe.model;

public enum TicTacToePiece {
    X("X"), O("O");

    private final String piece;

    TicTacToePiece(String name) {
        this.piece = name;
    }
}

