package domain;

import constant.Constants;

import java.util.List;

public class Lotto {

    private final List<LottoTicket> lottoTickets;
    private LottoResults lottoResults;

    public Lotto(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int getNumberOfLottoTicket() {
        return lottoTickets.size();
    }

    public void print() {
        lottoTickets.forEach(LottoTicket::print);
    }

    public LottoResults getResult() {
        return lottoResults;
    }


    public void checkLottoResult(List<LottoNumber> winningNumbers) {
        lottoResults = new LottoResults();
        for (LottoTicket lottoTicket : lottoTickets) {
            match(winningNumbers, lottoTicket);
        }
    }

    public void printResult() {
        printLottoResultStatus();
        printYield();
    }

    private void printLottoResultStatus() {
        System.out.println("3개 일치 (5000원)- " + lottoResults.getCountBy(LottoResult.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + lottoResults.getCountBy(LottoResult.FOURTH) + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoResults.getCountBy(LottoResult.THIRD) + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoResults.getCountBy(LottoResult.FIRST) + "개");
    }

    private void printYield() {
        System.out.println("총 수익률은 " + (getEarnedMoney() / getPrice()) * 100 + "%입니다.");
    }

    public long getEarnedMoney() {
        return lottoResults.getCountBy(LottoResult.FIFTH) * LottoResult.FIFTH.getPrizeMoney()
                + lottoResults.getCountBy(LottoResult.FOURTH) * LottoResult.FOURTH.getPrizeMoney()
                + lottoResults.getCountBy(LottoResult.THIRD) * LottoResult.THIRD.getPrizeMoney()
                + lottoResults.getCountBy(LottoResult.FIRST) * LottoResult.FIRST.getPrizeMoney();
    }

    public long getPrice() {
        return lottoTickets.size() * Constants.LOTTO_PRICE;
    }

    private void match(List<LottoNumber> winningNumbers, LottoTicket lottoTicket) {
        int numberOfMatchedNumber = lottoTicket.getNumberOfMatchedNumber(winningNumbers);
        LottoResult.getLottoResultType(numberOfMatchedNumber).ifPresent(lottoResults::addLottoResult);
    }

}
