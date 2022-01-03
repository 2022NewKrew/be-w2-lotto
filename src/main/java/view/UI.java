package view;
import domain.Lotto;
import domain.LottoStatics;
import java.util.*;
import java.util.stream.Collectors;

public class UI {
    private static final int lottoPrice = 1000;

    public static void run() {
        try(Scanner sc = new Scanner(System.in)) {
            int numberOfLotto = getNumberOfLotto(sc);
            ArrayList<Lotto> lottos = makeLottos(numberOfLotto);
            printAllLottos(lottos);
            ArrayList<Integer> answerLotto = getAnswerLotto(sc);
            LottoStatics statics = new LottoStatics(numberOfLotto * lottoPrice, lottos, answerLotto);
            statics.makeStatics();
            printStatics(statics);
        }
    }

    private static int getNumberOfLotto(Scanner sc) {
        System.out.println("구입금액을 입력해 주세요.");
        int numberOfLotto = sc.nextInt() / lottoPrice;
        sc.nextLine();
        System.out.printf("%d개를 구매했습니다.%n", numberOfLotto);
        return numberOfLotto;
    }

    private static ArrayList<Integer> getAnswerLotto(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        System.out.println();
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }

    private static ArrayList<Lotto> makeLottos(int numberOfLotto) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < numberOfLotto; i ++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    private static void printLotto(Lotto lotto) {
        ArrayList<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    private static void printAllLottos(ArrayList<Lotto> lottos) {
        lottos.forEach(UI::printLotto);
        System.out.println();
    }

    private static void printStatics(LottoStatics statics) {
        System.out.println("당첨 통계\n----------");
        Map<Integer, Integer> winningPrices = statics.getWinningPrices();
        Map<Integer, Integer> results = statics.getResults();
        int yield = statics.getYield();
        for(int key : winningPrices.keySet()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", key, winningPrices.get(key), results.get(key));
        }
        System.out.printf("총 수익률은 %d%%입니다.\n", yield);
    }

    public static void testPrint() {
        System.out.println("Hello world");
    }
}
