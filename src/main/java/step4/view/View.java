package step4.view;


import java.util.Map;

public interface View<T> {
    public T getStartPage();
    public T showResult(Map map);
    public T showTickets(Map map);
}
