package view.web;

import view.View;

import java.util.HashMap;
import java.util.Map;

public interface WebView extends View {
    Map<String, Long> ATTRIBUTES = new HashMap<>();

    String lottoId = "lottoId";
    String budget = "budget";

    default void setAttribute(String key, Long value) {
        ATTRIBUTES.put(key, value);
    }

    default Long getAttribute(String key) {
        return ATTRIBUTES.get(key);
    }
}
