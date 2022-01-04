package org.cs.finn.lotto.util;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatter {

    private NumberFormatter() {}

    public static String strNumberWithSeparator(final int number) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);
        return numberFormat.format(number);
    }
}
