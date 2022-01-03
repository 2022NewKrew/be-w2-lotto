package domain;

import java.util.List;

public class Result {

    private LottoRepository lottoRepository;
    private List<Integer> winningNums;
    private int[] prizeList = new int[7];
    private int totalMoney = 0;
    private int quantity;

    public Result(LottoRepository lottoRepository, List<Integer> winningNums) {
        this.lottoRepository = lottoRepository;
        this.winningNums = winningNums;
        this.quantity = lottoRepository.getList().size();
        setPrizeList();
    }


    private void setPrizeList() {
        for (List<Integer> lotto : lottoRepository.getList()) {
            prizeList[checkEqualNum(lotto)]++;
        }
    }

    public int[] getPrizeList() {
        return prizeList;
    }

    public int getQuantity() {
        return quantity;
    }

    private int checkEqualNum(List<Integer> lotto) {
        int res = 0;
        for (Integer num : winningNums) {
            res += lotto.contains(num) ? 1 : 0;
        }
        return res;
    }

    public long totalPrizeMoney() {
        return prizeList[3] * 5000 + prizeList[4] * 50000
                + prizeList[5] * 1500000 + prizeList[6] * 2000000000;
    }

}
