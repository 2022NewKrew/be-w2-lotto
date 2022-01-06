package com.kakao.data;

import com.kakao.exception.PickedNumberFormatException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoData {
    private LottoData(){}

    public static final int PRICE_OF_LOTTO = 1000; // 가격
    public static final int NUMBER_OF_PICK = 6; // 선택할 숫자의 갯수

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    public static final int DEFAULT_INTEGER_VALUE = 0;
}
