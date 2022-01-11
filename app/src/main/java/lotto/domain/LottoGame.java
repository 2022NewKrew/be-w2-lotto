package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import lotto.view.Interface;
import lotto.util.Util;

public class LottoGame {

    private ArrayList<Integer> candidateNumbers;

    public static ArrayList<Integer> getShuffledNumbers(){
        ArrayList<Integer> candidateNumbers = new ArrayList<>();
        for (int idx = 1; idx <= 45; idx++){
            candidateNumbers.add(idx);
        }
        Collections.shuffle(candidateNumbers);
        return new ArrayList<Integer>(candidateNumbers.subList(0,Util.LOTTONUMBERSIZE));
    }

    public LottoGame(){
        candidateNumbers = new ArrayList<>(getShuffledNumbers());
        Interface.displayCandidateNumber(candidateNumbers);
    }

    public int compareNumbers(ArrayList<Integer> lastWinningNumbers){
        int numberContains;

        numberContains = candidateNumbers
                .stream()
                .filter(integer -> lastWinningNumbers.contains(integer))
                .collect(Collectors.toList())
                .size();

        return numberContains;
    }

    public boolean compareBonusBall(int bonusNumber){
        return candidateNumbers.contains(bonusNumber);
    }
}
