package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements IUser{
    private final long price;
    private final List<Lotto> lottoList;
    private final int numberOfBuy;
    private final int numberOfManual;
    private final WinningLotto winning;
    private double profitRatio=0;
    private int profit=0;
    private Map<Ranking, Integer> ranking = new HashMap<>();

    OutputView outputView = OutputView.getInstance();

    private final static InputView inputView = InputView.getInstance();

    public User() {
        this.price = inputView.inputPrice();
        this.numberOfBuy = (int) (this.price / ILotto.PRICE);
        this.numberOfManual = inputView.inputNumberOfManual();
        List<String> manualList = inputView.inputManual(numberOfManual);
        this.lottoList = new ArrayList<>();
        for (String manual : manualList) {
            lottoList.add(new Lotto(stringToList(manual)));
        }
        for(int i=numberOfManual; i<numberOfBuy; i++) {
            lottoList.add(new Lotto());
        }
        outputView.printNumberOfBuy(numberOfManual, numberOfBuy-numberOfManual);
        outputView.printLottoList(lottoList);

        this.winning = new WinningLotto(stringToList(inputView.inputWinning()), inputView.inputBonus());

        lotteryDraw();
    }

    public void lotteryDraw(){
        for (Ranking rank : Ranking.values()) {
            ranking.put(rank, 0);
        }

        for(Lotto lotto : lottoList){
            int same = winning.getCountOfSame(lotto);
            boolean matchBonus = winning.mathBonus(lotto);
            Ranking rank = Ranking.valueOf(same, matchBonus);
            ranking.replace(rank, ranking.get(rank)+1);
        }

        calculateProfit();
        calculateProfitRatio();
    }
    private void calculateProfit() {
        profit = 0;
        for (Ranking rank : Ranking.values()){
            profit += rank.getPrice() * ranking.get(rank);
        }
    }
    private void calculateProfitRatio(){
        profitRatio = (double) (profit - price) / price * 100;
    }

    public long getPrice() { return this.price; }

    public int getNumberOfBuy() { return this.numberOfBuy; }

    public int getNumberOfManual() { return this.numberOfManual; }

    public List<Lotto> getLottoList() { return this.lottoList; }

    public double getProfitRatio() { return this.profitRatio; }

    public int getProfit() { return this.profit; }

    public Integer getRanking(Ranking rank) { return this.ranking.get(rank); }
}
