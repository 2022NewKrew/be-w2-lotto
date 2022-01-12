package lotto.collections;

import lotto.utils.Rank;

public class AnsLottoLine {
    private LottoLine ansLottoLine;
    private LottoNumber bonusNum;

    public AnsLottoLine(LottoLine ansLottoLine, LottoNumber bonusNum) {
        this.ansLottoLine = ansLottoLine;
        this.bonusNum = bonusNum;
    }

    public LottoNumber getBonusNum(){
        return this.bonusNum;
    }

    // count the matching numbers(using Rank)
    public Rank countMatch(LottoLine lottoLine){

        int cnt = 0;
        for (LottoNumber iterNum : lottoLine){
            cnt += countMatchNum(iterNum);
        }
        //check bonus num is matched
        boolean bonusMatch = lottoLine.contains(getBonusNum());
        Rank rank = Rank.valueOf(cnt, bonusMatch);
        return rank;

    }

    public int countMatchNum(LottoNumber lottoNumber){
        if (this.ansLottoLine.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
