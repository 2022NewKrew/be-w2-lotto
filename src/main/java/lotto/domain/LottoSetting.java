package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LottoSetting {
    final static public Integer LOTTO_PRICE = 1000; //each price of lotto
    final static public Integer LOTTO_LENGTH = 6; //each lotto length
    final static public Integer LOTTO_NUMBER_RANGE = 45;
    final static public List<Integer> LOTTO_WINNER_PRIZE = new ArrayList<>(Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000));
}
