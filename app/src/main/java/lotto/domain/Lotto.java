package lotto.domain;

import lotto.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Lotto {

    private ArrayList<LottoGame> lottoGames;
    private ArrayList<Integer> matchNumbers = new ArrayList<>(Collections.nCopies(Util.LOTTONUMBERSIZE +1, 0));
    private int numberGames;
    private int moneyToGame;

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

    public void checkWinning(ArrayList<Integer> lastWinningNumbers){
        LottoGame currentGame;
        int win;
        for (int game=0; game < this.numberGames; game++){
            currentGame = lottoGames.get(game);
            win = currentGame.compareNumbers(lastWinningNumbers);
            insertWinNumbers(win);
        }

        System.out.print(matchNumbers);
    }

    private void insertWinNumbers(int numberMatch){
        matchNumbers.set(numberMatch, matchNumbers.get(numberMatch)+1);
    }

    public int getNumberGames(){
        return this.numberGames;
    }

    public ArrayList<Float> getLottoResults(){
        ArrayList<Float> lottoResults = new ArrayList<>(matchNumbers.subList(3,7).stream().map(integer -> integer.floatValue()).collect(Collectors.toList()));
        lottoResults.add(checkWinningRate());
        return lottoResults;
    }

    private float checkWinningRate(){
        int sumPrize;
        float winningRate;
        sumPrize = matchNumbers.get(3)*Util.MATCH3PRICE +
                matchNumbers.get(4)*Util.MATCH4PRICE +
                matchNumbers.get(5)*Util.MATCH5PRICE +
                matchNumbers.get(6)*Util.MATCH6PRICE;
        winningRate = (sumPrize-(numberGames*Util.LOTTOPRICE))/(numberGames*Util.LOTTOPRICE);

        return winningRate;
    }
}
