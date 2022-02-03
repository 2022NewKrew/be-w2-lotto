package dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoPaperDto {
    List<List<Integer>> paper;

    public LottoPaperDto(List<List<Integer>> paper) {
        this.paper = paper;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (List<Integer> numbers : paper) {
            result.append("[");
            result.append(numbers.stream()
                    .map(Objects::toString)
                    .collect(Collectors.joining(", ")));
            result.append("]\n");
        }

        return result.toString();
    }
}
