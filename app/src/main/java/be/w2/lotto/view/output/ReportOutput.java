package be.w2.lotto.view.output;

import be.w2.lotto.result.Report;

final class ReportOutput {
    private ReportOutput() {
    }

    static String getOutput(Report report) {
        return new StringBuilder()
                .append("총 수익률은 ")
                .append(getFormattedYieldBy(report))
                .append("%입니다.")
                .toString();
    }

    private static String getFormattedYieldBy(Report report) {
        return String.format("%.2f", report.getYield());
    }
}
