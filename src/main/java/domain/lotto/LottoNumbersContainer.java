package domain.lotto;

import dto.LottoNumberContainerDTO;
import dto.LottoNumberDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LottoNumbersContainer implements Iterable<LottoNumber>{
    private final ArrayList<LottoNumber> lottoNumbers;

    public LottoNumbersContainer() {
        this.lottoNumbers = new ArrayList<>();
    }

    public LottoNumbersContainer(LottoNumberContainerDTO dto) {
        this();
        ArrayList<LottoNumberDTO> list = dto.getLottoNumbers();
        for (LottoNumberDTO lottoNumberDTO : list) {
            lottoNumbers.add(new LottoNumber(lottoNumberDTO.getArrayListInteger()));
        }
    }

    public LottoNumber get(int i) {
        return lottoNumbers.get(i);
    }

    public int add(LottoNumber lottoNumber) {
        lottoNumbers.add(lottoNumber);
        return lottoNumbers.lastIndexOf(lottoNumber);
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }

    @Override
    public void forEach(Consumer<? super LottoNumber> action) {
        lottoNumbers.forEach(action);
    }

    @Override
    public Spliterator<LottoNumber> spliterator() {
        return lottoNumbers.spliterator();
    }

    public int size() {
        return lottoNumbers.size();
    }

    public LottoNumberContainerDTO getDTO(){
        LottoNumberContainerDTO dto = new LottoNumberContainerDTO();
        for (LottoNumber lottoNumber : lottoNumbers) {
            dto.addLottoNumber(lottoNumber.getDTO());
        }
        return dto;
    }
}
