package domain;

import java.util.List;

//로또 번호 생성 및 저장, 결과
public interface ILotto {
    int MINNUM = 1;
    int MAXNUM = 45;
    int SIZE = 6;
    long PRICE = 1000;

    public void createNum();

    public void createNum(List<Integer> numbers);

    public List<Integer> getNumbers();
}
