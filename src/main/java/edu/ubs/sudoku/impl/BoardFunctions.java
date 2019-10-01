package edu.ubs.sudoku.impl;

public interface BoardFunctions {

    static Integer boxNumber(Integer row, Integer col) {
        return 3 * (row / 3) + (col / 3);
    }

}
