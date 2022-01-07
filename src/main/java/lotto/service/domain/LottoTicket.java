package lotto.service.domain;

import lotto.service.LottoGenerator;

import java.util.List;

public class LottoTicket {
    boolean isAuto = true;
    LottoNumbers lottoNumbers;
    LottoPrizeDetails prizeDetails = LottoPrizeDetails.UNIDENTIFIED;

    public LottoTicket(){
        lottoNumbers = LottoGenerator.autoGenerate();
    }

    public LottoTicket(LottoNumbers lottoNumbers) {
        isAuto = false;
        this.lottoNumbers = lottoNumbers;
    }

    public boolean isAuto() {
        return isAuto;
    }

    public LottoPrizeDetails getPrizeDetails() {
        return prizeDetails;
    }

    public long getPrizeMoney(){
        if(prizeDetails == LottoPrizeDetails.UNIDENTIFIED)
            throw new IllegalStateException("당첨번호가 확인되지 않았습니다.");
        return prizeDetails.getPrize();
    }

    public void setPrizeDetails(List<Integer> winningNumbers){
        int score = getLottoScore(winningNumbers);
        if(score >= 6)
            prizeDetails = LottoPrizeDetails.FIRST_PRIZE;
        else if(score == 5)
            this.prizeDetails = LottoPrizeDetails.THIRD_PRIZE;
        else if(score == 4)
            this.prizeDetails = LottoPrizeDetails.FOURTH_PRIZE;
        else if(score == 3)
            this.prizeDetails = LottoPrizeDetails.FIFTH_PRIZE;
        else
            this.prizeDetails = LottoPrizeDetails.NO_PRIZE;
    }

    public void setPrizeDetails(List<Integer> winningNumbers, int bonusNumber){
        if(prizeDetails == LottoPrizeDetails.UNIDENTIFIED)
            setPrizeDetails(winningNumbers);

        if(prizeDetails == LottoPrizeDetails.THIRD_PRIZE
                && containBonusNumber(bonusNumber))
            this.prizeDetails = LottoPrizeDetails.SECOND_PRIZE;

    }

    public void print() {
        System.out.println(lottoNumbers);
    }

    private int getLottoScore(List<Integer> winningNumbers){
        return (int)winningNumbers.stream().filter(lottoNumbers.getNumbers()::contains).count();
    }

    private boolean containBonusNumber(int bonusNumber){
        return lottoNumbers.getNumbers().contains(bonusNumber);
    }
}
