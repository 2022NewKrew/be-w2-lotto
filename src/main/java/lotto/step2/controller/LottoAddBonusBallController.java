package lotto.step2.controller;

import lotto.step1.controller.LottoController;
import lotto.step1.dto.request.ConfirmTheWinDTO;
import lotto.step1.dto.response.LottoResultsDTO;
import lotto.step1.exception.NotFoundEntityException;
import lotto.step1.model.Lotto;
import lotto.step1.model.LottoGenerator;
import lotto.step2.dto.request.ConfirmTheWinAddBonusBallDTO;
import lotto.step2.dto.response.LottoResultsAddBonusBallDTO;
import lotto.step2.model.LottoAddBonusBall;
import lotto.step2.model.LottoAddBonusBallGenerator;

import java.util.List;

public class LottoAddBonusBallController extends LottoController {

    public LottoAddBonusBallController() {
        super(new LottoAddBonusBallGenerator());
    }

    protected LottoAddBonusBallController(LottoGenerator lottoGenerator) {
        super(lottoGenerator);
    }

    @Override
    public LottoResultsDTO confirmTheWin(long lottoId, ConfirmTheWinDTO confirmTheWinDTO) throws ClassCastException {
        final List<Integer> lastWeekWinningNumbers = confirmTheWinDTO.getLastWeekWinningNumbers();
        final int bonusBall = getBonusBall(confirmTheWinDTO);

        final Lotto lotto = lottoRepository.findById(lottoId)
                .orElseThrow(NotFoundEntityException::new);

        final LottoAddBonusBall lottoAddBonusBall = lottoAddBonusBallFrom(lotto);
        lottoAddBonusBall.confirmTheWin(lastWeekWinningNumbers, bonusBall);

        return LottoResultsAddBonusBallDTO.of(lotto);
    }

    private int getBonusBall(ConfirmTheWinDTO confirmTheWinDTO) {
        if (!(confirmTheWinDTO instanceof ConfirmTheWinAddBonusBallDTO confirmTheWinAddBonusBallDTO)) {
            throw new ClassCastException();
        }
        return confirmTheWinAddBonusBallDTO.getBonusBall();
    }

    private LottoAddBonusBall lottoAddBonusBallFrom(Lotto lotto) {
        if (!(lotto instanceof LottoAddBonusBall lottoAddBonusBall)) {
            throw new ClassCastException();
        }
        return lottoAddBonusBall;
    }
}
