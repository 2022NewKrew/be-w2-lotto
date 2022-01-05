package step3.domain;

import step2.domain.Lotto;
import step2.domain.LottoConfig;
import step2.domain.LottoSheetWithId;
import step2.domain.service.LottoSheetIssuerWithRepo;
import step2.repository.LottoSheetRepository;

import java.util.ArrayList;
import java.util.List;

public class AutoAndManualLottoSheetIssuer extends LottoSheetIssuerWithRepo {
    public AutoAndManualLottoSheetIssuer(LottoSheetRepository lottoSheetRepository) {
        super(lottoSheetRepository);
    }

    @Override
    public LottoSheetWithId issueLottoSheet(LottoConfig lottoConfig) {
        LottoConfigWithManual lottoConfigWithManual = checkLottoConfigType(lottoConfig);

        LottoSheetWithId lottoSheetWithIdAuto = issueLottoSheetAuto(lottoConfig);
        LottoSheetWithId lottoSheetWithIdManual = issueLottoSheetManual(lottoConfigWithManual);

        return lottoSheetRepository.save(uniteAutoAndManualSheet(lottoSheetWithIdAuto, lottoSheetWithIdManual));
    }

    private LottoSheetWithId uniteAutoAndManualSheet(LottoSheetWithId lottoSheetWithIdAuto, LottoSheetWithId lottoSheetWithIdManual) {
        lottoSheetWithIdManual.getLottoList().addAll(lottoSheetWithIdAuto.getLottoList());
        return lottoSheetWithIdManual;
    }

    private LottoSheetWithId issueLottoSheetManual(LottoConfigWithManual lottoConfigWithManual){
        List<Lotto> lottoList = new ArrayList<>();
        lottoConfigWithManual.getManualLottoInnerConfig().getUserInputLottoList()
                .forEach(userInput -> lottoList.add(new Lotto(generateNumberByUser(userInput))));
        return new LottoSheetWithId(lottoList);
    }

    private List<Integer> generateNumberByUser(List<Integer> lottoNumbers) {
        return lottoNumbers;
    }

    private LottoConfigWithManual checkLottoConfigType(LottoConfig lottoConfig){
        if(!(lottoConfig instanceof LottoConfigWithManual))
            throw new ClassCastException("타입이 일치하지 않습니다.");
        return (LottoConfigWithManual) lottoConfig;
    }
}
