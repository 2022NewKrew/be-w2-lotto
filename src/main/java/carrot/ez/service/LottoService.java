package carrot.ez.service;

import carrot.ez.dto.response.LottosDto;
import carrot.ez.dto.response.LottosResultDto;
import carrot.ez.entity.LottoEntity;
import carrot.ez.entity.LottosEntity;
import carrot.ez.lotto.LotteryDiv;
import carrot.ez.lotto.LotteryGenerator;
import carrot.ez.lotto.Rank;
import carrot.ez.mapper.LottosMapper;
import carrot.ez.repository.LottosRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static carrot.ez.constants.LottoConstant.LOTTO_PRICE;

public class LottoService {

    private static final List<Rank> PRINT_RANKS = Arrays.asList(Rank.Fifth, Rank.Fourth, Rank.Third, Rank.Second, Rank.First);
    public static final String REGEX_LINE = "\r?\n";
    public static final String REGEX_COMMA = "\\s*[,]\\s*";

    private final LottosRepository lottosRepository = new LottosRepository();
    private final LottosMapper mapper = new LottosMapper();

    public LottosDto buyLottos(String inputMoney, String manualNumbers) {
        long money = getMoney(inputMoney);

        // create lottos(manual + auto)s
        List<LottoEntity> manualLottos = createManualLottos(manualNumbers);
        List<LottoEntity> autoLottos = createAutoLottos(manualLottos, money);
        manualLottos.addAll(autoLottos);

        LottosEntity lottos = saveLottos(money, manualLottos);

        return mapper.toLottosDto(lottos);
    }

    public LottosResultDto matchLottos(String id, String winningNumberString, String bonusNumberString) {
        // get entity
        LottosEntity lottosEntity = lottosRepository.findById(Long.parseLong(id))
                .orElseThrow();

        // get inputs
        List<Integer> winningNumbers = getLottoNumbers(winningNumberString);
        int bonusNumber = getLottoNumber(bonusNumberString);

        // compute results
        Map<Rank, Long> rankCountMap = lottosEntity.checkWinningNumbers(winningNumbers, bonusNumber);
        List<String> message = makeRankingMessages(rankCountMap);
        String totalRateOfReturn = getTatalRateOfReturn(lottosEntity, rankCountMap);

        return new LottosResultDto(message, totalRateOfReturn);
    }

    private long getMoney(String inputMoney) {
        try {
            return Long.parseLong(inputMoney);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("구입 금액은 숫자만 가능합니다.");
        }
    }


    private List<LottoEntity> createManualLottos(String manualNumbers) {
        if (manualNumbers.isBlank()) {
            return new ArrayList<>();
        }

        return Arrays.stream(manualNumbers.split(REGEX_LINE))
                .map(this::toManualLottoEntity)
                .collect(Collectors.toList());
    }

    private List<LottoEntity> createAutoLottos(List<LottoEntity> manualLottos, long money) {
        long autoLottoSize = getNumOfAutoLottos(money, manualLottos);
        return LotteryGenerator.generateLotto(autoLottoSize);
    }

    private long getNumOfAutoLottos(long money, List<LottoEntity> manualLotteries) {
        long numAutoLotteries  = (money / LOTTO_PRICE) - manualLotteries.size();
        if (numAutoLotteries < 0) {
            throw new IllegalArgumentException("구입 금액이 부족합니다.");
        }

        return numAutoLotteries;
    }

    private LottosEntity saveLottos(long money, List<LottoEntity> manualLottos) {
        LottosEntity user = new LottosEntity(money, manualLottos);
        return lottosRepository.save(user);
    }

    private LottoEntity toManualLottoEntity(String numbersString) {
        List<Integer> numbers = getLottoNumbers(numbersString);

        return new LottoEntity(numbers, LotteryDiv.MANUAL);
    }

    private List<Integer> getLottoNumbers(String lottoNumberString) {
        try {
            return Arrays.stream(lottoNumberString.split(REGEX_COMMA))
                    .map(this::getLottoNumber)
                    .collect(Collectors.toList());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("번호 형식이 잘못되었습니다.");
        }
    }

    private int getLottoNumber(String numberString) {
        try {
            return Integer.parseInt(numberString);
        }catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }

    private List<String> makeRankingMessages(Map<Rank, Long> rankCountMap) {
        List<String> message = new ArrayList<>();
        PRINT_RANKS.forEach(rank -> {
            Long count = rankCountMap.getOrDefault(rank, 0L);
            message.add(String.format(rank.getStringFormat(), rank.getCorrectNum(), rank.getPrice(), count));
        });
        return message;
    }

    private String getTatalRateOfReturn(LottosEntity lottosEntity, Map<Rank, Long> rankCountMap) {
        Long sum = getTotalSum(rankCountMap);
        Long money = lottosEntity.getMoney();
        double totalRateOfReturn = ((double)sum - money) / money * 100;
        return String.format("%.2f", totalRateOfReturn);
    }

    private Long getTotalSum(Map<Rank, Long> rankCountMap) {
        return rankCountMap.entrySet().stream()
                .map(entry -> entry.getKey().getPrice() * entry.getValue())
                .reduce(Long::sum)
                .orElseThrow();
    }

}
