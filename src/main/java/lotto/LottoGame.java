package main.java.lotto;

import main.java.myexception.NumberRepetitionException;
import main.java.myexception.NotSixNumSelectedException;
import main.java.myexception.UnderThousandException;
import main.java.myexception.UnderZeroOrOverLimitException;

import java.util.*;

public class LottoGame {
    private int money;
    private int earning;
    private int lottoCount;
    private int manualCount;
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
        this.sixNumList = new ArrayList<>();
        this.winList = new ArrayList<>();
        setWinList();
    }

    public void isNotSixNum(ArrayList<Integer> lotto) throws NotSixNumSelectedException {
        if (lotto.size()!=6){
            throw new NotSixNumSelectedException("6개 숫자를 입력해주세요.");
        }
    }


    public void isNumberUnderZeroOrOverLimit(int num) throws UnderZeroOrOverLimitException {
        if(num<=0 || num>45){
            throw new UnderZeroOrOverLimitException("1~45 사이 값이어야 합니다.");
        }
    }

    public void isUnderThousand(int money) throws UnderThousandException {
        if (money<1000){
            throw new UnderThousandException("구매 금액은 1000원 이상이어야 합니다.");
        }
    }

    public void isRepetition(ArrayList<Integer> lotto) throws NumberRepetitionException {
        Set<Integer> set = new HashSet<>();
        set.addAll(lotto);
        if(lotto.size() != set.size()){
            throw new NumberRepetitionException("로또 번호는 중복될 수 없습니다.");
        }
    }


    public void isInvalidManualCount(int manualCount) throws UnderZeroOrOverLimitException {
        if (manualCount<0 || manualCount>money/1000){
            throw new UnderZeroOrOverLimitException("수동 구매 개수는 0보다 커야하고"+money/1000+"보다 작아야 합니다.");
        }
    }


    public void setManualCount(int manualCount) {
        this.manualCount = manualCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    private void setWinList(){
        for(int i=0;i<5;i++){
            winList.add(0);
        }
    }

    public void makeManualLotto(ArrayList<Integer> manualLotto){
        Lotto lotto = new Lotto();
        for(int i=0;i<manualLotto.size();i++){
            lotto.addLotto(manualLotto.get(i));
        }
        lottoList.add(lotto);
    }

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

    public void makeLottoList(){
        LottoGen lottoGen = new LottoGen();
        for(int i=0;i<lottoCount-manualCount;i++){
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
