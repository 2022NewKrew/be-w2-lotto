package model;

import model.datastructure.LottoNumber;
import model.datastructure.LottoNumbersContainer;

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
    public int save(Long userId, LottoNumber lottoNumber) {
        if (!memoryDatabase.containsKey(userId)) {
            memoryDatabase.put(userId, new LottoNumbersContainer());
        }
        memoryDatabase.get(userId).add(lottoNumber);
        return memoryDatabase.get(userId).size() - 1;
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
