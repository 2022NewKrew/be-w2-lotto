package lotto.domain;

import lotto.util.Util;
import java.util.ArrayList;

public class LottoGames {

    private ArrayList<LottoGame> lottoGames;
    private int numberGames;
    private int manualGames = 0;
    private int autoGames;

    private LottoGames(int moneyToGame){
        this.lottoGames = new ArrayList<>();
        this.numberGames = calNumberGames(moneyToGame);
        this.autoGames = numberGames;

        for (int game=0;game < this.numberGames; game++){
            this.lottoGames.add(LottoGame.of());
        }
    }

    public static LottoGames of(int moneyToGame){
        return new LottoGames(moneyToGame);
    }

    private int calNumberGames(int money){
        return money/Util.LOTTOPRICE;
    }

    public void inputManualNumbers(ArrayList<ArrayList<Integer>> manualNumbers){
        this.manualGames = manualNumbers.size();
        this.autoGames = numberGames - manualGames;
        validateGameNumber();
        for (int idx = 0; idx < manualNumbers.size(); idx++){
            lottoGames.set(idx,LottoGame.of(manualNumbers.get(idx)));
        }
    }

    private void validateGameNumber(){
        if (this.numberGames < manualGames){
            throw new IllegalArgumentException("수동 게임의 숫자가 가능한 게임 수보다 많습니다.");
        }
    }

    public ArrayList<LottoGame> getLottoGames(){
        return lottoGames;
    }

    public int getNumberGames(){
        return this.numberGames;
    }

    public int getManualGames(){
        return this.manualGames;
    }

    public int getAutoGames(){
        return this.autoGames;
    }

}
