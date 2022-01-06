//package service;
//
//import domain.Lotto;
//import view.InputView;
//
//import static utils.Symbol.MANUAL_INPUT_MESSAGE;
//
//public class ManualGenerator implements LottoGenerator {
//    private static final InputView inputview = new InputView();
//
//    @Override
//    public Lotto generate() {
//        Lotto lotto = new Lotto();
//        System.out.println("\n" + MANUAL_INPUT_MESSAGE);
//        Lotto lotto = inputview.getManualLotto();
//        return lotto;
//    }
//}
