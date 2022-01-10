package lotto.util;

public class Util {

    public static final int LOTTOPRICE = 1000;
    public static final int LOTTONUMBERSIZE = 6;
    public static final int MATCH3PRICE = 5000;
    public static final int MATCH4PRICE = 50000;
    public static final int MATCH5PRICE = 1500000;
    public static final int MATCH6PRICE = 2000000000;
    public static int getNumberGames(int money){
        return money/ LOTTOPRICE;
    }

}
