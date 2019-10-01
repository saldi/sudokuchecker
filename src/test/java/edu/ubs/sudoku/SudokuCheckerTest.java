package edu.ubs.sudoku;

import edu.ubs.sudoku.impl.SudokuChecker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SudokuCheckerTest {

    @Test
    public void incorrectBoardTest() {

        Boolean isCorrect = new SudokuChecker().apply(new Integer[][] {
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 } }
        );

        Assertions.assertThat(isCorrect)
                  .isEqualTo(false);
    }

    @Test
    public void incorrectBoardTest2() {

        Boolean isCorrect = new SudokuChecker().apply(new Integer[][] {
                { 1, 2, 3, null, null, null, null, null, null },
                { 4, 5, 6, null, null, null, null, null, null },
                { 7, 8, 9, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null } }
        );

        Assertions.assertThat(isCorrect)
                  .isEqualTo(false);
    }

    @Test
    public void correctBoardTest() {

        Boolean isCorrect = new SudokuChecker().apply(new Integer[][] {
                { 4, 3, 5, 2, 6, 9, 7, 8, 1 },
                { 6, 8, 2, 5, 7, 1, 4, 9, 3 },
                { 1, 9, 7, 8, 3, 4, 5, 6, 2 },
                { 8, 2, 6, 1, 9, 5, 3, 4, 7 },
                { 3, 7, 4, 6, 8, 2, 9, 1, 5 },
                { 9, 5, 1, 7, 4, 3, 6, 2, 8 },
                { 5, 1, 9, 3, 2, 6, 8, 7, 4 },
                { 2, 4, 8, 9, 5, 7, 1, 3, 6 },
                { 7, 6, 3, 4, 1, 8, 2, 5, 9 } }
        );

        Assertions.assertThat(isCorrect)
                  .isEqualTo(true);
    }

    @Test
    public void correctBoardTest2() {

        Boolean isCorrect = new SudokuChecker().apply(new Integer[][] {
                { 1, 5, 2, 4, 8, 9, 3, 7, 6 },
                { 7, 3, 9, 2, 5, 6, 8, 4, 1 },
                { 4, 6, 8, 3, 7, 1, 2, 9, 5 },
                { 3, 8, 7, 1, 2, 4, 6, 5, 9 },
                { 5, 9, 1, 7, 6, 3, 4, 2, 8 },
                { 2, 4, 6, 8, 9, 5, 7, 1, 3 },
                { 9, 1, 4, 6, 3, 7, 5, 8, 2 },
                { 6, 2, 5, 9, 4, 8, 1, 3, 7 },
                { 8, 7, 3, 5, 1, 2, 9, 6, 4 } }
        );

        Assertions.assertThat(isCorrect)
                  .isEqualTo(true);
    }

}
