package lotto;

public enum LottoGrade {
    SIXTH(6,0,"낙첨"),
    FIFTH(5, 5000,"3개 일치"),
    FORTH(4,50000,"4개 일치"),
    THIRD(3,1500000,"5개 일치"),
    SECOND(2, 30000000,"5개 일치, 보너스 볼 일치"),
    FIRST(1,2000000000, "6개 일치");

    private int grade;
    private int reward;
    private String condition;

    private LottoGrade(int grade, int reward, String condition) {
        this.grade = grade;
        this.reward = reward;
        this.condition = condition;
    }

    public int getReward() {
        return reward;
    }

    public String getCondition(){
        return condition + "(" + reward + "원)";
    }
}
