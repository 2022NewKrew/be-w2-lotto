package step3.util;

import step3.exception.LackOfLottoInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public static int GRATER_THAN_1000(int input){
        if(input < 1000) throw new NumberFormatException("1000원 이상의 금액을 입력하세요");
        return input;
    }

    public static int FROM_1_TO_45(int lottoNum){
        if(lottoNum < 1 || lottoNum > 45) throw new NumberFormatException("로또 번호는 1 ~ 45 의 숫자만 가능합니다.");
        return lottoNum;
    }

    public static List<Integer> SIX_NUMBER_LIST(List<Integer> numbers){
        if(numbers.size() != 6) throw new NumberFormatException("6개의 숫자를 입력해주세요.");
        return numbers;
    }

    public static List<Integer> DB_LOTTO_CONVERT(String strList){
        strList = strList.replace("[", "");
        strList = strList.replace("]", "");
        List<String> list2 = Arrays.asList(strList.split(","));
        return list2.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> INSUFFICIENCY_MANUAL_LOTTO(int numberOfLotto, List<List<Integer>> lottoList){
        if(numberOfLotto != lottoList.size()) throw new LackOfLottoInputException("구입한 개수만큼의 로또번호를 입력하세요");
        return lottoList;
    }


}
