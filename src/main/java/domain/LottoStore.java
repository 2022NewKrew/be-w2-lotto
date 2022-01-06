package domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoStore {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String DELIMITER_COMMA = ",";
    private static final String ILLEGAL_LOTTO = "로또는 6개의 서로 다른 숫자(1~45)로 만들어져야 합니다";
    private static List<LottoNumber> allLottoNumbers = new ArrayList<>();

    static {
        for (int number = MIN_LOTTO_NUMBER; number <= MAX_LOTTO_NUMBER; number++) {
            allLottoNumbers.add(new LottoNumber(number));
        }
    }

    private LottoStore() {
    }

    private static Lotto createLotto() {
        Collections.shuffle(allLottoNumbers);
        return new Lotto(allLottoNumbers.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList()));
    }

    public static Lottos purchase(long lottoCount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < lottoCount; i++) {
            lottos.addLotto(createLotto());
        }
        return lottos;
    }

    public static Lotto purchase(String input) {
        String[] lottoInput = input.split(DELIMITER_COMMA);
        validateLottoSize(lottoInput);
        List<LottoNumber> lottoNumbers = Arrays.stream(lottoInput)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(allLottoNumbers.stream()
                .filter(number -> lottoNumbers.contains(number))
                .collect(Collectors.toList()));
    }

    private static void validateLottoSize(String[] lottoNumbers) {
        if (lottoNumbers.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO);
        }
    }
}
