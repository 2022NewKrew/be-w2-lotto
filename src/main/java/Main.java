import repository.LottoRepositoryInMemory;
import service.LottoService;
import service.LottoServiceImpl;

public class Main {

    public static void main(String[] args) {

        LottoService lottoService = new LottoServiceImpl(new LottoRepositoryInMemory());
        lottoService.run();

    }
}
