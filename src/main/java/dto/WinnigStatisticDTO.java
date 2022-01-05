package dto;

import java.util.List;

public class WinnigStatisticDTO {
    private List<Integer> prevWinningNumbers;
    private List<Integer> countOfTotalWinnings;


    public void setPrevWinningNumbers(List<Integer> prevWinningNumbers) {
        this.prevWinningNumbers = prevWinningNumbers;
    }

    public void setCountOfTotalWinnings(List<Integer> countOfTotalWinnings) { this.countOfTotalWinnings = countOfTotalWinnings; }

    public List<Integer> getPrevWinningNumbers() {
        return prevWinningNumbers;
    }

    public List<Integer> getCountOfTotalWinnings() { return countOfTotalWinnings; }
}
