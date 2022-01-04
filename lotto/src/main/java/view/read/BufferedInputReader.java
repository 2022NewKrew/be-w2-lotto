package view.read;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferedInputReader implements InputReader {

  private final BufferedReader reader;
  private final BufferedWriter writer;

  private  BufferedInputReader() {
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
  public int getLastWinningNumber() throws IOException {
//    println("지난 주 당첨 번호를 입력해 주세요.");
//
    return 0;
  }





  //TODO: 예외 처리는 STEP2 에서 추가
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
