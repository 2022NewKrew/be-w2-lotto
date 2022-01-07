package domain;

import java.util.*;

public class LottoMachine {

    private static LottoMachine instance;

    private WinningLotto winning;

    public LottoMachine() { }

    public List<Integer> stringToList(String lottoStr){
        List<Integer> retVal = new ArrayList<Integer>();
        for(String lotto : lottoStr.split(",")){
            retVal.add(Integer.parseInt(lotto));
        }
        return retVal;
    }

    public List<Lotto> purchaseAutoLotto(int count){
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++){
            Lotto lotto = new LottoTicket();
            lotto.createNum();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public List<Lotto> purchaseManualLotto(List<String> manualList){
        List<Lotto> lottoList = new ArrayList<>();
        for (String manual : manualList){
            Lotto lotto = new LottoTicket();
            lotto.createNum(stringToList(manual));
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public void createWinningLotto(String winningNumbers, int bonusBall) {
        this.winning = new WinningLotto(stringToList(winningNumbers), bonusBall);
    }

    public WinningLotto getWinning() { return this.winning; }

    public static LottoMachine getInstance () {
        if (instance == null) instance = new LottoMachine();
        return instance;
    }
}
