package repository;

import domain.lotto.LottoNumber;
import domain.lotto.LottoNumbersContainer;
import domain.lotto.LottoNumberContainerDTO;
import domain.lotto.LottoNumberDTO;

import java.util.HashMap;

public class MemoryRepository implements Repository {
    private HashMap<Long, LottoNumbersContainer> memoryDatabase = new HashMap<>();

    @Override
    public void init(Long userId) {
        memoryDatabase.put(userId, new LottoNumbersContainer());

    }

    @Override
    public int size(Long userId) throws Exception {
        checkUserIdAvailableWithException(userId);
        return memoryDatabase.get(userId).size();
    }

    @Override
    public void save(Long userId, LottoNumberDTO lottoNumberDTO) throws Exception{
        memoryDatabase.get(userId).add(new LottoNumber(lottoNumberDTO.getArrayListInteger()));
    }

    @Override
    public void save(Long userId, LottoNumberContainerDTO lottoNumberContainerDTO) throws Exception {
        for (LottoNumberDTO lottoNumber : lottoNumberContainerDTO.getLottoNumbers()) {
            save(userId, lottoNumber);
        }
    }

    @Override
    public LottoNumber get(Long userId, int i) throws Exception {
        checkUserIdAvailableWithException(userId);
        return memoryDatabase.get(userId).get(i);
    }

    private void checkUserIdAvailableWithException(Long userId) throws Exception {
        if (!memoryDatabase.containsKey(userId)) {
            throw new Exception("존재하지 않는 유저 ID 입니다.");
        }
    }
}
