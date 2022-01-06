package step4;

import step4.repository.LottoRepository;
import step4.repository.MemoryLottoRepository;
import step4.service.LottoService;

public class LottoMain {

    private static LottoRepository lottoRepository = new MemoryLottoRepository();

    /**
     * buildWebGame -> 웹으로 로또 진행
     * buildConsoleGame -> 콘솔에서 로또 진행
     */
    public static void main(String[] args) {
        try{
//            LottoGame lottoGame = buildWebGame();
            LottoGame lottoGame = buildConsoleGame();

            lottoGame.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static LottoGame buildWebGame() {
        LottoService lottoService = new LottoService(lottoRepository);
        return new LottoGameWeb(lottoService);
    }

    private static LottoGame buildConsoleGame() {
        LottoService lottoService = new LottoService(lottoRepository);
        return new LottoGameConsole(lottoService);
    }

}
