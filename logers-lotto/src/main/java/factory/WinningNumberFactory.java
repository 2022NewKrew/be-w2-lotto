package factory;

import domain.WinningNumber;

import java.util.List;
import java.util.Optional;

public class WinningNumberFactory {
    private static WinningNumber instance = null;

    public static Optional<WinningNumber> getInstance(){
        return Optional.of(instance);
    }

    public static Optional<WinningNumber> getInstance(List<Integer> numbers){
        if(instance != null){
            return Optional.empty();
        }

        instance = createInstance(numbers);
        return Optional.of(instance);
    }

    private static WinningNumber createInstance(List<Integer> numbers){
        return new WinningNumber(numbers);
    }
}
