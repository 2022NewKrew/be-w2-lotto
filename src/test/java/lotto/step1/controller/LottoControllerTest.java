package lotto.step1.controller;

import lotto.step1.dto.request.ConfirmTheWinDTO;
import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.dto.response.LottoResultsDTO;
import lotto.step1.dto.response.PurchasedLottoDTO;
import lotto.step1.model.Lotto;
import lotto.step1.model.LottoGenerator;
import lotto.step1.model.LottoNumbers;
import lotto.step1.model.LottoResult;
import lotto.step1.repository.LottoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    private final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    private final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

    @Test
    void purchase() {
        // given
        final LottoController lottoController = new LottoController();

        final int purchaseAmount = 2000;
        final int price = 1000;
        final LottoPurchaseSheetDTO lottoPurchaseSheetDTO = new LottoPurchaseSheetDTO(purchaseAmount);

        // when
        final PurchasedLottoDTO purchasedLottoDTO = lottoController.purchase(lottoPurchaseSheetDTO);

        // then
        assertEquals(purchasedLottoDTO.getClass(), PurchasedLottoDTO.class);
        assertEquals(purchasedLottoDTO.getLottoNumbersList().size(), purchaseAmount / price);
    }

    @Test
    @DisplayName("로또 당첨 결과를 DTO로 성공적으로 반환하는 테스트")
    void confirmTheWin() {
        // 로또번호는 하나만 구매하고 해당 번호가 1등 당첨일때
        // given
        final LottoController lottoController = new LottoController(new LottoGenerator(), mockLottoRepositoryReturnFirstPlaceLotto);

        final long lottoId = 3L;
        final ConfirmTheWinDTO confirmTheWinDTO = new ConfirmTheWinDTO(winningNumbers);

        // when
        final LottoResultsDTO lottoResultsDTO = lottoController.confirmTheWin(lottoId, confirmTheWinDTO);

        // then
        assertEquals(lottoResultsDTO.getClass(), LottoResultsDTO.class);

        final double expectedYield = (LottoResult.FIRST_PLACE.getPrizeMoney() / (double) 1000) * 100 - 100;
        assertEquals(lottoResultsDTO.getYield(), expectedYield);

        final int numOfFirstPlace = lottoResultsDTO.getNumOfWinsMapStr().get(LottoResult.FIRST_PLACE.getMsg());
        assertEquals(numOfFirstPlace, 1);
        assertEquals(lottoResultsDTO.getNumOfWinsMapStr().size(), LottoResult.getEnumSetFirstToFourthPlace().size());
    }

    private final LottoRepository mockLottoRepositoryReturnFirstPlaceLotto = new LottoRepository() {
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

    private Lotto createLotto(long id, List<LottoNumbers> lottoNumbers) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<Lotto> lottoConstructor = Lotto.class.getDeclaredConstructor(long.class, List.class);
        lottoConstructor.setAccessible(true);
        return lottoConstructor.newInstance(id, lottoNumbers);
    }

    private LottoNumbers createLottoNumber(List<Integer> numbers, LottoResult lottoResult) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<LottoNumbers> lottoNumbersConstructor = LottoNumbers.class.getDeclaredConstructor(List.class, LottoResult.class);
        lottoNumbersConstructor.setAccessible(true);
        return lottoNumbersConstructor.newInstance(numbers, lottoResult);
    }
}