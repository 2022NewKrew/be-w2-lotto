package com.kakao.lotto.step4.core;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoParser {

    public final static int LOTTO_PRICE = 1000;

    public int getLottoCount(String inputMoney) throws Exception {
        int price = Integer.valueOf(inputMoney);
        if(price < 0)
            throw new Exception("구입 금액은 양수여야합니다.");
        return price / LOTTO_PRICE;
    }

    private void checkLottoNumber(int number) throws RuntimeException {
        if(number < 1 || number > 45)
            throw new RuntimeException("1부터 45 사이의 수를 입력하세요");
    }

    private void checkDuplicate(List<Integer> lottoNumbers) throws RuntimeException {
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        if(lottoNumbers.size() != lottoSet.size())
            throw new RuntimeException("중복 요소가 있습니다.");
    }

    private void checkLottoCount(List<Integer> lottoNumbers) throws RuntimeException {
        if(lottoNumbers.size() != 6)
            throw new RuntimeException("6개의 숫자를 입력하세요");
    }

    private void validateLotto(Lotto lotto) throws RuntimeException {
        List<Integer> lottoNumbers = lotto.getLotto();
        for(int number : lottoNumbers)
            checkLottoNumber(number);
        checkDuplicate(lottoNumbers);
        checkLottoCount(lottoNumbers);
    }

    public Lotto stringToLotto(String lottoNumber) throws RuntimeException {
        Lotto lotto = new Lotto(Pattern.compile(", ").splitAsStream(lottoNumber)
                .map(string -> Integer.valueOf(string)).collect(Collectors.toList()));
        validateLotto(lotto);
        return lotto;
    }

    public List<Lotto> getManualLottos(String lottoNumbers) throws RuntimeException {
        if(lottoNumbers.isEmpty())
            return new ArrayList<>();
        List<Lotto> lottos = Arrays.stream(lottoNumbers.split("\r?\n"))
                .map(this::stringToLotto).collect(Collectors.toList());
        return lottos;
    }

    public int getBonusNumber(String stringBonusNumber) throws RuntimeException {
        int bonusNumber = Integer.valueOf(stringBonusNumber);
        checkLottoNumber(bonusNumber);
        return bonusNumber;
    }

}
