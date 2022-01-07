package lotto.domain;

import java.util.List;

/**
 * 전반적인 로또 번호 생성을 담당하는 클래스
 * 수동/자동 생성을 담당
 */
public class LottoGenerator {
    private final LottoPaper lp;


    public LottoGenerator(LottoPaper lp) {
        this.lp = lp;
    }

    /**
     * 자동/수동 번호 생성을 하는 메소드
     * @param manualInput 수동으로 입력할 로또 줄의 갯수
     */
    public void generateLotto(int manualInput){
        int numOfAuto = lp.numOfNumbers - manualInput;
        if(manualInput != 0){
            manualGenerate(manualInput);
        }
        autoGenerate(numOfAuto);
        System.out.printf("수동으로 %d장, 자동으로 %d장 구매했습니다.\n", manualInput, numOfAuto);
    }
    public void generateLotto(List<LottoNumbers> ln){
        int numOfAuto = lp.numOfNumbers - ln.size();
        lp.lottoNumbers.addAll(ln);
        autoGenerate(numOfAuto);
    }

    /**
     * 수동 생성을 담당하는 클래스
     * 생성한 로또 줄들을 LottoPaper 객체의 List<LottoNumber> 에 값 추가
     * @param numOfManual 수동으로 입력할 로또 줄의 갯수
     */
    private void manualGenerate(int numOfManual){
        lp.lottoNumbers.addAll(LottoInput.getManualNumbers(numOfManual));
    }

    /**
     * 자동 생성을 담당하는 메서드
     * 자동 생성 후 LottoPaper 객체의 List<LottoNumber> 에 값 추가
     * @param numOfAuto 자동으로 입력할 로또 줄의 갯수
     */
    private void autoGenerate(int numOfAuto){
        for(int i=0;i<numOfAuto;i++){
            LottoNumbers ln = new LottoNumbers();
            lp.add(ln);
        }
    }

    public LottoPaper getLottoPaper() { return lp; }
}
