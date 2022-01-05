package be.w2.lotto.view.output;

import be.w2.lotto.cashier.OrderSheet;
import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.result.Report;
import be.w2.lotto.result.Result;

import java.util.List;

public final class Output {

    private Output() {
    }

    public static void outputOrderSheet(OrderSheet orderSheet) {
        output(OrderSheetOutput.getOutput(orderSheet));
    }

    public static void outputLottos(List<Lotto> lottos) {
        output(LottoOutput.getOutput(lottos));
    }

    public static void outputResult(Result result) {
        output(ResultOutput.getOutput(result));
    }

    public static void outputReport(Report report) {
        output(ReportOutput.getOutput(report));
    }

    public static void output(String str) {
        System.out.println(str);
    }
}
