package edu.ubs.sudoku.file;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static edu.ubs.sudoku.impl.BoardSupplier.*;

public class BoardSupplierTest {

    @Test
    public void splitLineTest() {
        String input = "1,2,3,4,5,6,7,8,9";
        String[] strings = splitLine.apply(input);
        Assertions.assertThat(strings)
                  .hasSize(9);
    }

    @Test
    public void convertValuesTest() {
        Integer[] integers = convertValues.apply(new String[] { "1", "2", "3", "4", "5" });
        Assertions.assertThat(integers)
                  .contains(1, 2, 3, 4, 5);
    }

    @Test
    public void linesToArrayTest() {
        String[] testStrings = new String[] { "1,2,3,4", "5,6,7,8" };
        Integer[][] values = linesToArray(Arrays.stream(testStrings));
        Assertions.assertThat(values)
                  .hasSize(2)
                  .contains(new Integer[] { 1, 2, 3, 4 })
                  .contains(new Integer[] { 5, 6, 7, 8 });
    }
}