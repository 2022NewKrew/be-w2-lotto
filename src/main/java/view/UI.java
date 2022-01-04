package view;
import domain.Lotto;
import domain.LottoGenerator;
import domain.LottoStatics;
import domain.Rank;
import java.util.*;
import java.util.stream.Collectors;

public class UI {
    private static final int lottoPrice = 1000;
    private int numberOfLotto;
    private int money;
    private ArrayList<Lotto> userLottos;
    private Lotto answerLotto;
    private int bonusBall;

    public void start() {
        try(Scanner sc = new Scanner(System.in)) {
            getNumberOfLotto(sc);
            makeLottos();
            printAllLottos(userLottos);
            getAnswerLotto(sc);
            getBonusBall(sc);
            LottoStatics statics = new LottoStatics(money, userLottos, answerLotto, bonusBall);
            printStatics(statics);
        }
    }

    private void getNumberOfLotto(Scanner sc) {
        System.out.println("구입금액을 입력해 주세요.");
        money = sc.nextInt();
        sc.nextLine();
        numberOfLotto = money / lottoPrice;
        System.out.printf("%d개를 구매했습니다.\n", numberOfLotto);
    }

    private void getAnswerLotto(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        answerLotto = new Lotto(
                Arrays.stream(input.split(","))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new)));
    }

    private void getBonusBall(Scanner sc) {
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusBall = sc.nextInt();
        sc.nextLine();
        System.out.println();
    }

    private void makeLottos() {
        userLottos = new ArrayList<>();
        for(int i = 0; i < numberOfLotto; i ++) {
            userLottos.add(LottoGenerator.generateLotto());
        }
    }

    private static void printLotto(Lotto lotto) {
        ArrayList<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers);
    }

    private static void printAllLottos(ArrayList<Lotto> lottos) {
        lottos.forEach(UI::printLotto);
        System.out.println();
    }

    private static void printStatics(LottoStatics statics) {
        System.out.println("당첨 통계\n----------");
        Map<Rank, Integer> results = statics.getResults();
        double yield = statics.getYield();
        Rank[] ranks = Rank.values();
        for(Rank rank : ranks) {
            System.out.printf("%d개 일치%s (%d원)- %d개\n",
                    rank.getCountOfMatch(),
                    rank == Rank.SECOND ? ", 보너스 볼 일치" : "",
                    rank.getWinningMoney(), results.get(rank));
        }
        System.out.printf("총 수익률은 %.2f%%입니다.\n", yield);
    }
}
