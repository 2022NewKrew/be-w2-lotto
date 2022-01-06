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

    private static final int START_INDEX_OF_PICK_UP = 0;
    private static final int LAST_INDEX_OF_PICK_UP = START_INDEX_OF_PICK_UP + LottoData.NUMBER_OF_PICK;

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private static final Stream<Integer> intStream = IntStream.rangeClosed(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER).boxed();
    private static final List<Integer> LOTTO_NUMBER_LIST = new ArrayList<Integer>(intStream.collect(Collectors.toList()));

    public static List<Integer> generatePickedNumber() throws PickedNumberFormatException {
        List<Integer> numberList = new ArrayList<>(LottoData.LOTTO_NUMBER_LIST);

        Collections.shuffle(numberList); // 뒤섞기
        List<Integer> pickedNumberList = numberList.subList(START_INDEX_OF_PICK_UP,LAST_INDEX_OF_PICK_UP); // 잘라내기
        Collections.sort(pickedNumberList); // 잘라낸 배열을 정렬
        return pickedNumberList; // 반환
    }
}
