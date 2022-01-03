package lotto.step1.model;

import lotto.step1.util.AutoIncrementIdGenerator;

import java.util.Objects;

public class BaseEntity {
    private final Long id = AutoIncrementIdGenerator.get();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }
}
