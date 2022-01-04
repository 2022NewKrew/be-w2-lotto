import controller.LottoController;

public class LottoApp {

    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        try{
            lottoController.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
