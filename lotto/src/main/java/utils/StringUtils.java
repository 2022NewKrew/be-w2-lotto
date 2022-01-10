package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * String 파싱 유틸
 *
 * @author leo.jung
 * @since 1.0
 */
public final class StringUtils {

  private StringUtils() {
  }

  private static final String DEFAULT_DELIMITER = ",";

  public static List<String> splitByDelimiter(String str, String delimiter) {
    return Arrays.stream(str.split(delimiter))
        .map(String::strip)
        .collect(Collectors.toList());
  }


  public static List<String> splitByDelimiter(String str) {
    return splitByDelimiter(str, DEFAULT_DELIMITER);
  }


  public static List<Integer> integersSplitByDelimiter(String str, String delimiter) {
    return splitByDelimiter(str, delimiter)
        .stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }


  public static List<Integer> integersSplitByDelimiter(String str) {
    return integersSplitByDelimiter(str, DEFAULT_DELIMITER);
  }


  public static List<List<Integer>> doubleParseToByDelimiter(
      String str, String delimiter1, String delimiter2) {
    return StringUtils.splitByDelimiter(str, delimiter1)
        .stream()
        .map(firstSplit -> integersSplitByDelimiter(firstSplit, delimiter2))
        .collect(Collectors.toList());
  }

}
