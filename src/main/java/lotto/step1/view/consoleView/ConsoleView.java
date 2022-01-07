package lotto.step1.view.consoleView;

import lotto.step1.view.View;

import java.util.HashMap;
import java.util.Map;

public interface ConsoleView extends View {
    Map<String, String> ATTRIBUTES = new HashMap<>();

    String LOTTO_ID = "id";

    default String getAttributes(String key) {
        return ATTRIBUTES.get(key);
    }

    default void setAttributes(String key, String value) {
        ATTRIBUTES.put(key, value);
    }
}
