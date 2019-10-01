package edu.ubs.sudoku.impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import static edu.ubs.sudoku.impl.BoardFunctions.boxNumber;

public class SudokuChecker implements Function<Integer[][], Boolean> {

    private List<HashSet<Integer>> rowSets = new LinkedList<>();
    private List<HashSet<Integer>> colSets = new LinkedList<>();
    private List<HashSet<Integer>> boxSets = new LinkedList<>();


    private void initSets() {
        for (int i = 0; i < 9; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
            boxSets.add(new HashSet<>());
        }
    }

    private void clearSets() {
        rowSets.clear();
        colSets.clear();
        boxSets.clear();
    }

    private boolean isAllowed(Integer row, Integer col, Integer[][] board) {
        return (rowSets.get(row)
                       .add(board[row][col])
                && colSets.get(row)
                          .add(board[row][col])
                && boxSets.get(boxNumber(row, col))
                          .add(board[row][col]));
    }


    @Override
    public Boolean apply(Integer[][] board) {
        clearSets();
        initSets();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (!isAllowed(row, col, board) || board[row][col] == null) {
                    return false;
                }
            }
        }
        return true;
    }

}
