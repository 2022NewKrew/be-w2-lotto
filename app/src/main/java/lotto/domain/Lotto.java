package lotto.domain;

import lotto.util.Util;
import lotto.util.Rank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Lotto {

    private ArrayList<LottoGame> lottoGames;
    private int numberGames;
    private int moneyToGame;

    private ArrayList<Rank> winningCases = new ArrayList<>(Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH));

    public Lotto(int moneyToGame){
        this.lottoGames = new ArrayList<>();
        this.moneyToGame = moneyToGame;
        this.numberGames = calNumberGames(moneyToGame);

        for (int game=0;game < this.numberGames; game++){
            this.lottoGames.add(new LottoGame());
        }
    }

    private int calNumberGames(int money){
        return money/Util.LOTTOPRICE;
    }

    public void checkWinning(ArrayList<Integer> lastWinningNumbers, int bonusBall){
        int matchNumber;
        boolean matchBonus;

        for (LottoGame lottoGame : lottoGames){
            matchNumber = lottoGame.compareNumbers(lastWinningNumbers);
            matchBonus = lottoGame.compareBonusBall(bonusBall);
            insertWinNumbers(matchNumber, matchBonus);
        }
    }

    private void insertWinNumbers(int numberMatch, boolean matchBonus){
        for (Rank rank : winningCases){
            rank.checkAndCount(numberMatch, matchBonus);
        }
    }

    public int getNumberGames(){
        return this.numberGames;
    }

    public float checkWinningRate(){
        int sumPrize = 0;
        float winningRate;

        for (Rank rank : winningCases){
            sumPrize = sumPrize + rank.getResultCount()*rank.getWinningMoney();
        }
        winningRate = (sumPrize-(numberGames*Util.LOTTOPRICE))/(numberGames*Util.LOTTOPRICE);

        return winningRate;
    }

    public ArrayList<Rank> getWinningCases(){
        return winningCases;
    }
}
