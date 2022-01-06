package view.write;

import java.io.IOException;

/**
 * 출력 담당 인터페이스 해당 인터페이스를 상속 받는 구현체는, 적절한 String 값을 받아 특정 출력 장치에 write 하는 기능을 구현해야 한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public interface OutputWriter {

  void write(Object obj) throws IOException;

}
