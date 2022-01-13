package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Set;
import lotto.view.InputView;
import lotto.util.Util;

public class LottoGame {

    private ArrayList<Integer> candidateNumbers;
    private ArrayList<Integer> generationNumbers = (ArrayList<Integer>) IntStream.rangeClosed(1, 46)
            .boxed()
            .collect(Collectors.toList());

    public LottoGame(){
        candidateNumbers = new ArrayList<>(getShuffledNumbers());
    }

    public LottoGame(ArrayList<Integer> manualCandidateNumbers){
        candidateNumbers = manualCandidateNumbers;
        Util.validateNumbersLength(candidateNumbers);
        Util.validateDuplicate(candidateNumbers);
    }

    public void setCandidateNumbers(ArrayList<Integer> manualCandidateNumbers){
        candidateNumbers = manualCandidateNumbers;
        Util.validateNumbersLength(candidateNumbers);
        Util.validateDuplicate(candidateNumbers);
    }

    private ArrayList<Integer> getShuffledNumbers(){
        Collections.shuffle(generationNumbers);
        return new ArrayList<Integer>(generationNumbers.subList(0,Util.LOTTONUMBERSIZE));
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

    public ArrayList<Integer> getCandidateNumbers(){
        return candidateNumbers;
    }
}
