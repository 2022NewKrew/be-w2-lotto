package step2.repository;

import step2.domain.LottoSheetWithId;

import java.util.HashMap;
import java.util.Map;

public class LottoSheetMemoryRepository implements LottoSheetRepository{

    // 메모리 저장 공간
    private static final Map<Long, LottoSheetWithId> userIdToLottoSheetMap = new HashMap<>();
    // userId 발급을 위한 키 (Auto Increment 같은)
    private static Long ID_KEY = 1L;

    // LottoSheet 자체를 저장 (userId, LottoSheet)
    @Override
    public LottoSheetWithId save(LottoSheetWithId lottoSheet) {
        userIdToLottoSheetMap.put(ID_KEY, lottoSheet);
        lottoSheet.setId(ID_KEY++);
        return lottoSheet;
    }

    @Override
    public LottoSheetWithId findByUserId(Long userId) {
        LottoSheetWithId findLottoSheet = userIdToLottoSheetMap.get(userId);
        if (findLottoSheet == null) throw new NoSuchFieldError("해당 유저의 LottoSheet이 없습니다.");
        return findLottoSheet;
    }
}
