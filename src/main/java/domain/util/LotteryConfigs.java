package domain.util;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryConfigs {
    public static final int NUMBER_DOMAIN_START = 1;
    public static final int NUMBER_DOMAIN_END = 45;
    public static final Set<Integer> NUMBERS_DOMAIN = IntStream.rangeClosed(NUMBER_DOMAIN_START, NUMBER_DOMAIN_END).boxed().collect(Collectors.toSet());
    public static final int NUMBERS_LENGTH = 6;
    public static final int TICKET_PRICE = 1_000;
}
