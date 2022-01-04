package lotto.service.domain;

import java.util.List;

public class LottoTicket {
    LottoNumbers lottoNumbers;
    LottoPrizeDetails prizeDetails = LottoPrizeDetails.UNIDENTIFIED;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoPrizeDetails getPrizeDetails() {
        return prizeDetails;
    }

    public long getPrizeMoney(){
        if(prizeDetails == LottoPrizeDetails.UNIDENTIFIED)
            throw new IllegalStateException("당첨번호가 확인되지 않았습니다.");
        return prizeDetails.getPrize();
    }

    public void setPrizeDetails(LottoPrizeDetails prizeDetails) {
        this.prizeDetails = prizeDetails;
    }

    public void print() {
        System.out.println(lottoNumbers);
    }
}
