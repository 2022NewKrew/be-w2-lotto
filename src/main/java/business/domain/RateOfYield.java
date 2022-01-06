package business.domain;

import java.util.Objects;

public class RateOfYield {

    private final double value;

    public RateOfYield(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RateOfYield that = (RateOfYield) o;
        return Double.compare(that.getValue(), value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "RateOfYield{" + "value=" + value + '}';
    }
}
