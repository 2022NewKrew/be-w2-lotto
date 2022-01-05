package domain;

import java.util.stream.Stream;

public enum Ranking {

    FIRST(2000000000, 6, "%d개 일치 (%d원)- %d개\n"),
    SECOND(30000000, 5, "%d개 일치, 보너스 볼 일치(%d원)- %d개\n"),
    THIRD(1500000, 5, "%d개 일치 (%d원)- %d개\n"),
    FORTH(50000, 4, "%d개 일치 (%d원)- %d개\n"),
    FIFTH(5000, 3, "%d개 일치 (%d원)- %d개\n"),
    FAIL(0, 0);

    private final int sameNumber;
    private final long price;
    private final String PRINT_FORMAT;


    Ranking(int price, int sameNumber, String printFormat){
        this.price = price;
        this.sameNumber = sameNumber;
        this.PRINT_FORMAT = printFormat;
    }
    Ranking(int price, int sameNumber){
        this(price, sameNumber, "");
    }

    public long getPrice() { return this.price; }
    public int getSameNumber() {return sameNumber;}
    public String getPRINT_FORMAT() {return PRINT_FORMAT;}

    public boolean isEqual(int sameNumber) { return this.sameNumber == sameNumber; }

    public static Stream<Ranking> stream () {
        return Stream.of(FIFTH, FORTH, THIRD, SECOND, FIRST);
    }

    public static Ranking valueOf(int sameNumber, boolean matchBounus) {
        return stream().filter(rank -> rank.isEqual(sameNumber))
                .filter(rank -> !rank.equals(SECOND) || matchBounus) //second, false 제외
                .filter(rank -> !rank.equals(THIRD) || !matchBounus) //third, true 제외
                .findFirst()
                .orElse(FAIL);
    }
}
