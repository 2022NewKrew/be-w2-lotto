package lotto.domain;

public class LottoGenerator {
    private final LottoPaper lp;


    public LottoGenerator(LottoPaper lp) {
        this.lp = lp;
    }

    public void generateLotto(int manualInput){
        int numOfAuto = lp.numOfNumbers - manualInput;
        manualGenerate(manualInput);
        autoGenerate(numOfAuto);
        System.out.printf("수동으로 %d장, 자동으로 %d장 구매했습니다.\n", manualInput, numOfAuto);
    }

    private void manualGenerate(int numOfManual){
        lp.lottoNumbers.addAll(LottoInput.getManualNumbers(numOfManual));
    }

    private void autoGenerate(int numOfAuto){
        for(int i=0;i<numOfAuto;i++){
            LottoNumber ln = new LottoNumber();
            lp.add(ln);
        }
    }

    public LottoPaper getLottoPaper() { return lp; }
}
