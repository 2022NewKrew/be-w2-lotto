import java.io.IOException;
import client.LottoClient;
import client.web.WebClient;

public class App {

  public static void main(String[] args) throws IOException {

//    LottoApplication application = new ConsoleApplication();
    LottoClient application = new WebClient();
    application.run();

  }

}
