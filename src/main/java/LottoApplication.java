import controller.LottoManager;
import model.MemoryRepository;
import view.ConsoleLottoUI;

public class LottoApplication {

    public static void main(String[] args) throws Exception {
        // Controller, Model, View 연결
        LottoManager lottoManager = new LottoManager(1L, new MemoryRepository(), new ConsoleLottoUI());
        lottoManager.run();
    }
}
