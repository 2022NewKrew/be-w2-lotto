package domain;

import Exceptions.TicketFormatException;
import view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataFormatting {
    public static List<String> parseSelectedNumbers(String selectedNumbers) {
        return Arrays.asList(selectedNumbers.split(","));
    }

    public static List<Integer> stringListToIntegerList(List<String> stringList) {
        return stringList.stream().map(s -> stringToInteger(s)).collect(Collectors.toList());
    }

    public static int stringToInteger(String string) throws NumberFormatException {
        return Integer.parseInt(string);
    }

    // 전달받은 string을 티켓에서 선택된 번호들의 List로 변환
    public static List<Integer> reformattedTicket(String string) throws TicketFormatException {
        List<String> inputStringList = parseSelectedNumbers(string);
        if (inputStringList.size() != GroundRule.NUM_OF_SELECTION) {
            throw new TicketFormatException();
        }
        return stringListToIntegerList(inputStringList);
    }

    // 데이터 포매팅만 담당하려 했으나 지금 현재 View에 의존적인 모습.
    // 원래는 buyer가 수동 로또 번호를 찍는다는 의미의 메서드였으나, central 에서 당첨번호를 받을 때도 완전히 동일한 로직이 적용되기 때문에 일단 묶기위해 이동
    public static List<Integer> selectedNumbers() {
        try {
            return DataFormatting.reformattedTicket(View.inputString());
        } catch (TicketFormatException e) {
            View.print(String.format("입력하신 숫자가 %d개가 아닙니다.", GroundRule.NUM_OF_SELECTION));
            return selectedNumbers();
        } catch (NumberFormatException e) {
            View.print("숫자가 아닌 입력이 감지되었습니다.");
            return selectedNumbers();
        }
    }

    public static int booleanToInteger(boolean b) {
        if (b) {
            return 1;
        }
        return 0;
    }
}
