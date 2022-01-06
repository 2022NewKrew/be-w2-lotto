package be.w2.lotto.Domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static int TICKET_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        lottoNumbers = new ArrayList<>();
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.sort(this.lottoNumbers);
    }

    public static LottoNumbers getInstanceByIntList(List<Integer> numbers) throws IllegalArgumentException {
        LottoNumbers lottoNumbers = new LottoNumbers();
        for (int number : numbers) {
            LottoNumber lottonumber = new LottoNumber(number);
            isDuplicate(lottoNumbers, lottonumber);
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    private static void isDuplicate(LottoNumbers lottoNumbers, LottoNumber lottoNumber) throws IllegalArgumentException {
        if (lottoNumbers.contains(lottoNumber))
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다!");
    }

    public LottoNumbers getRandomTicketNumbers() {
        Collections.shuffle(lottoNumbers);
        return new LottoNumbers(lottoNumbers.subList(0, TICKET_SIZE));
    }

    public int calculateTicket(LottoNumbers answers) {
        int amount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (answers.contains(lottoNumber)) amount++;
        }
        return amount;
    }

    public void add(LottoNumber lottoNumber) {
        lottoNumbers.add(lottoNumber);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public String toString() {
        return lottoNumbers.toString();
    }

}
