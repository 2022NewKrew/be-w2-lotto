package repository;

import database.LottoPaper;
import dto.LottoPaperDto;

import java.util.List;

public class LottoPaperRepository {
    LottoPaper lottoPaper = LottoPaper.getLottoPaper();

    public void insert(List<Integer> lottoNumbers) {
        lottoPaper.insert(lottoNumbers);
    }

    public LottoPaperDto findAll() {
        return new LottoPaperDto(lottoPaper.findAll());
    }
}
