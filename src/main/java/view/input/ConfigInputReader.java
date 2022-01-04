package view.input;

import domain.LottoConfig;

import java.util.Scanner;

public interface ConfigInputReader {

    LottoConfig readConfig(Scanner sc);
}
