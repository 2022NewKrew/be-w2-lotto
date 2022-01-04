package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class StringUtils {

  private StringUtils() {}

  private static final String DEFAULT_DELIMITER = ",";

  public static List<String> splitByDelimiter(String str, String delimiter) {
    return Arrays.stream(str.split(delimiter))
        .map(String::strip)
        .collect(Collectors.toList());
  }


  public static List<String> splitByDelimiter(String str) {
    return splitByDelimiter(str, DEFAULT_DELIMITER);
  }

}
