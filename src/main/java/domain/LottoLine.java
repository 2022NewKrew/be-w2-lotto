package domain;

import DTO.NNumber;

import java.util.List;

public interface LottoLine {
    int MIN_NUM = 1;
    int MAX_NUM = 45;
    int NUM_PER_LINE = 6;

    int checkWinning(List<Integer> inningNumbers);

    List<Integer> getLottoLine();

    String getPrintLine();
}
