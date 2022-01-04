package domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoUtils {

  private static final List<Integer> LOTTO_CONST = new ArrayList<>(List.of(
      1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
      11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
      21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
      31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
      41, 42, 43, 44, 45
  ));


  public static int getMaxPurchaseQuantity(int amount) {
    return amount / 1000;
  }


  public static List<Integer> getRandomNumbers(int size) {
    Collections.shuffle(LOTTO_CONST);
    return LOTTO_CONST.stream()
        .limit(size)
        .sorted()
        .collect(Collectors.toList());
  }


}
