package lottery.domain.lotteries;

import java.util.ArrayList;

public class LotteryRepository {

    private ArrayList<LotteryEntity> listOfLotteries = new ArrayList<>();

    public void save(LotteryEntity lotteryEntity) {
        listOfLotteries.add(lotteryEntity);
    };

    public ArrayList<LotteryEntity> findAll() {
        return listOfLotteries;
    }

}
