package DIFactory;

import controller.Controller;
import database.RogerSQL;
import repository.LottoRepositoryImpl;
import repository.WinningLottoRepositoryImpl;
import service.LottoServiceImpl;
import service.WinningLottoServiceImpl;

public class DIFactory {
    public static Controller makeDependency() {
        RogerSQL rogerSQL = new RogerSQL();

        WinningLottoRepositoryImpl winningLottoRepository = new WinningLottoRepositoryImpl(rogerSQL);
        LottoRepositoryImpl lottoRepository = new LottoRepositoryImpl(rogerSQL);

        WinningLottoServiceImpl winningLottoService = new WinningLottoServiceImpl(winningLottoRepository);
        LottoServiceImpl lottoService = new LottoServiceImpl(winningLottoRepository, lottoRepository);

        return new Controller(winningLottoService, lottoService);
    }
}
