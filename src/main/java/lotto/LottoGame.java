package main.java.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LottoGame {
    private int money;
    private int earning;
    private int lottoCount;
    private ArrayList<Lotto> lottoList;
    private ArrayList<Integer> sixNumList;
    private ArrayList<Integer> winList;
    private ArrayList<Integer> earningList;

    public LottoGame(int money){
        this.money=money;
        this.earning=0;
        this.lottoCount = money/1000;
        this.lottoList = new ArrayList<>();
        makeLottoList();
        this.sixNumList = new ArrayList<>();
        this.winList = new ArrayList<>();
        setWinList();
        this.earningList = new ArrayList<>();
        setEarningList();
    }

    private void setWinList(){
        for(int i=0;i<7;i++){
            winList.add(0);
        }
    }

    private void setEarningList() {
        earningList.add(0);
        earningList.add(0);
        earningList.add(0);
        earningList.add(5000);
        earningList.add(50000);
        earningList.add(1500000);
        earningList.add(2000000000);
    }

    public ArrayList<Integer> getEarningList() {
        return earningList;
    }

    public ArrayList<Lotto> getLottoList() {
        return lottoList;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public void setSixNumList(ArrayList<Integer> sixNumList) {
        this.sixNumList = sixNumList;
    }

    public ArrayList<Integer> getWinList() {
        return winList;
    }

    private void makeLottoList(){
        LottoGen lottoGen = new LottoGen();
        for(int i=0;i<lottoCount;i++){
            lottoList.add(lottoGen.makeLotto());
        }
    }

    public void makeWinList(){
        for(int i=0;i<lottoList.size();i++){
            int idx = checkWinning(lottoList.get(i));
            winList.set(idx,winList.get(idx)+1);
        }
    }

    private int checkWinning(Lotto lotto){
        int cnt = 0;
        for(int i=0;i<6;i++){
            if(sixNumList.contains(lotto.getLotto().get(i))){
                cnt++;
            }
        }
        return cnt;
    }

    public void setEarning(){
        for(int i=3;i<7;i++){
            earning += earningList.get(i) * winList.get(i);
        }
    }

    public int calculate(){
        return (int)((earning*1.0)/money*100);
    }
}
