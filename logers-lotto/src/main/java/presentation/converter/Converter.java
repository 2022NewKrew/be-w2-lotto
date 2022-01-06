package presentation.converter;

@FunctionalInterface
public interface Converter<T,R>{
    R convert(T param);
}
