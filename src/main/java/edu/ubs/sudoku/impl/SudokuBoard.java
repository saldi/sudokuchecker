package edu.ubs.sudoku.impl;

import java.util.function.Function;
import java.util.function.Supplier;

public class SudokuBoard {

    private Integer[][] board;

    private SudokuBoard(Integer[][] board) {
        this.board = board;
    }

    public Boolean isCorrectSolution(Function<Integer[][], Boolean> checker) {
        return checker.apply(board);
    }

    public static SudokuBoard create(Supplier<Integer[][]> boardSupplier) {
        return new SudokuBoard(boardSupplier.get());
    }
}
