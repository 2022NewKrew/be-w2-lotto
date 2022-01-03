package dto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoDTO {
    private static final List<Integer> INIT_LOTTO = IntStream.rangeClosed(1, 46).boxed().collect(Collectors.toList());
    private final List<Integer> number;

    public LottoDTO() {
        List<Integer> numberForShuffle = new ArrayList<>(INIT_LOTTO);
        Collections.shuffle(numberForShuffle);
        // 1~45의 숫자를 랜덤순서로 섞는다
        number = numberForShuffle.subList(0, 6);
        // 랜덤 순서의 1~45 중 상위 6개를 뽑는다.
        Collections.sort(number);
        // 랜덤하게 뽑은 로또번호를 정렬한다.
    }

    public LottoDTO(String numbers) {
        validationStringNumber(numbers);

        number = Arrays.stream(numbers.split(","))
                .map(stringInt -> Integer.valueOf(stringInt.trim()))
                .collect(Collectors.toList());
    }

    private void validationStringNumber(String numbers) {
        String fixedNumbers = numbers.replaceAll(",", "")
                .replaceAll(" ", "")
                .trim();
        List<Integer> numbersList = Arrays.stream(numbers.split(",")).map(s -> Integer.valueOf(s.trim())).collect(Collectors.toList());
        Set<Integer> numbersUnique = new HashSet<>(numbersList);
        if (!fixedNumbers.chars().allMatch(Character::isDigit))
            throw new IllegalArgumentException("로또 번호에 숫자가 아닌 문자가 포함되어 있습니다.");
        if (numbersList.size() != 6)
            throw new IllegalArgumentException("로또 번호가 6개가 아닙니다.");
        if (numbersUnique.size() != 6)
            throw new IllegalArgumentException("로또 번호에 중복이 있습니다.");
    }

    public List<Integer> getNumber() {
        return number;
    }

    public int getSameNumber(LottoDTO other) {
        int ret = 0;
        for (Integer n : number) {
            ret += Boolean.compare(other.getNumber().contains(n), false);
            //같은 숫자가 other에도 존재하면 1, 아니면 0을 ret에 더한다.
        }
        return ret;
    }
}
