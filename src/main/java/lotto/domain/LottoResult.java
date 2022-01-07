package lotto.domain;

import lotto.util.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoResult {
    private final LottoPaper lp;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private static final StringBuilder sb = new StringBuilder();
    private final Map<Integer, Integer> rank = new HashMap<>(Map.of(
            5, 0,
            4, 0,
            3, 0,
            2, 0,
            1, 0
    ));
    public String message;
    public long totalRateOfReturn;


    public LottoResult(LottoPaper lottopaper, String winningNumber, String bn){
        lp = lottopaper;
        winningNumbers = LottoInput.postPurchase(winningNumber);
        bonusNumber = LottoInput.getBonusNumber(bn);
    }


    public void updateMessage(){
        for(LottoRank lr : LottoRank.values()){
            rankToString(lr);
        }
        message = sb.toString();
    }


    private void rankToString(LottoRank lr){
        sb.append(lr.getCountOfMatch() + "개 일치");
        if(lr.getResultRank() == 2){
            sb.append(", 보너스 불 일치");
        }
        sb.append("("+ lr.getWinningPrize() +"원) - " + rank.get(lr.getResultRank()) + "개\n");
    }

    /**
     * 각각의 로또 줄을 확인하며, 일치하는 번호 수, 보너스 볼 당첨 여부를 파악하여 업데이트하는 메소드
     */
    public void searchResult(){
        for(LottoNumbers ln : lp.lottoNumbers){
            int countOfMatch = intersection(ln.getNumbers());
            boolean matchBonus = ln.getNumbers().contains(bonusNumber);
            LottoRank lr = LottoRank.valueOf(countOfMatch, matchBonus);
            updateRank(lr);
        }
    }

    /**
     * 확인된 랭크에 당첨 횟수를 추가하는 메소드
     * @param lr 확인된 LottoRank
     */
    private void updateRank(LottoRank lr){
        if(lr != null){
            int rankIdx = lr.getResultRank();
            rank.put(rankIdx, rank.get(rankIdx)+1);
        }
    }


    /**
     * 교집합을 통해 일치하는 숫자 수를 확인하는 메소드
     * @param lottoPaper 로또 한 줄
     * @return 당첨 번호와 일치하는 숫자 수
     */
    private int intersection(List<Integer> lottoPaper){
        Set<Integer> intSet = lottoPaper.stream()
                .distinct()
                .filter(winningNumbers::contains)
                .collect(Collectors.toSet());
        return intSet.size();
    }

    /**
     * 수익률을 계산하는 메소드
     */
    public void calculatePrize(){
        long sum = 0;
        for(LottoRank lr : LottoRank.values()){
            int matchPrize = lr.getWinningPrize();
            int resultRank = lr.getResultRank();
            sum += (long) matchPrize * rank.get(resultRank);
        }
        totalRateOfReturn = (sum-lp.inputPrice) / lp.inputPrice * 100;
    }
}
