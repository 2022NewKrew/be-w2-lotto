package lotto.domain;

import lotto.util.Rank;
import lotto.util.Util;

import java.util.*;

public class WinningLotto {
    private ArrayList<LottoNumber> candidateNumbers;
    private LottoNumber bonusBall;
    private List<Rank> winningCases = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH);
    private float winningRate = 0;

    private WinningLotto(ArrayList<Integer> manualCandidateNumbers, int bonusBall){
        this.bonusBall = LottoNumber.of(bonusBall);
        this.candidateNumbers = toLottoNumber(manualCandidateNumbers);

        validateNumbersLength(candidateNumbers);
        validateDuplicate(candidateNumbers);
    }

    public static WinningLotto of(ArrayList<Integer> manualCandidateNumbers, int bonusBall){
        return new WinningLotto(manualCandidateNumbers, bonusBall);
    }

    public void checkWinning(ArrayList<LottoGame> lottoGames){
        for (LottoGame lottoGame : lottoGames){
            int matchNumber = lottoGame.compareNumbers(candidateNumbers);
            boolean matchBonus = lottoGame.compareBonusBall(bonusBall);
            insertWinNumbers(matchNumber, matchBonus);
        }
        checkWinningRate(lottoGames.size());
    }

    private void insertWinNumbers(int numberMatch, boolean matchBonus){
        for (Rank rank : winningCases){
            rank.checkAndCount(numberMatch, matchBonus);
        }
    }

    public static void validateNumbersLength(ArrayList<LottoNumber> candidateNumbers){
        if (candidateNumbers.size() != Util.LOTTONUMBERSIZE){
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    public static void validateDuplicate(ArrayList<LottoNumber> candidateNumbers){
        Set<LottoNumber> nunDuplicateNumbers = new HashSet<>(candidateNumbers);
        if (nunDuplicateNumbers.size() != Util.LOTTONUMBERSIZE){
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }

    private void checkWinningRate(int numberGames){
        int sumPrize = 0;

        for (Rank rank : winningCases){
            sumPrize = sumPrize + rank.getResultCount()*rank.getWinningMoney();
        }
        this.winningRate = (sumPrize-(numberGames*Util.LOTTOPRICE))/(numberGames*Util.LOTTOPRICE);
    }

    private ArrayList<LottoNumber> toLottoNumber(ArrayList<Integer> manualCandidateNumbers){
        ArrayList<LottoNumber> generationNumbers = new ArrayList<>();
        for (Integer num : manualCandidateNumbers){
            generationNumbers.add(LottoNumber.of(num));
        }
        return generationNumbers;
    }

    public float getWinningRate(){
        return winningRate;
    }

    public List<Rank> getWinningCases(){
        return winningCases;
    }

}
