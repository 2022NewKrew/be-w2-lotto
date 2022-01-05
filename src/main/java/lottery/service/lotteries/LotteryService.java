package lottery.service.lotteries;

import lottery.domain.Constants;
import lottery.domain.lotteries.LotteryEntity;
import lottery.domain.lotteries.LotteryRepository;
import lottery.domain.lotteries.UserEntity;
import lottery.domain.lotteries.UserRepository;
import lottery.web.dto.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LotteryService {

    private final LotteryRepository lotteryRepository = new LotteryRepository();
    private final UserRepository userRepository = new UserRepository();

    public List<LotteryDto> buy(BudgetDto budgetDto) {

        int budget = budgetDto.getAmount();
        int numOfLotteries = (budget / Constants.PRICE);
        UserEntity userEntity = new UserEntity(budgetDto.getAmount());
        userRepository.save(userEntity);
        ArrayList<LotteryDto> lotteryBundle = new ArrayList<>();
        for(int i = 0; i < numOfLotteries; i++) {
            List<Integer> randomNumbers = generateRandomNumbers();
            LotteryEntity lotteryEntity = new LotteryEntity(randomNumbers);
            LotteryDto lotteryDto = new LotteryDto(randomNumbers);
            lotteryBundle.add(lotteryDto);
            lotteryRepository.save(lotteryEntity);
        }

        return lotteryBundle;

    }

    public List<Integer> generateRandomNumbers() {
        ArrayList<Integer> totalNumber = new ArrayList<>();
        for (int i = 1; i <= 45; i++) totalNumber.add(i);
        Collections.shuffle(totalNumber);
        List<Integer> numbers = totalNumber.subList(0, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public LotteryResultDto match(LotteryWinningNumberDto winningNumberDto) {
        ArrayList<LotteryEntity> listOfLottories = lotteryRepository.findAll();
        UserEntity user = userRepository.findFirstUser();
        HashMap<Integer, Integer> matchResult = new HashMap<>();
        for(int i = 0; i <= 6; i++) matchResult.put(i, 0);

        for(LotteryEntity lotteryEntity : listOfLottories) {
            countMatchNum(lotteryEntity, winningNumberDto, matchResult);
        }

        return new LotteryResultDto(matchResult, user.getBudget());
    }

    public LotteryResultDto match(LotteryWinningNumberWithBonusDto winningNumberDto) {
        ArrayList<LotteryEntity> listOfLottories = lotteryRepository.findAll();
        UserEntity user = userRepository.findFirstUser();
        HashMap<Integer, Integer> matchResult = new HashMap<>();
        for(int i = -1; i <= 6; i++) matchResult.put(i, 0);

        for(LotteryEntity lotteryEntity : listOfLottories) {
            countMatchNum(lotteryEntity, winningNumberDto, matchResult);
        }

        return new LotteryResultDto(matchResult, user.getBudget());
    }

    public void countMatchNum(LotteryEntity lotteryEntity, LotteryWinningNumberDto winningNumberDto, HashMap<Integer, Integer> matchResult) {
        int matchCnt = 0;
        for(int number : lotteryEntity.getNumbers()) {
            if (winningNumberDto.getNumbers().contains(number)) matchCnt++;
        }
        int prevValue = matchResult.get(matchCnt);
        matchResult.put(matchCnt, prevValue + 1);
    }

    public void countMatchNum(LotteryEntity lotteryEntity, LotteryWinningNumberWithBonusDto winningNumberDto, HashMap<Integer, Integer> matchResult) {
        int matchCnt = 0;
        for(int number : lotteryEntity.getNumbers()) {
            if (winningNumberDto.getNumbers().contains(number)) matchCnt++;
        }

        int prevValue = matchResult.get(matchCnt);
        matchResult.put(matchCnt, prevValue + 1);

        if (matchCnt == 5 && lotteryEntity.getNumbers().contains(winningNumberDto.getBonusNumber())) {
            prevValue = matchResult.get(-1);
            matchResult.put(-1, prevValue + 1);

            prevValue = matchResult.get(5);
            matchResult.put(5, prevValue - 1);
        }

    }

}
