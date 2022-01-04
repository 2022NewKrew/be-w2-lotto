package view.write;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

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
