package step1.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LotteryMachine {

    private static final int ticketPrice = 1000;
    private static final Random random = new Random();

    public static LotteryTicket createLotteryTicket() {

        List<Integer> numbers = selectNumbers();
        Collections.sort(numbers);
        return new LotteryTicket(numbers);
    }

    private static List<Integer> selectNumbers() {

        // TODO Shuffle로 수정
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {
            insertNumber(numbers);
        }
        return numbers;
    }

    private static void insertNumber(List<Integer> numbers) {
        int number = random.nextInt(45) + 1;
        if (numbers.contains(number)) {
            return;
        }
        numbers.add(number);
    }

    public static int getTicketPrice() {
        return ticketPrice;
    }
}
