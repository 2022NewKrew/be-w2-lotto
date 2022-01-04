package constants;

import parameters.RankInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoRankInfoList {
    private final List<RankInfo> rankInfoList;

    private LottoRankInfoList() {
        rankInfoList = new ArrayList<>();
        rankInfoList.add(new RankInfo(LottoRule.FIFTH, false));
        rankInfoList.add(new RankInfo(LottoRule.FOURTH, false));
        rankInfoList.add(new RankInfo(LottoRule.THIRD, false));
        rankInfoList.add(new RankInfo(LottoRule.SECOND, true));
        rankInfoList.add(new RankInfo(LottoRule.FIRST, false));
    }
    private static class LottoRankInfoListHelper {
        private static final LottoRankInfoList instance = new LottoRankInfoList();
    }

    public static LottoRankInfoList getInstance(){
        return LottoRankInfoListHelper.instance;
    }
    public Stream<RankInfo> getRankInfoStream() { return rankInfoList.stream(); }
}
