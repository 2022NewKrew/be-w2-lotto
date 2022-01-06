package be.w2.lotto.lottos;

import be.w2.lotto.exceptions.LottoNumberDuplicationFoundedException;
import be.w2.lotto.messages.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static int LENGTH = 6;

    protected List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkForRedundancy(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private void checkForRedundancy(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            checkIsAlreadyContainByAddToSet(lottoNumberSet, lottoNumber);
        }
    }

    private void checkIsAlreadyContainByAddToSet(Set<LottoNumber> lottoNumberSet, LottoNumber lottoNumber) {
        boolean isAlreadyContain = !lottoNumberSet.add(lottoNumber);
        if(isAlreadyContain)
            throw new LottoNumberDuplicationFoundedException(ErrorMessage.LOTTO_NUMBER_DUPLICATION_FOUNDED);
    }

    public List<String> getListOfStringForLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isContain(LottoNumber target) {
        return lottoNumbers.contains(target);
    }
}
