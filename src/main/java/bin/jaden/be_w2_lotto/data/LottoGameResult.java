package bin.jaden.be_w2_lotto.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "lotto_game_result")
public class LottoGameResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, name = "id", unique = true)
    private Long id;

    @ElementCollection
    @CollectionTable(
            name = "lotto_game_result_message",
            joinColumns = @JoinColumn(name = "result_id")
    )
    @OrderColumn
    @Column(name = "message", length = 100, nullable = false)
    private List<String> message;

    @Column(nullable = false, name = "totalRateOfReturn")
    private long totalRateOfReturn;

    public LottoGameResult(Map<LottoRankEnum, Integer> resultMap, int purchasingAmount) {
        List<String> message = new ArrayList<>();
        long totalRewards = 0;
        for (int i = 3; i <= 7; i++) {
            LottoRankEnum rank = LottoRankEnum.values()[i - 2];
            int count = resultMap.getOrDefault(rank, 0);
            message.add(rank.getPrintString(count));
            totalRewards += rank.getReward() * count;
        }
        this.message = Collections.unmodifiableList(message);
        totalRateOfReturn = (totalRewards - purchasingAmount) * 100 / purchasingAmount;
    }

    public LottoGameResult() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public long getTotalRateOfReturn() {
        return totalRateOfReturn;
    }

    public void setTotalRateOfReturn(long totalRateOfReturn) {
        this.totalRateOfReturn = totalRateOfReturn;
    }
}
