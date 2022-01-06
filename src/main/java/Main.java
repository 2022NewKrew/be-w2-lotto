import application.LottoApplication;
import config.AppConfig;

public class Main {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoApplication lottoApplication = new LottoApplication();
        lottoApplication.run();
    }

}
