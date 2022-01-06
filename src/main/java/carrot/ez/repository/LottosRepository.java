package carrot.ez.repository;

import carrot.ez.entity.LottosEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottosRepository {
    private static final Map<Long, LottosEntity> db = new HashMap<>();
    private static Long seq = 1L;

    public LottosEntity save(LottosEntity lottosEntity) {
        lottosEntity.setId(seq++);
        db.put(lottosEntity.getId(), lottosEntity);
        return lottosEntity;
    }

    public Optional<LottosEntity> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }
}
