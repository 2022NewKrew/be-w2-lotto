package view.model;

public class WinningStatisticalData implements Comparable<WinningStatisticalData> {

    private final Integer winningCount;

    private final Boolean matchBonus;

    private final Long winnings;

    private final Integer count;

    public WinningStatisticalData(Integer winningCount, Boolean matchBonus, Long winnings, Integer count) {
        this.winningCount = winningCount;
        this.matchBonus = matchBonus;
        this.winnings = winnings;
        this.count = count;
    }

    public Integer getWinningCount() {
        return winningCount;
    }

    public Long getWinnings() {
        return winnings;
    }

    public Integer getCount() {
        return count;
    }

    public Boolean getMatchBonus() {
        return matchBonus;
    }

    @Override
    public int compareTo(WinningStatisticalData o) {
        return this.winnings.compareTo(o.winnings);
    }
}
