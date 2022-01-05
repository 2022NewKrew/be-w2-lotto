package domain.lotto;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 유저가 구매한 로또들의 집합.
 *
 * @author leo.jung
 * @since 1.0
 */
public class LottoWallet implements Iterable<Lotto> {

  private final List<Lotto> lottoHolder;

  private LottoWallet(int quantity) {
    this.lottoHolder = generateLottoList(quantity);
  }


  public static LottoWallet createEmpty() {
    return new LottoWallet(0);
  }


  public void addLotto(int quantity) {
    if (quantity < 0) {
      return;
    }
    lottoHolder.addAll(generateLottoList(quantity));
  }


  public int size() {
    return lottoHolder.size();
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(lottoHolder.size() + "개를 구매했습니다\n");
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
