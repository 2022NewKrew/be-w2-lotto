package service;

import constant.Constant;
import domain.Lotto;
import domain.Prize;
import domain.WinningLotto;
import dto.LottoListCreateDto;
import dto.LottoDto;
import dto.ResultDto;
import generator.LottoSequenceGenerator;
import repository.LottoRepository;
import repository.WinningLottoRepository;
import validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoServiceImpl implements LottoService {
    private final WinningLottoRepository winningLottoRepository;
    private final LottoRepository lottoRepository;

    public LottoServiceImpl(WinningLottoRepository winningLottoRepository,
                            LottoRepository lottoRepository) {
        this.winningLottoRepository = winningLottoRepository;
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void createLotto(LottoListCreateDto lottoListCreateDto) {
        int budget = lottoListCreateDto.getBudget();
        int manualCount = lottoListCreateDto.getManualLottoList().size();
        int autoCount = budget / Constant.LOTTO_COST - manualCount;

        Validator.checkManualCount(manualCount, budget);

        lottoListCreateDto.getManualLottoList()
                .stream().map(lottoDto ->
                        new Lotto(lottoDto.getLottoSequence(),
                                lottoDto.getAutoCreated()))
                .forEach(lottoRepository::save);

        for (int i = 0; i < autoCount; i++)
            lottoRepository.save(new Lotto(LottoSequenceGenerator.generate(), true));
    }

    @Override
    public List<LottoDto> getLottoList() {
        List<Lotto> lottoList = lottoRepository.findAll();
        return lottoList.stream()
                .map(LottoDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public ResultDto getResults() {
        List<Lotto> lottoList = lottoRepository.findAll();
        WinningLotto winningLotto = winningLottoRepository.find();
        List<Prize> prizeList = lottoList.stream()
                .map(lotto -> lotto.getResult(winningLotto))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return new ResultDto(
                getMessages(prizeList),
                calcEarningRate(lottoList.size() * Constant.LOTTO_COST, prizeList));
    }

    @Override
    public void deleteAll() {
        lottoRepository.deleteAll();
    }

    private List<String> getMessages(List<Prize> prizeList) {
        return Arrays.stream(Prize.values())
                .map(prize -> getResultPerPrize(prizeList, prize))
                .collect(Collectors.toList());
    }

    private String getResultPerPrize(List<Prize> prizes, Prize prize) {
        int prizeCount = (int) prizes.stream().filter(prize_ -> prize_ == prize).count();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prize.getCorrectAmount()).append("개 일치");
        if (prize == Prize.SECOND_BONUS)
            stringBuilder.append(", 보너 볼 일치");
        stringBuilder.append(" (").append(prize.getMoney()).append("원)- ").append(prizeCount).append("개");
        return String.valueOf(stringBuilder);
    }

    private float calcEarningRate(int money, List<Prize> prizes) {
        int moneySpent = (int) (money / Constant.LOTTO_COST) * Constant.LOTTO_COST;
        if (moneySpent == 0)
            return 0;

        int moneyEarn = prizes.stream()
                .map(Prize::getMoney)
                .reduce(0, Integer::sum);

        return (int) (((double) moneyEarn / moneySpent) * 100 - 100);
    }
}
