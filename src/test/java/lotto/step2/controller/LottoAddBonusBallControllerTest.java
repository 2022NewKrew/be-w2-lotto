package lotto.step2.controller;

import lotto.step1.controller.LottoController;
import lotto.step1.dto.request.ConfirmTheWinDTO;
import lotto.step1.dto.response.LottoResultsDTO;
import lotto.step1.model.Lotto;
import lotto.step1.model.LottoNumbers;
import lotto.step1.model.LottoResult;
import lotto.step1.repository.LottoRepository;
import lotto.step2.dto.request.ConfirmTheWinAddBonusBallDTO;
import lotto.step2.model.LottoAddBonusBall;
import lotto.step2.model.LottoAddBonusBallGenerator;
import lotto.step2.model.LottoNumbersAddBonusBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LottoAddBonusBallControllerTest {

    private final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
    private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("보너스 로또 당첨 결과를 DTO로 성공적으로 반환하는 테스트")
    void confirmTheWin() {
        // 로또번호는 하나만 구매하고 해당 번호가 1등 당첨일때
        // given
        final LottoController lottoController = new LottoAddBonusBallController(new LottoAddBonusBallGenerator(), mockLottoRepositoryReturnBonusPlaceLotto);

        final long lottoId = 3L;
        final int bonusBall = 7;
        final ConfirmTheWinDTO confirmTheWinDTO = new ConfirmTheWinAddBonusBallDTO(winningNumbers, bonusBall);

        // when
        final LottoResultsDTO lottoResultsDTO = lottoController.confirmTheWin(lottoId, confirmTheWinDTO);

        // then
        assertEquals(lottoResultsDTO.getClass(), LottoResultsDTO.class);

        final double expectedYield = (LottoResult.BONUS_PLACE.getPrizeMoney() / (double) 1000) * 100 - 100;
        assertEquals(lottoResultsDTO.getYield(), expectedYield);

        final int numOfBonusPlace = lottoResultsDTO.getNumOfWinsMapStr().get(LottoResult.BONUS_PLACE.getMsg());
        assertEquals(numOfBonusPlace, 1);
        assertEquals(lottoResultsDTO.getNumOfWinsMapStr().size(), LottoResult.getEnumSetFirstToFourthPlaceAddBonusPlace().size());
    }

    private final LottoRepository mockLottoRepositoryReturnBonusPlaceLotto = new LottoRepository() {
        @Override
        public Optional<Lotto> findById(Long lottoId) {
            try {
                final LottoNumbers lottoNumbers = createLottoNumber(numbers, LottoResult.UNIDENTIFIED);
                return Optional.of(createLotto(lottoId, List.of(lottoNumbers)));
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            throw new RuntimeException();
        }

        @Override
        public void save(Lotto lotto) {
            return;
        }

        @Override
        public void update(Lotto lotto) {
            return;
        }
    };

    private LottoAddBonusBall createLotto(long id, List<LottoNumbers> lottoNumbers) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<LottoAddBonusBall> lottoConstructor = LottoAddBonusBall.class.getDeclaredConstructor(long.class, List.class);
        lottoConstructor.setAccessible(true);
        return lottoConstructor.newInstance(id, lottoNumbers);
    }

    private LottoNumbersAddBonusBall createLottoNumber(List<Integer> numbers, LottoResult lottoResult) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<LottoNumbersAddBonusBall> lottoNumbersConstructor = LottoNumbersAddBonusBall.class.getDeclaredConstructor(List.class, LottoResult.class);
        lottoNumbersConstructor.setAccessible(true);
        return lottoNumbersConstructor.newInstance(numbers, lottoResult);
    }
}