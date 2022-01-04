package service;

import domain.Lotto;
import domain.WinningLotto;

import java.util.ArrayList;

public class ResultService {
    private ArrayList<Lotto> lottoList = new ArrayList<>();
    private WinningLotto winningLotto;

    public ResultService(ArrayList<Lotto> lottoList, WinningLotto winningLotto){
        this.lottoList = lottoList;
        this.winningLotto = winningLotto;
    }


}
