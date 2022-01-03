package view;

import java.util.*;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final int PRICE = 1000;
    private static final String SEPARATOR = ",";

    private InputView() {
    }

    public static int getNumLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int payAmount = sc.nextInt();
        System.out.print(payAmount / PRICE);
        System.out.println("개를 구매했습니다.");

        return payAmount / PRICE;
    }

    public static List<Integer> getWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String WinNumbers = sc.next();
        List<String> splitList = new ArrayList<>(Arrays.asList(WinNumbers.split(SEPARATOR)));

        if (splitList.size() != 6) {
            System.out.println("1부터 45까지의 숫자 6개를 ','로 나누어서 입력해주세요.");
            return getWinNumber();
        }

        return convert2IntAndVerify(splitList);
    }

    private static List<Integer> convert2IntAndVerify(List<String> strList) {
        List<Integer> retList = new ArrayList<>();

        for (String str : strList) {
            retList.add(Integer.valueOf(str));
        }

        return sortAndVerify(retList);
    }

    private static List<Integer> sortAndVerify(List<Integer> srcList) {
        Collections.sort(srcList);

        if (srcList.get(0) < 1 || srcList.get(5) > 45) {
            System.out.println("1부터 45까지의 숫자 6개를 ','로 나누어서 입력해주세요.");
            return getWinNumber();
        }

        return srcList;
    }
}