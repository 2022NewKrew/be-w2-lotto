package lotto.util;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Util {
    public static final int LOTTOPRICE = 1000;
    public static final int LOTTONUMBERSIZE = 6;

    public static void validateNumbersLength(ArrayList<Integer> candidateNumbers){
        if (candidateNumbers.size() != Util.LOTTONUMBERSIZE){
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    public static void validateDuplicate(ArrayList<Integer> candidateNumbers){
        Set<Integer> nunDuplicateNumbers = new HashSet<>(candidateNumbers);
        if (nunDuplicateNumbers.size() != Util.LOTTONUMBERSIZE){
            throw new IllegalArgumentException("로또 번호들은 중복될 수 없습니다.");
        }
    }
}
