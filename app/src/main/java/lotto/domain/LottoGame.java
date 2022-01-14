package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.Set;

import lotto.util.Util;

public class LottoGame {

    private static ArrayList<LottoNumber> generationNumberCache = new ArrayList<>();
    static {
        IntStream.range(1,46).forEach((i) -> generationNumberCache.add(LottoNumber.of(i)));
    }
    private ArrayList<LottoNumber> candidateNumbers;

    private LottoGame(){
        candidateNumbers = new ArrayList<LottoNumber>(getShuffledNumbers());
    }

    private LottoGame(ArrayList<Integer> manualCandidateNumbers){
        candidateNumbers = toLottoNumber(manualCandidateNumbers);
        validateNumbersLength(candidateNumbers);
        validateDuplicate(candidateNumbers);
    }

    public static LottoGame of(){
        return new LottoGame();
    }

    public static LottoGame of(ArrayList<Integer> manualCandidateNumbers){
        return new LottoGame(manualCandidateNumbers);
    }

    private ArrayList<LottoNumber> getShuffledNumbers(){
        Collections.shuffle(generationNumberCache);
        return new ArrayList<LottoNumber>(generationNumberCache.subList(0,Util.LOTTONUMBERSIZE));

    }

    public int compareNumbers(ArrayList<LottoNumber> lastWinningNumbers){
        int numberContains;
        numberContains = (int) lastWinningNumbers.stream().filter(lottoNumber -> contains(lottoNumber)).count();
        return numberContains;
    }

    private boolean contains(LottoNumber lottoNumber){
        for (LottoNumber compareNumber : candidateNumbers){
            if (compareNumber.equals(lottoNumber)){
                return true;
            }
        }
        return false;
    }

    public boolean compareBonusBall(LottoNumber bonusNumber){
        return contains(bonusNumber);
    }

    private ArrayList<LottoNumber> toLottoNumber(ArrayList<Integer> manualCandidateNumbers){
        ArrayList<LottoNumber> generationNumbers = new ArrayList<>();
        for (Integer num : manualCandidateNumbers){
            generationNumbers.add(LottoNumber.of(num));
        }
        return generationNumbers;
    }

    private ArrayList<Integer> toIntegerArray(ArrayList<LottoNumber> candidateNumbers){
        ArrayList<Integer> generationNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : candidateNumbers){
            generationNumbers.add(lottoNumber.getLottoNumber());
        }
        return generationNumbers;
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

    public ArrayList<Integer> getCandidateNumbers(){
        return toIntegerArray(candidateNumbers);
    }
}
