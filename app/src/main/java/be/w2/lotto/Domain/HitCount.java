package be.w2.lotto.Domain;

public enum HitCount {

    THREE(3, 5000, false, "3개 일치 (5000원)"),
    FOUR(4, 50000, false, "4개 일치 (50000원)"),
    FIVE(5, 1500000, false, "5개 일치 (1500000원)"),
    FIVE_BONUS(5, 30000000, true, "5개 일치, 보너스 볼 일치 (30000000원)"),
    SIX(6, 2000000000, false, "6개 일치 (2000000000원)");

    private final int hitCount;
    private final int price;
    private final boolean isBonus;
    private final String message;

    HitCount(int hitCount, int price, boolean isBonus, String message) {
        this.hitCount = hitCount;
        this.price = price;
        this.isBonus = isBonus;
        this.message = message;
    }

    public static HitCount valueOf(int hitCount, boolean isBonus) {
        if (hitCount == 3 && isBonus == false)
            return THREE;
        if (hitCount == 4 && isBonus == false)
            return FOUR;
        if (hitCount == 5 && isBonus == false)
            return FIVE;
        if (hitCount == 5 && isBonus == true)
            return FIVE_BONUS;
        if (hitCount == 6 && isBonus == false)
            return SIX;
        return null;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
