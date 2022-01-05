package back.DIFactory;

import back.controller.Controller;
import back.database.RogerSQL;
import back.repository.LottoRepositoryImpl;
import back.repository.WinningLottoRepositoryImpl;
import back.service.LottoServiceImpl;
import back.service.WinningLottoServiceImpl;

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
