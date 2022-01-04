package main.java.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LottoGame {
    private int money;
    private int earning;
    private int lottoCount;
    private int bonus;
    private ArrayList<Lotto> lottoList;
    private ArrayList<Integer> sixNumList;
    private ArrayList<Integer> winList;
//    private ArrayList<Integer> earningList;

    public LottoGame(int money){
        this.money=money;
        this.earning=-money;
        this.lottoCount = money/1000;
        this.lottoList = new ArrayList<>();
        makeLottoList();
        this.sixNumList = new ArrayList<>();
        this.winList = new ArrayList<>();
        setWinList();
//        this.earningList = new ArrayList<>();
//        setEarningList();
    }

    private void setWinList(){
        for(int i=0;i<5;i++){
            winList.add(0);
        }
    }

//    private void setEarningList() {
//        earningList.add(0);
//        earningList.add(0);
//        earningList.add(0);
//        earningList.add(5000);
//        earningList.add(50000);
//        earningList.add(1500000);
//        earningList.add(2000000000);
//    }
//
//    public ArrayList<Integer> getEarningList() {
//        return earningList;
//    }


    public void setBonus(int bonus) {
        this.bonus = bonus;
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
            int cnt = checkWinning(lottoList.get(i));
            int idx = -1;
            if (checkBonus(lottoList.get(i)) && cnt==LottoRank.SECOND.getMatch()){
                idx = LottoRank.SECOND.ordinal();
            } else {
                idx = makeIdx(cnt);
            }
            if (idx<0){
                continue;
            }
            winList.set(idx,winList.get(idx)+1);
        }
    }

    public int makeIdx(int cnt){
        switch (cnt){
            case 6: return 0;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            default: return -1;
        }
    }

    private boolean checkBonus(Lotto lotto){
        return lotto.getLotto().contains(bonus);
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
        LottoRank[] val = LottoRank.values();
        for(int i=0;i<5;i++){
            earning += val[i].getEarning() * winList.get(i);
        }
    }

    public int calculate(){
        return (int)((earning*1.0)/money*100);
    }
}
