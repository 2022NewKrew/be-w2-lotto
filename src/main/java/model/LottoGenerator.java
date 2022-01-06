package model;

import model.Lotto;
import util.Util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final List<Integer> candidateNumbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());

    public LottoGenerator() {
    }

    public List<Lotto> createAutoLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateNumbers()));
        }
        return lottos;
    }

    public List<Lotto> createManualLotto(List<List<Integer>> lottoNumbers){
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> lottoNumber : lottoNumbers) {
            lottos.add(new Lotto(Util.convertIntegerListToLottoList(lottoNumber)));
        }
        return lottos;
    }

    private List<LottoNumber> generateNumbers() {
        Collections.shuffle(candidateNumbers);
        List<Integer> sortedNumbers = new ArrayList<>(candidateNumbers.subList(0, 6));
        Collections.sort(sortedNumbers);

        return Util.convertIntegerListToLottoList(sortedNumbers);
    }
}
