package domain.lotto;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWallet implements Iterable<Lotto> {

  private final List<Lotto> lottoHolder;

  private LottoWallet(int quantity) {
    this.lottoHolder = generateLottoList(quantity);
  }


  public static LottoWallet create(int quantity) {
    return new LottoWallet(quantity);
  }


  public static LottoWallet createEmpty() {
    return new LottoWallet(0);
  }


  public void addLotto(int quantity) {
    if(quantity < 0) {
      return;
    }
    lottoHolder.addAll(generateLottoList(quantity));
  }


  public void addLotto() {
    addLotto(1);
  }


  public int size() {
    return lottoHolder.size();
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder().append(lottoHolder.size()).append("개를 구매했습니다.").append('\n');
    lottoHolder.forEach(lotto -> sb.append(lotto).append('\n'));
    sb.append('\n');
    return sb.toString();
  }

  private List<Lotto> generateLottoList(int quantity) {
    return Stream.generate(Lotto::ofRandom)
        .limit(quantity)
        .collect(Collectors.toList());
  }


  @Override
  public Iterator<Lotto> iterator() {
    return lottoHolder.iterator();
  }


  @Override
  public void forEach(Consumer<? super Lotto> action) {
    lottoHolder.forEach(action);
  }
}
