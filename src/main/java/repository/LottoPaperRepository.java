package repository;

import database.LottoPaper;
import dto.LottoPaperDto;

import java.util.List;

public class LottoPaperRepository {
    private static LottoPaperRepository lottoPaperRepository = null;
    private final LottoPaper lottoPaper = LottoPaper.getLottoPaper();

    private LottoPaperRepository() {
    }

    public static LottoPaperRepository getLottoPaperRepository() {
        if (lottoPaperRepository == null) {
            lottoPaperRepository = new LottoPaperRepository();
        }
        return lottoPaperRepository;
    }

    public void insert(List<Integer> lottoNumbers) {
        lottoPaper.insert(lottoNumbers);
    }

    public LottoPaperDto findAll() {
        return new LottoPaperDto(lottoPaper.findAll());
    }
}
