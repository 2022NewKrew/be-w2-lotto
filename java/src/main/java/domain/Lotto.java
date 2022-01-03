package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
** 복권 가격, 당첨금 등 중요 정보를 담는 클래스, 복권 번호 생성 기능 수행
 */
public class Lotto {

    private static final int price = 1000;
    private static final int[] prize = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private List<Integer> numberList;

    public Lotto() {
        //1 ~ 45의 자연수를 갖는 리스트 생성
        numberList = IntStream
                .rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public Lottery generateLottery() {
        Collections.shuffle(numberList, new Random());
        return new Lottery(numberList.subList(0, 6));
    }

    public int getPrice() {
        return price;
    }

    public int getPrizeByMatchedNumberCount(int matchedNumberCount) {
        return prize[matchedNumberCount];
    }
}
