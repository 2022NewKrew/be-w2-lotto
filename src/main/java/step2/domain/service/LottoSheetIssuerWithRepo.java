package step2.domain.service;

import step2.domain.IssueConditionType;
import step2.domain.Lotto;
import step2.domain.LottoConfig;
import step2.domain.LottoSheetWithId;
import step2.repository.LottoSheetRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSheetIssuerWithRepo implements LottoSheetIssuer {

    // 랜덤 번호 생성을 위한 전체 번호 리스트
    private static List<Integer> SHUFFLED_LOTTO_NUMBER_LIST = IntStream.rangeClosed(Lotto.LOTTO_MIN_NUM, Lotto.LOTTO_MAX_NUM).boxed().collect(Collectors.toList());

    // LottoSheet 저장 담당
    private final LottoSheetRepository lottoSheetRepository;

    public LottoSheetIssuerWithRepo(LottoSheetRepository lottoSheetRepository) {
        this.lottoSheetRepository = lottoSheetRepository;
    }

    // LottoSheet 를 생성하고 Repository에 저장
    @Override
    public LottoSheetWithId issueLottoSheet(LottoConfig lottoConfig) {
        LottoSheetWithId lottoSheetWithId = issueAutoOrManual(lottoConfig);
        return lottoSheetRepository.save(lottoSheetWithId);
    }

    // 자동 구매와 수동 구매 구분
    private LottoSheetWithId issueAutoOrManual(LottoConfig lottoConfig){
        if (lottoConfig.getIssueCondition() == IssueConditionType.AUTO)
            return issueLottoSheetAuto(lottoConfig);
        return issueLottoSheetManual(lottoConfig);
    }

    // 자동 구매
    private LottoSheetWithId issueLottoSheetAuto(LottoConfig lottoConfig) {
        final int numberOfLotto = lottoConfig.getPurchaseAmount() / PRICE;
        List<Lotto> lottoList = new ArrayList<>();
        IntStream.range(0, numberOfLotto)
                .forEach(i -> lottoList.add(new Lotto(generateRandomNumber())));
        return new LottoSheetWithId(lottoList);
    }

    // 수동 구매
    private LottoSheetWithId issueLottoSheetManual(LottoConfig lottoConfig) {
        List<Lotto> lottoList = new ArrayList<>();
        lottoConfig.getUserInputLottoList()
                .forEach(userInput -> lottoList.add(new Lotto(generateNumberByUser(userInput))));
        return new LottoSheetWithId(lottoList);
    }

    // 랜덤 번호 생성 함수
    private List<Integer> generateRandomNumber() {
        Collections.shuffle(SHUFFLED_LOTTO_NUMBER_LIST);
        return new ArrayList<>(SHUFFLED_LOTTO_NUMBER_LIST.subList(0, Lotto.THE_NUMBER_OF_LOTTO));
    }

    private List<Integer> generateNumberByUser(List<Integer> lottoNumbers) {
        return lottoNumbers;
    }

}
