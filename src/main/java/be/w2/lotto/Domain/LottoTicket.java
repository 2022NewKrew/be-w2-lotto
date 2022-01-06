package be.w2.lotto.Domain;

import java.util.List;

public class LottoTicket {

    public static int TICKET_SIZE = 6;
    public static int PRICE = 1000;

    private LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }


    public static LottoTicket getInstanceByIntList(List<Integer> list) throws IllegalArgumentException {
        if (list.size() != TICKET_SIZE)
            throw new IllegalArgumentException("숫자 갯수는 반드시 6개 이어야 합니다!");

        return new LottoTicket(LottoNumbers.getInstanceByIntList(list));
    }

    public static void subMoney(Amount amount, Money money) {
        money.sub(amount.fullPrice(PRICE));
    }

    public static Amount calculateAmount(Money money) {
        return money.calculateAmount(PRICE);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }


    public int calculateTicket(LottoNumbers answers) {
        return lottoNumbers.calculateTicket(answers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
