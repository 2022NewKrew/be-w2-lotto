package lotto.domain;

import lotto.util.Util;
import lotto.util.Rank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Lotto {

    final private ArrayList<LottoGame> lottoGames;
    final private int numberGames;
    private int manualGames = 0;
    private int autoGames;

    private ArrayList<Rank> winningCases = new ArrayList<>(Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH));

    public Lotto(int moneyToGame){
        this.lottoGames = new ArrayList<>();
        this.numberGames = calNumberGames(moneyToGame);
        this.autoGames = numberGames;

        for (int game=0;game < this.numberGames; game++){
            this.lottoGames.add(new LottoGame());
        }
    }

    public void inputManualNumbers(ArrayList<ArrayList<Integer>> manualNumbers){
        this.manualGames = manualNumbers.size();
        this.autoGames = numberGames - manualGames;
        for (int idx = 0; idx < manualNumbers.size(); idx++){
            lottoGames.set(idx,new LottoGame(manualNumbers.get(idx)));
        }
    }

    private int calNumberGames(int money){
        return money/Util.LOTTOPRICE;
    }

    public void checkWinning(ArrayList<Integer> lastWinningNumbers, int bonusBall){
        int matchNumber;
        boolean matchBonus;

        Util.validateNumbersLength(lastWinningNumbers);
        Util.validateDuplicate(lastWinningNumbers);

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

    public int getManualGames(){
        return this.manualGames;
    }

    public int getAutoGames(){
        return this.autoGames;
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

    public ArrayList<ArrayList> getLottoGames(){
        ArrayList<ArrayList> lottoGamesNumbers = new ArrayList<>();
        for (LottoGame lottoGame: lottoGames){
            lottoGamesNumbers.add(lottoGame.getCandidateNumbers());
        }
        return lottoGamesNumbers;
    }
}
