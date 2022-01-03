package carrot.ez;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static List<Integer> lottoNums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30
            , 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45);


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        long price = Long.parseLong(sc.nextLine());
        long count = price / 1000;
        System.out.println(count + "개를 구매했습니다.");
        // 로또 출력
        List<List<Integer>> lottoList = generateLottoList(count);
        for (List<Integer> lotto : lottoList) {
            for (Integer num : lotto) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        int[] winNums = Arrays.stream(sc.nextLine().split("\\s*[,]\\s*"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");
        // 당첨자 출력
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> lotto : lottoList) {
            int wins = 0;
            for (int winNum : winNums) {
                wins = lotto.contains(winNum) ? wins + 1 : wins;
            }
            map.put(wins, map.getOrDefault(wins, 0) + 1);
        }

        System.out.println("3개 일치 (5000원) - " + map.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (50000원) - " + map.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1500000원) - " + map.getOrDefault(5, 0) + "개");
        System.out.println("6개 일치 (2000000000원) - " + map.getOrDefault(6, 0) + "개");

        // 총 수익률
        long earn = 0;
        earn += map.getOrDefault(3, 0) * 5000;
        earn += map.getOrDefault(4, 0) * 50000;
        earn += map.getOrDefault(5, 0) * 1500000;
        earn += map.getOrDefault(6, 0) * 2000000000;

        double rate = ((double) earn / price) * 100;
        String format = String.format("총 수익률은 %.0f%%입니다.", rate);
        System.out.println(format);
    }

    public static List<List<Integer>> generateLottoList(long count) {
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new ArrayList<>(generateLotto()));
        }
        return lottoList;
    }

    public static List<Integer> generateLotto() {
        Collections.shuffle(lottoNums);
        List<Integer> subList = lottoNums.subList(0, 6);
        Collections.sort(subList);
        return subList;
    }
}
