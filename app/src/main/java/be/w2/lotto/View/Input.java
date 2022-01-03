package be.w2.lotto.View;

public class Input<T> {
    T value;

    public Input() {
    }

    T getValue() {
        return value;
    }

    void setValue(T value){
        this.value = value;
    }
}
