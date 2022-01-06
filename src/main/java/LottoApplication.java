import controller.AppStarter;
import controller.ConsoleAppStarter;
import controller.LottoController;
import controller.WebAppStarter;
import domain.user.NormalUser;
import domain.user.User;
import repository.MemoryRepository;
import repository.Repository;
import service.LottoService;

public class LottoApplication {

    public static void main(String[] args) throws Exception {
        User user = new NormalUser(1L);

        Repository repository = new MemoryRepository();
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(repository,lottoService);

//        AppStarter appstarter = new ConsoleAppStarter(lottoController, user);
        AppStarter appstarter = new WebAppStarter(lottoController, user, 8080);
        appstarter.run();
    }
}
