package model.datastructure;

import java.util.*;
import java.util.function.Consumer;

public class LottoNumber implements Iterable<Integer> {
    public static final int NUM_OF_NUMBERS = 6;
    public static final int LOW_BOUNDARY = 1;
    public static final int HIGH_BOUNDARY = 45;
    private final ArrayList<Integer> lottoNumbers = new ArrayList<>(NUM_OF_NUMBERS);

    public static LottoNumber randomLottoNumberFactory() throws Exception {
        // 랜덤 넘버 6개 만들어서 반환
        ArrayList<Integer> randomNumber = new Random().ints(LOW_BOUNDARY, HIGH_BOUNDARY)
            .distinct()
            .limit(NUM_OF_NUMBERS)
            .collect(ArrayList::new, List::add, List::addAll);

        return new LottoNumber(randomNumber);


    }

    public LottoNumber(ArrayList<Integer> lottoNumbers) throws Exception {
        // 로또 번호의 숫자가 너무 많거나 적으면 예외 생성
        if (lottoNumbers.size() != NUM_OF_NUMBERS) {
            throw new Exception(String.format("로또 번호의 갯수가 %d개 여야 하나, %d개가 입력되었습니다.", NUM_OF_NUMBERS, lottoNumbers.size()));
        }
        // 로또 번호에 중복이 있으면 예외 생성
        if (lottoNumbers.stream().distinct().count() != NUM_OF_NUMBERS) {
            throw new Exception("로또 번호에 중복이 있습니다.");
        }
        // 로또 번호의 범위가 1~45를 벗어나면 예외 생성
        if (lottoNumbers.stream().anyMatch(num -> num < LOW_BOUNDARY) || lottoNumbers.stream().anyMatch(num -> num > HIGH_BOUNDARY)) {
            throw new Exception(String.format("로또 번호의 범위( %d ~ %d )를 초과한 번호가 있습니다.", LOW_BOUNDARY, HIGH_BOUNDARY));
        }
        lottoNumbers.sort(Comparator.comparingInt(a -> a));
        // 로또 번호의 숫자가 정확하면 입력 후 생성자 종료
        this.lottoNumbers.addAll(lottoNumbers);

    }
    public int matchNumbers(LottoNumber otherNumber) {
        int result = 0;
        for (Integer integer : otherNumber) {
            result = result + this.contains(integer);
        }
        return result;
    }
    public int contains(Integer integer) {
        if (lottoNumbers.contains(integer)) {
            return 1;
        }
        return 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return lottoNumbers.iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        lottoNumbers.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return lottoNumbers.spliterator();
    }

    public int get(int i) {
        return lottoNumbers.get(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < NUM_OF_NUMBERS - 1; i++) {
            sb.append(lottoNumbers.get(i).toString());
            sb.append(", ");
        }
        sb.append(lottoNumbers.get(NUM_OF_NUMBERS - 1).toString());
        sb.append("]");
        return sb.toString();
    }

}
