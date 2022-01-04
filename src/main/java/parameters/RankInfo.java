package parameters;

public class RankInfo {
    private final int count;
    private final boolean bonus;
    public RankInfo(int count, boolean bonus){
        this.count = count;
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof RankInfo)) return false;

        RankInfo other = (RankInfo)obj;
        return count == other.getCount() && bonus == other.getBonus();
    }

    @Override
    public int hashCode() { return count * 10 + (bonus? 1 : 0); }

    public int getCount() { return count; }
    public boolean getBonus() { return bonus; }
}
