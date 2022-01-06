import config.AppConfig;
import repository.LottoRepositoryInMemory;
import service.LottoService;
import service.LottoServiceImpl;

public class Main {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoService lottoService = appConfig.lottoService();
        lottoService.run();
    }

}
