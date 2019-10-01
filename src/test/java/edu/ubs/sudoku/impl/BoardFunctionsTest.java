package edu.ubs.sudoku.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoardFunctionsTest {

    private static Stream<Arguments> boxNumberTestValues() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 2, 0),
                Arguments.of(2, 0, 0),
                Arguments.of(2, 2, 0),

                Arguments.of(0, 3, 1),
                Arguments.of(0, 5, 1),
                Arguments.of(2, 3, 1),
                Arguments.of(2, 5, 1),

                Arguments.of(0, 6, 2),
                Arguments.of(0, 8, 2),
                Arguments.of(2, 6, 2),
                Arguments.of(2, 8, 2),

                Arguments.of(3, 0, 3),
                Arguments.of(3, 2, 3),
                Arguments.of(5, 0, 3),
                Arguments.of(5, 2, 3),

                Arguments.of(3, 3, 4),
                Arguments.of(3, 5, 4),
                Arguments.of(5, 3, 4),
                Arguments.of(5, 5, 4),

                Arguments.of(3, 6, 5),
                Arguments.of(3, 8, 5),
                Arguments.of(5, 6, 5),
                Arguments.of(5, 8, 5),

                Arguments.of(6, 0, 6),
                Arguments.of(6, 2, 6),
                Arguments.of(8, 0, 6),
                Arguments.of(8, 2, 6),

                Arguments.of(6, 3, 7),
                Arguments.of(6, 5, 7),
                Arguments.of(8, 3, 7),
                Arguments.of(8, 5, 7),

                Arguments.of(6, 6, 8),
                Arguments.of(6, 8, 8),
                Arguments.of(8, 6, 8),
                Arguments.of(8, 8, 8)

        );
    }

    @ParameterizedTest
    @MethodSource("boxNumberTestValues")
    void boxNumberTest(Integer row, Integer col, Integer expectedBoxNumber) {
        Integer foundBoxNumber = BoardFunctions.boxNumber(row, col);
        Assertions.assertThat(foundBoxNumber)
                  .isEqualTo(expectedBoxNumber);
    }
}