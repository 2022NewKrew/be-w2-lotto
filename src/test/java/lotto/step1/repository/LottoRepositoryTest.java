package lotto.step1.repository;

import lotto.step1.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LottoRepositoryTest {

    @Test
    @DisplayName("레퍼지토리에서 로또를 정상적으로 저장하고 반환하는 테스트")
    void saveAndFindById() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final LottoRepository lottoRepository = new LottoRepository();
        final long id = 3L;

        final Lotto lotto = createLotto(id);

        // when
        lottoRepository.save(lotto);
        final Optional<Lotto> lottoOptional = lottoRepository.findById(id);

        // then
        assertTrue(lottoOptional.isPresent());

        final Long actualId = lottoOptional.get().getId();
        assertEquals(actualId, id);
    }

    @Test
    @DisplayName("레퍼지토리에 기존의 로또를 정상적으로 수정하는 테스트")
    void update() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // given
        final LottoRepository lottoRepository = new LottoRepository();

        final long id = 3L;
        final Lotto oldLotto = createLotto(id);
        lottoRepository.save(oldLotto);

        final Lotto newLotto = createLotto(id);

        // when
        lottoRepository.update(newLotto);

        // then
        final Lotto actualLotto = lottoRepository.findById(id).orElseThrow(RuntimeException::new);
        assertNotSame(actualLotto, oldLotto);
        assertSame(actualLotto, newLotto);
    }

    private Lotto createLotto(long id) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Constructor<Lotto> lottoConstructor = Lotto.class.getDeclaredConstructor(long.class, List.class);
        lottoConstructor.setAccessible(true);
        return lottoConstructor.newInstance(id, Collections.emptyList());
    }
}