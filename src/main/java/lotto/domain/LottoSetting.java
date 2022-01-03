package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LottoSetting {
    final static public Integer LOTTO_PRICE = 1000; //each price of lotto
    final static public Integer LOTTO_LENGTH = 6; //each lotto length
    final static public List<Integer> LOTTO_NUMBER_ELEMENT = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10) ); //45까지 한번에 초기화 못할까..?
}
