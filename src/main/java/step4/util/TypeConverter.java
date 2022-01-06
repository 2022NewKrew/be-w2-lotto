package step4.util;

import step4.service.LottoConfig;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {
    public static List<Integer> StringToIntegerList(String string) {
        return Arrays.asList(string.trim().replaceAll(" ", "").split(","))
                .stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static Integer StringToInt(String string) {
        return Integer.parseInt(string);
    }

    public static int MoneyToAmount(int money){
        Validator.checkPurchaseMoney(money);
        return money / LottoConfig.LOTTO_TICKET_PRICE;
    }

    public static int convertMoney(String inputMoney) {
        Integer purchase = TypeConverter.StringToInt(inputMoney);
        Validator.checkPurchaseMoney(purchase);
        return TypeConverter.MoneyToAmount(purchase);
    }
}
