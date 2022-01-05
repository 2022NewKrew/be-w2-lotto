package view.read;

import domain.lottery.WinningLotto;
import domain.lotto.Lotto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;
import utils.StringUtils;

/**
 * 입력 객체로 InputReader 인터페이스의 구현체. BufferedReader 를 사용하여 입력 값을 받음.
 *
 * @author leo.jung
 * @since 1.0
 */
//TODO: 예외 처리는 STEP2 에서 추가... 이후에
public class BufferedInputReader implements InputReader {

  private final BufferedReader reader;
  private final BufferedWriter writer;

  private BufferedInputReader() {
    this.reader = new BufferedReader(new InputStreamReader(System.in));
    this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
  }


  public static BufferedInputReader create() {
    return new BufferedInputReader();
  }


  @Override
  public int getPurchaseAmount() throws IOException {
    println("구입금액을 입력해 주세요.");
    return getIntegerFromReader();
  }


  @Override
  public WinningLotto getLastWinningLottery() throws IOException {
    List<Integer> winningLotto = getWinningLotto();
    int bonusNumber = getBonusNumber();
    return WinningLotto.of(winningLotto, bonusNumber);
  }


  //TODO: try-catch + while 활용하여 valid check 후 반복 수행 해야 함.
  private List<Integer> getWinningLotto() throws IOException {
    println("지난 주 당첨 번호를 입력해 주세요.");
    List<Integer> numbers = StringUtils.splitByDelimiter(reader.readLine())
        .stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    validCheck(numbers);
    return numbers;
  }


  //TODO: try-catch + while 활용하여 valid check 후 반복 수행 해야 함.
  private int getBonusNumber() throws IOException {
    println("보너스 볼을 입력해 주세요.");
    return Integer.parseInt(reader.readLine());
  }


  //TODO: 조금더 상세한 valid check, Integer 는 맞는 지, 45 이내인지 등등
  private void validCheck(List<Integer> numbers) {
    if (numbers.size() != Lotto.LOTTO_COUNT) {
      throw new IllegalArgumentException();
    }
  }


  private int getIntegerFromReader() throws IOException {
    String input = reader.readLine().strip();
    return Integer.parseInt(input);
  }


  private void println(String str) throws IOException {
    writer.write(str);
    writer.newLine();
    writer.flush();
  }

}
