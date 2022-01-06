package lottery.web.dto;

import java.util.ArrayList;

public class BudgetAndManualLotteryDto extends BudgetDto{

    public ArrayList<LotteryDto> getManualLotteryBundle() {
        return manualLotteryBundle;
    }

    private ArrayList<LotteryDto> manualLotteryBundle = new ArrayList<>();

    public BudgetAndManualLotteryDto(int budget, ArrayList<ArrayList<Integer>> manualLotteryBundle) {
        super(budget);
        for (ArrayList<Integer> el : manualLotteryBundle) {
            this.manualLotteryBundle.add(new LotteryDto(el));
        }
    }

}
