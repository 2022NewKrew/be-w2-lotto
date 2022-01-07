package lotto.step5.dao;

import lotto.step1.model.Lotto;
import lotto.step1.model.LottoNumbers;
import lotto.step1.model.LottoResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LottoDAOTest {
    private static LottoDAO lottoDAO;

    @BeforeAll
    static void beforeAll() {
        lottoDAO = new LottoDAO();
    }

    @Test
    @DisplayName("h2DB에 로또를 정상적으로 저장하고 반환하는 테스트")
    void createAndRead() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, SQLException {
        // given
        final List<List<Integer>> numbersList = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12));

        final LottoNumbers lottoNumbers1 = createLottoNumber(numbersList.get(0), LottoResult.UNIDENTIFIED);
        final LottoNumbers lottoNumbers2 = createLottoNumber(numbersList.get(1), LottoResult.UNIDENTIFIED);

        final long id = 3L;
        final Lotto lotto = createLotto(id, List.of(lottoNumbers1, lottoNumbers2));

        // when
        lottoDAO.create(lotto);
        final Lotto actualLotto = lottoDAO.read(id);

        // then
        final List<LottoNumbers> purchasedLottoNumbersList = actualLotto.getPurchasedLottoNumbersList();
        final int size = purchasedLottoNumbersList.size();
        IntStream.range(0, size)
                .forEach(index -> {
                    final LottoNumbers actualLottoNumbers = purchasedLottoNumbersList.get(index);
                    assertEquals(actualLottoNumbers.getResult(), LottoResult.UNIDENTIFIED);

                    final String numbersStr = numbersList.get(index).stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(","));
                    assertEquals(actualLottoNumbers.toNumbersListStr(), numbersStr);
                });
    }

    @Test
    @DisplayName("H2DB에 기존의 로또를 정상적으로 수정하는 테스트")
    void update() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        final List<List<Integer>> numbersList = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12));

        final long id = 4L;

        final LottoNumbers oldLottoNumbers1 = createLottoNumber(numbersList.get(0), LottoResult.UNIDENTIFIED);
        final LottoNumbers oldLottoNumbers2 = createLottoNumber(numbersList.get(1), LottoResult.UNIDENTIFIED);
        final Lotto oldLotto = createLotto(id, List.of(oldLottoNumbers1, oldLottoNumbers2));

        final LottoNumbers newLottoNumbers1 = createLottoNumber(numbersList.get(0), LottoResult.FIRST_PLACE);
        final LottoNumbers newLottoNumbers2 = createLottoNumber(numbersList.get(1), LottoResult.SECOND_PLACE);
        final Lotto newLotto = createLotto(id, List.of(newLottoNumbers1, newLottoNumbers2));

        // when
        lottoDAO.create(oldLotto);
        lottoDAO.update(newLotto);
        final Lotto actualLotto = lottoDAO.read(id);

        // then
        final List<LottoNumbers> purchasedLottoNumbersList = actualLotto.getPurchasedLottoNumbersList();
        final int size = purchasedLottoNumbersList.size();

        final List<LottoResult> lottoResults = List.of(LottoResult.FIRST_PLACE, LottoResult.SECOND_PLACE);

        IntStream.range(0, size)
                .forEach(index -> {
                    LottoNumbers actualLottoNumbers = purchasedLottoNumbersList.get(index);
                    assertEquals(actualLottoNumbers.getResult(), lottoResults.get(index));
                });
    }

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