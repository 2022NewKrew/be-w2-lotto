package domain;


import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoOrder {
    private final int purchasePrice;
    private final List<Lotto> lottoList;

    public LottoOrder(int purchasePrice, List<List<Integer>> numberLists) {
        validate(purchasePrice, numberLists);

        this.purchasePrice = purchasePrice;
        this.lottoList = numberLists.stream()
                .map(Lotto::new)
                .collect(toList());
    }

    private static void validate(int purchasePrice, List<List<Integer>> numberLists) {
        validatePurchasePrise(purchasePrice);
        validateNumberLists(numberLists);
    }

    private static void validatePurchasePrise(int purchasePrice){
        if(purchasePrice % Lotto.PRICE != 0){
            throw new IllegalArgumentException(
                    "로또 가격의 단위는 ".concat(String.valueOf(Lotto.PRICE)).concat("입니다."));
        }

        if(purchasePrice <= 0){
            throw new IllegalArgumentException("구매 금액은 양수로 적어주세요.");
        }
    }

    private static void validateNumberLists(List<List<Integer>> numberLists){
        for(List<Integer> numbers : numberLists){
            LottoNumbers.validate(numbers);
        }
    }

    public RewardResult matchingWith(WinningNumbers winningNumbers){
        List<RewardType> rewards
                = lottoList.stream()
                .map(lotto -> winningNumbers.matching(lotto.getLottoNumbers()))
                .collect(toList());

        return new RewardResult(rewards);
    }

    public List<List<Integer>> getLottoNumberLists(){
        return lottoList.stream()
                .map(Lotto::getLottoNumbers)
                .map(LottoNumbers::getLottoNumberList)
                .map(lottoNumbers -> lottoNumbers.stream()
                        .map(LottoNumber::getNumber).collect(toList()))
                .collect(toList());
    }
}
