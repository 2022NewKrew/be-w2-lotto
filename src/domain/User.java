package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements IUser{
    private final int price;
    private final List<Lotto> lottoList;
    private final int numberOfBuy;
    private final WinningLotto winning;
    private double yield=0;
    private int totalReward=0;
    private Map<Ranking, Integer> ranking = new HashMap<>();

    OutputView outputView = OutputView.getInstance();

    private final static InputView inputView = InputView.getInstance();

    public User() {
        this.price = inputView.inputPrice();
        this.numberOfBuy = this.price/ILotto.PRICE;
        outputView.printNumberOfBuy(numberOfBuy);

        this.lottoList = new ArrayList<>();
        for(int i=0; i<this.numberOfBuy; i++) {
            lottoList.add(new Lotto());
        }
        outputView.printLottoList(lottoList);

        this.winning = new WinningLotto(stringToList(inputView.inputWinning()));

        lotteryDraw();
    }

    public void lotteryDraw(){
        for (Ranking rank : Ranking.values()) {
            ranking.put(rank, 0);
        }

        for(Lotto lotto : lottoList){
            int same = winning.getCountOfSame(lotto);
            Ranking rank = Ranking.valueOf(same);
            ranking.replace(rank, ranking.get(rank)+1);
        }

        calculateReward();
        calculateYied();
    }
    private void calculateReward() {
        totalReward = 0;
        for (Ranking rank : Ranking.values()){
            totalReward += rank.getPrice() * ranking.get(rank);
        }
    }
    private void calculateYied(){
        yield = (double) (totalReward - price) / price * 100;
    }

    public int getPrice() { return this.price; }

    public int getNumberOfBuy() { return this.numberOfBuy; }

    public List<Lotto> getLottoList() { return this.lottoList; }

    public double getYield() { return this.yield; }

    public int getTotalReward() { return this.totalReward; }

    public Map<Ranking, Integer> getRanking() { return this.ranking; }
}
