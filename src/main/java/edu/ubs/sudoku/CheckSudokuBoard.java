package edu.ubs.sudoku;

import edu.ubs.sudoku.impl.SudokuBoard;
import edu.ubs.sudoku.impl.SudokuChecker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static edu.ubs.sudoku.impl.BoardSupplier.fromFile;

public class CheckSudokuBoard {

    private static final Logger LOGGER = LogManager.getLogger(CheckSudokuBoard.class.getName());

    public static void main(String[] args) {
        checkArguments(args);
        System.exit(resolveResponse(SudokuBoard.create(fromFile(args[0]))
                                               .isCorrectSolution(new SudokuChecker())));
    }

    public static void checkArguments(String[] args) {
        if (args.length < 1) {
            LOGGER.error("Wrong file name");
            System.exit(-1);
        }
    }

    private static int resolveResponse(Boolean correctSolution) {
        if (correctSolution)
            return 0;
        else
            return -1;
    }

}
