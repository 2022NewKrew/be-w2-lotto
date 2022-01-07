package domain;

import java.util.List;

//로또 번호 생성 및 저장, 결과
public interface Lotto {
    int MINNUM = 1;
    int MAXNUM = 45;
    int SIZE = 6;
    long PRICE = 1000;

    void createNum();

    void createNum(List<Integer> numbers);

    List<Integer> getNumbers();
}
