package edu.ubs.sudoku.impl;

import io.vavr.control.Try;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface BoardSupplier {

    Function<String, String[]> splitLine = (line) -> line.split(",");
    Function<String[], Integer[]> convertValues = (lineValues) -> Arrays.stream(lineValues)
                                                                        .map(Integer::valueOf)
                                                                        .collect(Collectors.toList())
                                                                        .toArray(new Integer[] {});
    Predicate<Integer[][]> isBoardStructureCorrect = (board) -> {
        if (board.length != 9)
            return false;
        for (Integer[] integers : board) {
            if (integers.length != 9)
                return false;
        }
        return true;
    };

    static Supplier<Integer[][]> fromFile(String filePath) {
        return () -> Try.of(() -> linesToArray(new BufferedReader(new FileReader(getFile(filePath)))
                .lines()))
                        .filter(isBoardStructureCorrect)
                        .recover(r -> {throw new WrongFileStructureException(r);})
                        .get();
    }

    static File getFile(String filePath) {
        return Paths.get(filePath)
                    .toFile();
    }

    static Integer[][] linesToArray(Stream<String> stringStream) {
        return stringStream.map(splitLine)
                           .map(convertValues)
                           .collect(Collectors.toList())
                           .toArray(new Integer[0][0]);
    }

}
