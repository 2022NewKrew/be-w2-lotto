package lotto.view;

import java.util.List;
import lotto.domain.LottoNumber;

public interface LottoInputScanner {

    long getPurchaseAmount();

    long getNumOfManualLottos();

    List<String> getManualLottoNumberStringList(long numOfManualLottos);

    List<LottoNumber> getWinningLottoNumberList();

    LottoNumber getBonusNumber();
}
