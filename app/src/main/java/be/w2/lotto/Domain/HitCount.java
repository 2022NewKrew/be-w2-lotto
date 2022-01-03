package be.w2.lotto.Domain;

public enum HitCount {

    THREE(3, 5000), FOUR(4, 50000), FIVE(5, 1500000), SIX(6,2000000000);

    private final int hitCount;
    private final int price;

    HitCount(int hitCount, int price){
        this.hitCount = hitCount;
        this.price = price;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getPrice() {
        return price;
    }
}
