package view.input;

import domain.LottoResult;

import java.util.Scanner;

public interface ResultInputReader {
    LottoResult readResult(Scanner sc);
}
