package view.console;

import view.View;

import java.util.HashMap;
import java.util.Map;

public interface ConsoleView extends View {
    Map<String, Long> ATTRIBUTES = new HashMap<>();

    final String lottoId = "lottoId";
    final String budget = "budget";

    default void setAttribute(String key, Long value) {
        ATTRIBUTES.put(key, value);
    }

    default Long getAttribute(String key) {
        return ATTRIBUTES.get(key);
    }
}
