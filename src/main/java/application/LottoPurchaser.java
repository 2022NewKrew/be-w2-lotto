package application;

import domain.Lotto;

import java.util.List;

public interface LottoPurchaser {
    List<Lotto> generateLotto(int quantity);
}
