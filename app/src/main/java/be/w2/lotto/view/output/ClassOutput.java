package be.w2.lotto.view.output;

import java.util.List;

public abstract class ClassOutput<T> {

    abstract String getOutput(T element);

    String getOutput(List<T> listOfElement) {
        StringBuilder sb = new StringBuilder();
        for(T element: listOfElement) {
            sb.append(getOutput(element))
                    .append("\n");
        }
        return sb.toString();
    }
}
