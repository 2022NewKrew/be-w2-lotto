package lotto.view;

import lotto.util.StringParsingUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class IOView {

    private IOView() {
    }

    public static int inputToInt(String message, BufferedReader input, BufferedWriter output) throws IOException {
        output.write(message + "\n");
        output.flush();
        return Integer.parseInt(input.readLine().trim());
    }

    public static List<List<Integer>> inputToDoubleList(String message,
                                                        BufferedReader input,
                                                        BufferedWriter output,
                                                        int iterableCount) throws IOException {
        output.write(message + "\n");
        output.flush();
        List<List<Integer>> inputList = new ArrayList<>();
        for (int i = 0; i < iterableCount; i++) {
            inputList.add(StringParsingUtil.parse(input.readLine(), ",").stream()
                    .map(Integer::parseInt)
                    .collect(toList()));
        }
        return inputList;
    }

    public static List<Integer> inputToList(String message, BufferedReader input, BufferedWriter output) throws IOException {
        output.write(message + "\n");
        output.flush();
        return StringParsingUtil.parse(input.readLine(), ",").stream()
                .map(Integer::parseInt)
                .collect(toList());
    }
}
