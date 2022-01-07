package presentation.converter;

import java.util.function.Function;

@FunctionalInterface
public interface Converter<T,R> extends Function<T, R> {
}
