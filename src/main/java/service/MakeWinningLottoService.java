package service;

import VO.StatsVO;
import domain.Lotto;
import domain.Rank;
import domain.WinningLotto;

import java.util.*;

public class MakeWinningLottoService {
    public Lotto getWinningLotto(String winningLottoString, int bonusNumber) {
        List<String> lottoNumbersStringList = Arrays.asList(winningLottoString.split(","));
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String lottoNumbersString : lottoNumbersStringList) {
            lottoNumbers.add(Integer.parseInt(lottoNumbersString));
        }
        return new WinningLotto(lottoNumbers, bonusNumber);
    }
}
