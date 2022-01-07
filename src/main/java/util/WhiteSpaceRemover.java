package util;

import constants.LottoRule;

public class WhiteSpaceRemover {
    private WhiteSpaceRemover() {

    }

    public static String remove(String input) {
        return input.replaceAll(LottoRule.WHITE_SPACE, "");
    }
}
