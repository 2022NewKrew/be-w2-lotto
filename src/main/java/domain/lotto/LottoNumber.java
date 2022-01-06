package domain.lotto;

import java.util.*;
import java.util.function.Consumer;

public class LottoNumber implements Iterable<Integer> {
    public static final int NUM_OF_NUMBERS = 6;
    public static final int LOW_BOUNDARY = 1;
    public static final int HIGH_BOUNDARY = 45;
    public static final int LOTTO_UNIT_PRICE = 1000;
    private final ArrayList<Integer> lottoNumbers = new ArrayList<>();

    public static LottoNumber randomLottoNumberFactory() throws Exception {
        ArrayList<Integer> randomNumber = new Random().ints(LOW_BOUNDARY, HIGH_BOUNDARY)
            .distinct().limit(NUM_OF_NUMBERS).sorted()
            .collect(ArrayList::new, List::add, List::addAll);
        return new LottoNumber(randomNumber);
    }

    public LottoNumber(ArrayList<Integer> lottoNumbers) throws Exception {
        validateLottoNumberSize(lottoNumbers.size());
        validateLottoNumberDistict(lottoNumbers);
        validateLottoNumberRange(lottoNumbers);

        lottoNumbers.sort(Comparator.comparingInt(a -> a));
        this.lottoNumbers.addAll(lottoNumbers);
    }

    private void validateLottoNumberSize(int size) throws Exception{
        if (size != NUM_OF_NUMBERS) {
            throw new Exception(String.format("로또 번호의 갯수가 %d개 여야 하나, %d개가 입력되었습니다.", NUM_OF_NUMBERS, lottoNumbers.size()));
        }
    }
    private void validateLottoNumberDistict(ArrayList<Integer> lottoNumbers) throws Exception{
        if (lottoNumbers.stream().distinct().count() != NUM_OF_NUMBERS) {
            throw new Exception("로또 번호에 중복이 있습니다.");
        }
    }
    private void validateLottoNumberRange(ArrayList<Integer> lottoNumbers) throws Exception{
        if (lottoNumbers.stream().anyMatch(num -> num < LOW_BOUNDARY) || lottoNumbers.stream().anyMatch(num -> num > HIGH_BOUNDARY)) {
            throw new Exception(String.format("로또 번호의 범위( %d ~ %d )를 초과한 번호가 있습니다.", LOW_BOUNDARY, HIGH_BOUNDARY));
        }
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

    public ArrayList<Integer> getLottoNumbers() {
        return lottoNumbers;
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

    public LottoNumberDTO getDTO() {
        return new LottoNumberDTO(lottoNumbers);
    }

}
