package controller;

import model.Lotto;

import java.util.*;

public class LottoGenerator {
    private static List<Integer> candidateNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45));

    private static Random random = new Random();

    private LottoGenerator() {
    }

    public static List<Lotto> createAutoLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return lottos;
    }

    private static List<Integer> generateNumbers() {
        Collections.shuffle(candidateNumbers);
        List<Integer> sortedNumbers = new ArrayList<>(candidateNumbers.subList(0, 6));
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }
}
