package domain.factory;

import domain.WinningNumbers;

import java.util.List;
import java.util.Optional;

public class WinningNumbersFactory {
    private static WinningNumbers instance = null;

    public static Optional<WinningNumbers> getInstance(List<Integer> numbers, int bonusNumber){
        if(instance != null){
            return Optional.empty();
        }

        instance = createInstance(numbers, bonusNumber);
        return Optional.of(instance);
    }

    private static WinningNumbers createInstance(List<Integer> numbers, int bonusNumber){
        return new WinningNumbers(numbers, bonusNumber);
    }
}
