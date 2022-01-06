package com.kakao.lotto.model;

import com.kakao.lotto.view.UserLottoInput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author    : brody.moon
 * version   : 1.1
 * 유저 구매 로또 번호를 생성하는 클래스입니다.
 */
public class UserLotto {
    /**
     * 구매한 로또 번호들과 직접 값을 입력한 로또의 갯수를 가지고 있습니다.
     */
    private final List<LottoNumber> lottoNumbers;
    private final int numOfCustomLotto;
    private static final Random random = new Random();

    public UserLotto(UserLottoInput userLottoInput) {
        List<LottoNumber> tempCreatedNumber = userLottoInput.getCreatedCustomLotto();

        tempCreatedNumber.addAll(collectLottos(userLottoInput.getNumberOfAutoNumber()));

        lottoNumbers = tempCreatedNumber.stream()
                .map(LottoNumber::toUnmodifiableList)
                .collect(Collectors.toUnmodifiableList());
        numOfCustomLotto = userLottoInput.getNumberOfAllNumber() - userLottoInput.getNumberOfAutoNumber();
    }

    /**
     * 로또를 자동으로 생성해 반환하는 메서드입니다.
     *
     * @param numberOfAutoNumber 자동으로 생성할 로또 갯수
     * @return 생성한 로또들의 List
     */
    private List<LottoNumber> collectLottos(int numberOfAutoNumber) {
        return Stream.generate(this::createAutoNumber)
                .limit(numberOfAutoNumber)
                .collect(Collectors.toList());
    }

    /**
     * 로또 번호를 무한 스트림으로 생성하기 위한 메서드입니다.
     *
     * @return 생성한 로또 번호
     */
    private LottoNumber createAutoNumber() {
        return new LottoNumber(Stream.generate(() -> random.nextInt(ConstLottoConfig.LOTTO_NUMBER_RANGE) + 1)
                .distinct()
                .limit(ConstLottoConfig.LOTTO_PICK_NUMBER)
                .collect(Collectors.toSet()));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public Map<Integer, List<Integer>> printLottos(){
        Map<Integer, List<Integer>> tempMap = new HashMap<>();

        for(int i = 0 ; i < lottoNumbers.size() ; i++){
            tempMap.put(i, lottoNumbers.get(i).getAll().stream().sorted().collect(Collectors.toList()));
        }

        return tempMap;
    }

    public int getNumOfCustomLotto() {
        return numOfCustomLotto;
    }
}
