package service;

import domain.LottoGenerator;
import domain.utils.LottoUtils;
import domain.validator.LottoNumberValidator;
import domain.validator.Validator;
import dto.LottoPaperDto;
import exception.LottoException;
import repository.LottoInfoRepository;
import repository.LottoPaperRepository;

import java.util.Collections;
import java.util.List;

public class LottoPaperService {
    private static LottoPaperService lottoPaperService = null;
    private final LottoInfoRepository lottoInfoRepository = LottoInfoRepository.getLottoInfoRepository();
    private final LottoPaperRepository lottoPaperRepository = LottoPaperRepository.getLottoPaperRepository();

    private LottoPaperService() {
    }

    public static LottoPaperService getLottoPaperService() {
        if (lottoPaperService == null) {
            lottoPaperService = new LottoPaperService();
        }
        return lottoPaperService;
    }

    public void setLottoNumbers(List<String> lottoNumbers) throws LottoException {
        Validator validator = new LottoNumberValidator();
        for (String nums : lottoNumbers) {
            validator.validate(nums);

            List<Integer> numbers = LottoUtils.splitSixNum(nums);
            Collections.sort(numbers);
            lottoPaperRepository.insert(numbers);
        }

        int amountAuto = lottoInfoRepository.getAmountAuto();
        for (int amount = 0; amount < amountAuto; amount++) {
            List<Integer> numbers = LottoGenerator.createNumbers();
            lottoPaperRepository.insert(numbers);
        }
    }

    public String getLottoString() {
        LottoPaperDto lottoPaper = lottoPaperRepository.findAll();
        return lottoPaper.toString();
    }
}
