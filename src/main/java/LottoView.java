import java.util.Map;

public class LottoView {
    private final LottoList lottoList;
    private final LottoResult lottoResult;

    public LottoView(LottoList lottoList, LottoResult lottoResult) {
        this.lottoList = lottoList;
        this.lottoResult = lottoResult;
    }

    public void printLottoList(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d개를 구매했습니다\n", lottoList.getLottoList().size()));

        for (Lotto lotto : lottoList.getLottoList()) {
            sb.append(lotto).append("\n");
        }

        System.out.println(sb);
    }

    public void printLottoResult(Lotto resultLotto){
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n").append("---------\n");

        //Result View
        Map<Integer, Integer> lottoResultMap = lottoResult.getLottoResult(resultLotto);
        for (Integer rank : LottoConst.RANK_TO_PRICE.keySet()) {
            sb.append(String.format("%d개 일치 (%d원)- %d개\n", rank, LottoConst.RANK_TO_PRICE.get(rank), lottoResultMap.get(rank)));
        }
        // 수익률
        sb.append(String.format("총 수익률은 %.1f%%입니다.\n", lottoResult.getTotalResultPrice()));
        System.out.println(sb);
    }
}
