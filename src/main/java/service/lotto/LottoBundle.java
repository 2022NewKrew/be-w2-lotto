package service.lotto;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LottoBundle {
    private static final AtomicLong count = new AtomicLong(0);
    private final List<Lotto> lottoBundle;
    private final Long id;

    protected LottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
        this.id = count.getAndIncrement();
    }

    public Long getId() {
        return id;
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        return this.getId().equals(((LottoBundle) o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBundle, id);
    }

    @Override
    public String toString() {
        StringBuilder lottoBundleStringBuilder = new StringBuilder();
        for (Lotto lotto : lottoBundle){
            lottoBundleStringBuilder.append(lotto.toString()).append("\n");
        }
        return lottoBundleStringBuilder.toString();
    }
}
