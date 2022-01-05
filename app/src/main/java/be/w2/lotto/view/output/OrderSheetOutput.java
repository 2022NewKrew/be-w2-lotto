package be.w2.lotto.view.output;

import be.w2.lotto.cashier.OrderSheet;

final class OrderSheetOutput extends ClassOutput<OrderSheet> {

    OrderSheetOutput() {
    }

    @Override
    String getOutput(OrderSheet orderSheet) {
        return new StringBuilder()
                .append("수동으로 ")
                .append(orderSheet.getNumOfManual())
                .append("장, 자동으로 ")
                .append(orderSheet.getNumOfAuto())
                .append("장을 구매했습니다.")
                .toString();
    }
}
