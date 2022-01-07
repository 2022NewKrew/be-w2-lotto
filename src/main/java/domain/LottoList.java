package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    private final List<Lotto> lottoNumberList;
    private int manualCount;

    public LottoList() {
        lottoNumberList = new ArrayList<>();
        manualCount = 0;
    }

    public void addLotto(Lotto lotto, boolean isManual){
        if(isManual){
            manualCount++;
        }

        lottoNumberList.add(lotto);
    }

    public List<Lotto> getLottoList(){
        return lottoNumberList;
    }

    public int getCount(){
        return lottoNumberList.size();
    }

    public int getManualCount() {
        return manualCount;
    }

    public int getAutoCount(){
        return getCount() - manualCount;
    }
}
