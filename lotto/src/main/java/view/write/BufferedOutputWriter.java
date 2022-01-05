package view.write;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 출력을 담당. OutputWriter 의 구현체. BufferedWriter 를 사용해 데이터를 출력한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class BufferedOutputWriter implements OutputWriter {

  private final BufferedWriter writer;

  private BufferedOutputWriter() {
    this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
  }


  public static BufferedOutputWriter create() {
    return new BufferedOutputWriter();
  }


  @Override
  public void write(Object obj) throws IOException {
    writer.write(obj.toString());
    writer.flush();
  }

}
