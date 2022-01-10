package client.web;

import client.LottoClient;
import java.io.IOException;

public class WebClient implements LottoClient {

  private final int DEFAULT_PORT = 8080;
  private final WebListener webListener;
  private final int port;

  public WebClient() {
    this.webListener = new WebListener();
    this.port = DEFAULT_PORT;
  }


  public WebClient(int port) {
    this.webListener = new WebListener();
    this.port = port;
  }


  @Override
  public void run() throws IOException {
    webListener.listen(port);
  }

}
